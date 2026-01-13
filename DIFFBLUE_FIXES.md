# Diffblue Cover Issues - Resolution Summary

## Issues Addressed

All 5 reported issues were related to the same root cause: Spring ApplicationContext initialization failures when testing `SocketIOJSONSubscriber` methods.

### Affected Methods:
1. `finos.traderx.messaging.socketio.SocketIOJSONSubscriber.disconnect()`
2. `finos.traderx.messaging.socketio.SocketIOJSONSubscriber.internalConnect(URI)`
3. `finos.traderx.messaging.socketio.SocketIOJSONSubscriber.setDefaultTopic(String)`
4. `finos.traderx.messaging.socketio.SocketIOJSONSubscriber.subscribe(String)`
5. `finos.traderx.messaging.socketio.SocketIOJSONSubscriber.unsubscribe(String)`

## Root Cause

Diffblue Cover was attempting to generate tests using Spring's `@ContextConfiguration` with `TradeFeedHandler.class` as the configuration class. However, `TradeFeedHandler` is not a proper `@Configuration` class and cannot successfully initialize a Spring ApplicationContext on its own, resulting in the error:

```
java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded
```

## Solution Implemented

Created a custom base class `SocketIOJSONSubscriberDiffblueBase` that Diffblue Cover will automatically use when generating tests for `SocketIOJSONSubscriber` and its subclasses.

### Files Created/Modified:

1. **`trade-processor/src/test/java/finos/traderx/messaging/socketio/SocketIOJSONSubscriberDiffblueBase.java`**
   - Custom base class using `@ExtendWith(MockitoExtension.class)`
   - Provides Mockito support without requiring Spring context initialization
   - Follows Diffblue naming convention: `[ClassName]DiffblueBase`

2. **`trade-processor/src/test/java/finos/traderx/tradeprocessor/TradeFeedHandlerTestConfig.java`**
   - Test configuration class (optional, for backup if Spring context is needed)
   - Provides proper bean configuration for `TradeFeedHandler`

## Next Steps

**REQUIRED:** Compile the test classes before running Diffblue Cover again:

```bash
./gradlew :trade-processor:testClasses
```

Or using Maven (if configured):

```bash
mvn test-compile -DskipTests
```

After compilation, Diffblue Cover will detect the custom base class and use it instead of attempting Spring context initialization.

## How It Works

1. Diffblue Cover looks for a class named `[ClassName]DiffblueBase` in the same package as the class under test
2. When found, it extends the generated test class from this base class
3. The `@ExtendWith(MockitoExtension.class)` annotation on the base class provides Mockito support
4. This prevents Diffblue from using Spring's `@ContextConfiguration` and allows simple mock-based testing

## Reference

- Diffblue Documentation: https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
- Error Code: R026 - https://diff.blue/R026
