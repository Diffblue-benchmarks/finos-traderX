package finos.traderx.tradeservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TradeOrderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TradeOrder#TradeOrder()}
   *   <li>{@link TradeOrder#getAccountId()}
   *   <li>{@link TradeOrder#getId()}
   *   <li>{@link TradeOrder#getQuantity()}
   *   <li>{@link TradeOrder#getSecurity()}
   *   <li>{@link TradeOrder#getSide()}
   *   <li>{@link TradeOrder#getState()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TradeOrder actualTradeOrder = new TradeOrder();
    Integer actualAccountId = actualTradeOrder.getAccountId();
    String actualId = actualTradeOrder.getId();
    Integer actualQuantity = actualTradeOrder.getQuantity();
    String actualSecurity = actualTradeOrder.getSecurity();
    TradeSide actualSide = actualTradeOrder.getSide();

    // Assert
    assertNull(actualSide);
    assertNull(actualAccountId);
    assertNull(actualQuantity);
    assertNull(actualId);
    assertNull(actualSecurity);
    assertNull(actualTradeOrder.getState());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TradeOrder#TradeOrder(String, int, String, TradeSide, int)}
   *   <li>{@link TradeOrder#getAccountId()}
   *   <li>{@link TradeOrder#getId()}
   *   <li>{@link TradeOrder#getQuantity()}
   *   <li>{@link TradeOrder#getSecurity()}
   *   <li>{@link TradeOrder#getSide()}
   *   <li>{@link TradeOrder#getState()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TradeOrder actualTradeOrder = new TradeOrder("42", 1, "Security", TradeSide.Buy, 1);
    Integer actualAccountId = actualTradeOrder.getAccountId();
    String actualId = actualTradeOrder.getId();
    Integer actualQuantity = actualTradeOrder.getQuantity();
    String actualSecurity = actualTradeOrder.getSecurity();
    TradeSide actualSide = actualTradeOrder.getSide();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Security", actualSecurity);
    assertNull(actualTradeOrder.getState());
    assertEquals(1, actualAccountId.intValue());
    assertEquals(1, actualQuantity.intValue());
    assertEquals(TradeSide.Buy, actualSide);
  }
}
