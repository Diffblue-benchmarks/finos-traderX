package finos.traderx.messaging.socketio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import finos.traderx.messaging.PubSubException;
import finos.traderx.tradeprocessor.TradeFeedHandler;
import io.socket.client.IO;
import org.junit.jupiter.api.Test;

class SocketIOJSONSubscriberDiffblueTest {
  /**
   * Method under test: {@link SocketIOJSONSubscriber#getIOOptions()}
   */
  @Test
  void testGetIOOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    IO.Options actualIOOptions = (new TradeFeedHandler()).getIOOptions();

    // Assert
    assertNull(actualIOOptions.transports);
    assertNull(actualIOOptions.decoder);
    assertNull(actualIOOptions.encoder);
    assertNull(actualIOOptions.host);
    assertNull(actualIOOptions.query);
    assertNull(actualIOOptions.hostname);
    assertNull(actualIOOptions.path);
    assertNull(actualIOOptions.timestampParam);
    assertNull(actualIOOptions.transportOptions);
    assertNull(actualIOOptions.auth);
    assertNull(actualIOOptions.extraHeaders);
    assertNull(actualIOOptions.callFactory);
    assertNull(actualIOOptions.webSocketFactory);
    assertEquals(-1, actualIOOptions.policyPort);
    assertEquals(-1, actualIOOptions.port);
    assertEquals(0, actualIOOptions.reconnectionAttempts);
    assertEquals(0.0d, actualIOOptions.randomizationFactor);
    assertEquals(0L, actualIOOptions.reconnectionDelay);
    assertEquals(0L, actualIOOptions.reconnectionDelayMax);
    assertEquals(20000L, actualIOOptions.timeout);
    assertFalse(actualIOOptions.forceNew);
    assertFalse(actualIOOptions.rememberUpgrade);
    assertFalse(actualIOOptions.secure);
    assertFalse(actualIOOptions.timestampRequests);
    assertTrue(actualIOOptions.multiplex);
    assertTrue(actualIOOptions.reconnection);
    assertTrue(actualIOOptions.upgrade);
  }

  /**
   * Method under test: {@link SocketIOJSONSubscriber#isConnected()}
   */
  @Test
  void testIsConnected() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TradeFeedHandler()).isConnected());
  }

  /**
   * Method under test: {@link SocketIOJSONSubscriber#afterPropertiesSet()}
   */
  @Test
  void testAfterPropertiesSet() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TradeFeedHandler tradeFeedHandler = new TradeFeedHandler();
    tradeFeedHandler.setSocketAddress("42 Main St");

    // Act and Assert
    assertThrows(PubSubException.class, () -> tradeFeedHandler.afterPropertiesSet());
  }

  /**
   * Method under test: {@link SocketIOJSONSubscriber#afterPropertiesSet()}
   */
  @Test
  void testAfterPropertiesSet2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TradeFeedHandler tradeFeedHandler = new TradeFeedHandler();
    tradeFeedHandler.setSocketAddress("Addr");

    // Act and Assert
    assertThrows(PubSubException.class, () -> tradeFeedHandler.afterPropertiesSet());
  }
}
