package finos.traderx.tradeservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Security.class})
@ExtendWith(SpringExtension.class)
class SecurityDiffblueTest {
  @Autowired
  private Security security;

  /**
   * Method under test: {@link Security#getcompanyName()}
   */
  @Test
  void testGetcompanyName() {
    // Arrange, Act and Assert
    assertNull(security.getcompanyName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Security#Security()}
   *   <li>{@link Security#getTicker()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new Security()).getTicker());
    assertEquals("Ticker", (new Security("Ticker", "Company Name")).getTicker());
  }
}
