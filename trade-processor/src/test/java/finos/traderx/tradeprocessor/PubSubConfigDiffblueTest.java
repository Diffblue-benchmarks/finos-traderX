package finos.traderx.tradeprocessor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import finos.traderx.messaging.Subscriber;
import finos.traderx.tradeprocessor.model.TradeOrder;
import org.junit.jupiter.api.Test;

class PubSubConfigDiffblueTest {
  /**
   * Method under test: {@link PubSubConfig#tradeFeedHandler()}
   */
  @Test
  void testTradeFeedHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Subscriber<TradeOrder> actualTradeFeedHandlerResult = (new PubSubConfig()).tradeFeedHandler();

    // Assert
    assertTrue(actualTradeFeedHandlerResult instanceof TradeFeedHandler);
    assertFalse(actualTradeFeedHandlerResult.isConnected());
  }
}
