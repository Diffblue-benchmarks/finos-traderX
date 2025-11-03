package finos.traderx.accountservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Account}
   *   <li>{@link Account#setDisplayName(String)}
   *   <li>{@link Account#setId(int)}
   *   <li>{@link Account#getDisplayName()}
   *   <li>{@link Account#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Account actualAccount = new Account();
    actualAccount.setDisplayName("Display Name");
    actualAccount.setId(1);
    String actualDisplayName = actualAccount.getDisplayName();

    // Assert that nothing has changed
    assertEquals("Display Name", actualDisplayName);
    assertEquals(1, actualAccount.getId());
  }
}
