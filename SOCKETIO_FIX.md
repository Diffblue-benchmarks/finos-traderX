# SocketIOJSONSubscriber Test Context Fix

## Problem Summary

Diffblue Cover was unable to generate tests for `SocketIOJSONSubscriber` methods due to Spring ApplicationContext failures. The issues affected 5 methods:
1. `disconnect()`
2. `internalConnect(URI)`
3. `setDefaultTopic(String)`
4. `subscribe(String)`
5. `unsubscribe(String)`

## Root Cause

The problem had multiple interconnected causes:

1. **Abstract Class Testing**: `SocketIOJSONSubscriber` is an abstract class, so Cover needs to test it through a concrete implementation (`TradeFeedHandler`)

2. **Invalid Configuration**: The auto-generated fake test classes were trying to use:
   ```java
   @ContextConfiguration(classes = {finos.traderx.tradeprocessor.TradeFeedHandler.class})
   ```
   But `TradeFeedHandler` is not a `@Configuration` class - it's a Spring component that extends `SocketIOJSONSubscriber<TradeOrder>`

3. **InitializingBean Problem**: `SocketIOJSONSubscriber` implements `InitializingBean` with an `afterPropertiesSet()` method that:
   - Calls `connect()` which tries to establish a real socket connection
   - Calls `subscribe(defaultTopic)`
   - These operations fail during test context initialization because there's no socket server running

4. **Autowired Dependencies**: `TradeFeedHandler` has an `@Autowired TradeService` field that needs to be mocked

5. **Context Cache Failure**: The error `ApplicationContext failure threshold (1) exceeded` indicates that Spring's test context cache detected a failure and refused to retry loading the same invalid configuration

## Solution

Created a custom base class `SocketIOJSONSubscriberDiffblueBase` that:

1. **Provides Proper TestConfiguration**: Uses `@TestConfiguration` with `@Bean` methods to properly configure the test context

2. **Prevents Socket Connection**: Creates a `TradeFeedHandler` instance that overrides `afterPropertiesSet()` to prevent socket connection attempts during test initialization:
   ```java
   @Override
   public void afterPropertiesSet() throws Exception {
       // Override to prevent socket connection during test context initialization
       // Individual tests can manually call connect() if needed
   }
   ```

3. **Mocks Dependencies**: Provides a mocked `TradeService` bean

4. **Uses Reflection for Injection**: Since we override the class and prevent normal Spring initialization, we manually inject the `TradeService` dependency using reflection

5. **Returns Correct Type**: The bean method returns `SocketIOJSONSubscriber<TradeOrder>` to match what Diffblue Cover expects to autowire

## Implementation Details

The base class leverages Diffblue Cover's automatic base class detection:
- File location: `trade-processor/src/test/java/finos/traderx/messaging/socketio/SocketIOJSONSubscriberDiffblueBase.java`
- Naming convention: `<ClassName>DiffblueBase` in the same package as the class under test
- Cover automatically extends this base class for all tests of `SocketIOJSONSubscriber`

## Why This Works

1. **Valid Spring Configuration**: The `TestConfig` inner class is a proper Spring configuration that can be loaded by the test context

2. **No External Dependencies**: All dependencies are mocked, so tests don't need a running socket server or database

3. **Deferred Initialization**: By overriding `afterPropertiesSet()`, we prevent automatic connection during Spring context loading, but tests can still manually call `connect()` if they need to test connection logic

4. **Proper Bean Types**: By returning `SocketIOJSONSubscriber<TradeOrder>`, Spring can autowire the bean wherever Cover expects it

## Testing the Fix

After compiling the test classes:
```bash
./gradlew :trade-processor:compileTestJava
```

Diffblue Cover should now be able to generate tests for all 5 previously failing methods without Spring context errors.

## Alternative Approaches Considered

1. **Static Mocking**: The error message suggested setting up static mocking for `DefaultCacheAwareContextLoaderDelegate`, but this is overly complex and doesn't address the root cause

2. **@MockBean Approach**: Initially tried using `@MockBean` but this doesn't work well with abstract classes and custom initialization logic

3. **Separate Test Implementation**: Could create a separate concrete test implementation of `SocketIOJSONSubscriber`, but using `TradeFeedHandler` with overrides is more maintainable

## Related Files

- `trade-processor/src/main/java/finos/traderx/messaging/socketio/SocketIOJSONSubscriber.java` - The abstract class being tested
- `trade-processor/src/main/java/finos/traderx/tradeprocessor/TradeFeedHandler.java` - Concrete implementation
- `trade-processor/src/test/java/finos/traderx/tradeprocessor/PubSubConfigDiffblueBase.java` - Similar fix for PubSubConfig issues

## Next Steps

1. Run `./compile-tests.sh` to compile the updated base class
2. Run Diffblue Cover again to generate tests for the 5 methods
3. Verify that tests are generated without Spring context errors
4. Review generated tests to ensure they properly exercise the methods
