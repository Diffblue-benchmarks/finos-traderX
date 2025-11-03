package finos.traderx.tradeprocessor.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TradeResponseDiffblueTest {
  /**
   * Method under test: {@link TradeResponse#success(String)}
   */
  @Test
  void testSuccess() {
    // Arrange and Act
    TradeResponse actualSuccessResult = TradeResponse.success("42");

    // Assert
    assertEquals("42", actualSuccessResult.getId());
    assertNull(actualSuccessResult.getErrorMessage());
    assertTrue(actualSuccessResult.isSuccess());
  }

  /**
   * Method under test: {@link TradeResponse#error(String)}
   */
  @Test
  void testError() {
    // Arrange and Act
    TradeResponse actualErrorResult = TradeResponse.error("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualErrorResult.getErrorMessage());
    assertNull(actualErrorResult.getId());
    assertFalse(actualErrorResult.isSuccess());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TradeResponse}
   *   <li>{@link TradeResponse#setErrorMessage(String)}
   *   <li>{@link TradeResponse#setId(String)}
   *   <li>{@link TradeResponse#setSuccess(boolean)}
   *   <li>{@link TradeResponse#getErrorMessage()}
   *   <li>{@link TradeResponse#getId()}
   *   <li>{@link TradeResponse#isSuccess()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TradeResponse actualTradeResponse = new TradeResponse();
    actualTradeResponse.setErrorMessage("An error occurred");
    actualTradeResponse.setId("42");
    actualTradeResponse.setSuccess(true);
    String actualErrorMessage = actualTradeResponse.getErrorMessage();
    String actualId = actualTradeResponse.getId();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("An error occurred", actualErrorMessage);
    assertTrue(actualTradeResponse.isSuccess());
  }
}
