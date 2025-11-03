package finos.traderx.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class PubSubExceptionDiffblueTest {
  /**
   * Method under test: {@link PubSubException#PubSubException(String)}
   */
  @Test
  void testNewPubSubException() {
    // Arrange and Act
    PubSubException actualPubSubException = new PubSubException("Str");

    // Assert
    assertEquals("Str", actualPubSubException.getMessage());
    assertNull(actualPubSubException.getCause());
    assertEquals(0, actualPubSubException.getSuppressed().length);
  }

  /**
   * Method under test: {@link PubSubException#PubSubException(String, Throwable)}
   */
  @Test
  void testNewPubSubException2() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    PubSubException actualPubSubException = new PubSubException("Str", t);

    // Assert
    assertEquals("Str", actualPubSubException.getMessage());
    assertEquals(0, actualPubSubException.getSuppressed().length);
    assertSame(t, actualPubSubException.getCause());
  }

  /**
   * Method under test: {@link PubSubException#PubSubException(Throwable)}
   */
  @Test
  void testNewPubSubException3() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    PubSubException actualPubSubException = new PubSubException(t);

    // Assert
    assertEquals("java.lang.Throwable", actualPubSubException.getMessage());
    assertEquals(0, actualPubSubException.getSuppressed().length);
    assertSame(t, actualPubSubException.getCause());
  }
}
