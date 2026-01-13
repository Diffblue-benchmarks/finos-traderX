# PubSubConfig Diffblue Cover Issues - Resolution

## Issues Addressed

Two related issues (Issue 1 and Issue 2) reported by Diffblue Cover for test generation on `PubSubConfig` methods:
- **Issue 1**: `PubSubConfig.positionPublisher()` - severity 0 (blocking)
- **Issue 2**: `PubSubConfig.tradePublisher()` - severity 0 (blocking)

## Root Cause

Diffblue Cover was attempting to generate tests for `PubSubConfig` methods using Spring's `@MockBean` annotation to mock `Publisher` beans. However, `PubSubConfig` defines two beans with the same raw type but different generic parameters:
- `Publisher<Position> positionPublisher()`
- `Publisher<Trade> tradePublisher()`

When Diffblue tried to use `@MockBean finos.traderx.messaging.Publisher publisher;`, Spring could not determine which bean to mock, resulting in:

```
java.lang.IllegalStateException: Unable to register mock bean finos.traderx.messaging.Publisher<?>
expected a single matching bean to replace but found [positionPublisher, tradePublisher]
```

## Solution Implemented

### Fixed Compilation Issue in PubSubConfigDiffblueBase

The existing `PubSubConfigDiffblueBase` custom base class had a critical bug preventing compilation:
- The stub implementations of `Publisher` and `Subscriber` interfaces were missing the required `throws PubSubException` declarations
- The interfaces define methods that throw `PubSubException`, but the anonymous implementations didn't declare this

### Changes Made

**File Modified**: `trade-processor/src/test/java/finos/traderx/tradeprocessor/PubSubConfigDiffblueBase.java`

Added `throws finos.traderx.messaging.PubSubException` to the following methods in all stub implementations:
- `Publisher.publish(T message)`
- `Publisher.publish(String topic, T message)`
- `Publisher.connect()`
- `Publisher.disconnect()`
- `Subscriber.subscribe(String topic)`
- `Subscriber.unsubscribe(String topic)`
- `Subscriber.connect()`
- `Subscriber.disconnect()`

### How the Base Class Works

1. **Base Class Setup**: Uses `@ContextConfiguration` to load both:
   - The actual `PubSubConfig` class (to test its methods)
   - A `TestConfig` class that provides `@Primary` bean implementations

2. **@Primary Bean Overrides**: The `TestConfig` provides simple stub implementations of:
   - `Publisher<Position> positionPublisher()` - marked with `@Primary`
   - `Publisher<Trade> tradePublisher()` - marked with `@Primary`
   - `Subscriber<TradeOrder> tradeFeedHandler()` - marked with `@Primary`

3. **Property Configuration**: Uses `@TestPropertySource` to provide the required `trade.feed.address` property

4. **Prevents @MockBean Usage**: By providing concrete beans via `@Primary`, this prevents Diffblue from attempting to use `@MockBean` to mock generic `Publisher` instances

## Next Steps

**REQUIRED**: Compile the test classes before running Diffblue Cover again:

```bash
./compile-tests.sh
```

Or using Gradle directly:

```bash
./gradlew :trade-processor:compileTestJava
```

Or using Maven (if applicable):

```bash
mvn test-compile -DskipTests
```

After compilation, Diffblue Cover will:
1. Detect the custom base class (following the `[ClassName]DiffblueBase` naming convention)
2. Generate tests that extend `PubSubConfigDiffblueBase`
3. Inherit the `@ContextConfiguration` and Spring setup from the base class
4. Successfully load the Spring context without ambiguity errors

## Technical Details

### Why @Primary Works

When Spring initializes the test context:
1. It first loads beans from `PubSubConfig` (positionPublisher, tradePublisher, tradeFeedHandler)
2. Then loads beans from `TestConfig` with `@Primary` annotations
3. The `@Primary` beans take precedence, overriding the original beans
4. This prevents any ambiguity when resolving dependencies

### Why Exception Declarations Are Critical

- The `Publisher` and `Subscriber` interfaces define checked exceptions on their methods
- Anonymous implementations must declare these exceptions or the code won't compile
- Without compilation, Diffblue Cover cannot find the base class on the classpath
- This was the blocking issue preventing the base class from being used

## Verification

After compiling and running Diffblue Cover again, the issues should be resolved. You can verify by:

1. Running: `dcover issues` - Issues 1 and 2 should no longer appear
2. Checking that tests are generated for `PubSubConfig.positionPublisher()` and `PubSubConfig.tradePublisher()`
3. Running the generated tests to ensure they pass

## Reference

- Diffblue Documentation: https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
- Error Code: R026 - https://diff.blue/R026
- Related Spring Issue: Ambiguous bean resolution with generic types and @MockBean
