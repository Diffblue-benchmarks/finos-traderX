# PubSubConfig Diffblue Cover Issues - Resolution

## Issues Addressed

Two related issues (Issue 1 and Issue 2) reported by Diffblue Cover for test generation on `PubSubConfig` methods:
- `PubSubConfig.positionPublisher()`
- `PubSubConfig.tradePublisher()`

Both issues had severity 0 (blocking).

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

Updated the existing `PubSubConfigDiffblueBase` custom base class to properly handle the Publisher bean ambiguity.

### File Modified:

**`trade-processor/src/test/java/finos/traderx/tradeprocessor/PubSubConfigDiffblueBase.java`**

### How It Works:

1. **Base Class Setup**: The base class uses `@ContextConfiguration` to load both:
   - The actual `PubSubConfig` class (to test its methods)
   - A `TestConfig` class that provides `@Primary` bean implementations

2. **@Primary Bean Overrides**: The `TestConfig` provides simple stub implementations of:
   - `Publisher<Position> positionPublisher()` - marked with `@Primary`
   - `Publisher<Trade> tradePublisher()` - marked with `@Primary`
   - `Subscriber<TradeOrder> tradeFeedHandler()` - marked with `@Primary`

3. **Property Configuration**: Uses `@TestPropertySource` to provide the required `trade.feed.address` property

4. **Prevents @MockBean Usage**: By providing concrete beans via `@Primary`, this prevents Diffblue from attempting to use `@MockBean` to mock generic `Publisher` instances

### Key Changes from Original:

- Added `Subscriber<TradeOrder> tradeFeedHandler()` stub to TestConfig
- Improved documentation explaining the approach
- Ensured all required interface methods are implemented

## Next Steps

**REQUIRED**: Compile the test classes before running Diffblue Cover again:

```bash
./compile-tests.sh
```

Or manually:

```bash
./gradlew :trade-processor:compileTestJava
```

Or using Maven (if configured):

```bash
mvn test-compile -DskipTests
```

After compilation, Diffblue Cover will:
1. Detect the custom base class (following the `[ClassName]DiffblueBase` naming convention)
2. Generate tests that extend `PubSubConfigDiffblueBase`
3. Inherit the `@ContextConfiguration` and Spring setup from the base class
4. Successfully load the Spring context without ambiguity errors

## Technical Details

### Why @Primary Works:

When Spring initializes the test context:
1. It first loads beans from `PubSubConfig` (positionPublisher, tradePublisher, tradeFeedHandler)
2. Then loads beans from `TestConfig` with `@Primary` annotations
3. The `@Primary` beans take precedence, overriding the original beans
4. This prevents any ambiguity when resolving dependencies

### Why This Approach is Necessary:

- Cannot simply avoid loading `PubSubConfig` - we need to test its methods
- Cannot use `@MockBean` with generic types when multiple beans of the same raw type exist
- `@Primary` provides a clean way to override beans without mocking

## Reference

- Diffblue Documentation: https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
- Error Code: R026 - https://diff.blue/R026
- Related Spring Issue: Ambiguous bean resolution with generic types and @MockBean

## Verification

After compiling and running Diffblue Cover again, the issues should be resolved. You can verify by:

1. Running: `dcover issues` - Issues 1 and 2 should no longer appear
2. Checking that tests are generated for `PubSubConfig.positionPublisher()` and `PubSubConfig.tradePublisher()`
3. Running the generated tests to ensure they pass
