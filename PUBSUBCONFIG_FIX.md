# PubSubConfig Test Generation Fix

## Problem
Diffblue Cover was unable to generate tests for `PubSubConfig.positionPublisher()` and `PubSubConfig.tradePublisher()` due to Spring Boot test context initialization failures.

### Root Cause
The `PubSubConfig` class defines two beans of type `Publisher<?>`:
- `positionPublisher` returning `Publisher<Position>`
- `tradePublisher` returning `Publisher<Trade>`

When Diffblue Cover attempted to create tests with `@MockBean Publisher publisher`, Spring Boot's `MockitoPostProcessor` couldn't determine which bean to replace because there were multiple `Publisher` beans, resulting in:

```
java.lang.IllegalStateException: Unable to register mock bean finos.traderx.messaging.Publisher<?>
expected a single matching bean to replace but found [positionPublisher, tradePublisher]
```

## Solution Implemented

### 1. Created Custom Base Class
Created `/trade-processor/src/test/java/finos/traderx/tradeprocessor/PubSubConfigDiffblueBase.java`

This base class:
- Provides a proper Spring test configuration
- Implements mock/stub `Publisher` beans for both `Position` and `Trade` types
- Uses `@Primary` annotation to ensure these test beans take precedence
- Includes `@TestPropertySource` to provide required `trade.feed.address` property
- Properly implements all methods from the `Publisher` interface (publish, isConnected, connect, disconnect)

### 2. Created Test Properties
Created `/trade-processor/src/test/resources/application-test.properties` with the required test property.

## How Diffblue Cover Should Use This

When generating tests for `PubSubConfig` methods, Diffblue Cover should:

1. Have test classes extend `PubSubConfigDiffblueBase` instead of using standalone test configurations
2. This will ensure proper Spring context initialization without bean ambiguity
3. The base class handles all the complex setup automatically

Example:
```java
public class PubSubConfigTest extends PubSubConfigDiffblueBase {
    @Autowired
    private PubSubConfig pubSubConfig;

    @Test
    public void testPositionPublisher() {
        Publisher<Position> publisher = pubSubConfig.positionPublisher();
        assertNotNull(publisher);
    }
}
```

## Next Steps

1. Run `./compile-tests.sh` or `./gradlew :trade-processor:compileTestJava` to compile the new base class
2. Re-run Diffblue Cover test generation - it should now be able to generate tests for `PubSubConfig` methods

## Related Issues
- Resolves Issue 1: Test creation for `PubSubConfig.positionPublisher()`
- Resolves Issue 2: Test creation for `PubSubConfig.tradePublisher()`
