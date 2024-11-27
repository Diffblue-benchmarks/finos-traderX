package finos.traderx.positionservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionIDDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return AccountId is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PositionID#PositionID()}
   *   <li>{@link PositionID#getAccountId()}
   *   <li>{@link PositionID#getSecurity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return AccountId is 'null'")
  void testGettersAndSetters_thenReturnAccountIdIsNull() {
    // Arrange and Act
    PositionID actualPositionID = new PositionID();
    Integer actualAccountId = actualPositionID.getAccountId();

    // Assert
    assertNull(actualAccountId);
    assertNull(actualPositionID.getSecurity());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Security}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PositionID#PositionID(Integer, String)}
   *   <li>{@link PositionID#getAccountId()}
   *   <li>{@link PositionID#getSecurity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return 'Security'")
  void testGettersAndSetters_whenOne_thenReturnSecurity() {
    // Arrange and Act
    PositionID actualPositionID = new PositionID(1, "Security");
    Integer actualAccountId = actualPositionID.getAccountId();

    // Assert
    assertEquals("Security", actualPositionID.getSecurity());
    assertEquals(1, actualAccountId.intValue());
  }
}
