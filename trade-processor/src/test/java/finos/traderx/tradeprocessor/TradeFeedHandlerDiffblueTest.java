package finos.traderx.tradeprocessor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class TradeFeedHandlerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TradeFeedHandler}
   */
  @Test
  void testNewTradeFeedHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TradeFeedHandler()).isConnected());
  }
}
