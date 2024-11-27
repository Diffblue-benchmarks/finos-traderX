package finos.traderx.accountservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountUserIDDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return AccountId is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountUserID#AccountUserID()}
   *   <li>{@link AccountUserID#getAccountId()}
   *   <li>{@link AccountUserID#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return AccountId is 'null'")
  void testGettersAndSetters_thenReturnAccountIdIsNull() {
    // Arrange and Act
    AccountUserID actualAccountUserID = new AccountUserID();
    Integer actualAccountId = actualAccountUserID.getAccountId();

    // Assert
    assertNull(actualAccountId);
    assertNull(actualAccountUserID.getUsername());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Username is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountUserID#AccountUserID(Integer, String)}
   *   <li>{@link AccountUserID#getAccountId()}
   *   <li>{@link AccountUserID#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return Username is 'janedoe'")
  void testGettersAndSetters_whenOne_thenReturnUsernameIsJanedoe() {
    // Arrange and Act
    AccountUserID actualAccountUserID = new AccountUserID(1, "janedoe");
    Integer actualAccountId = actualAccountUserID.getAccountId();

    // Assert
    assertEquals("janedoe", actualAccountUserID.getUsername());
    assertEquals(1, actualAccountId.intValue());
  }
}
