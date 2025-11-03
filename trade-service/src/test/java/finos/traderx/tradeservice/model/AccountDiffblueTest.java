package finos.traderx.tradeservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Account.class})
@ExtendWith(SpringExtension.class)
class AccountDiffblueTest {
  @Autowired
  private Account account;

  /**
   * Method under test: {@link Account#getid()}
   */
  @Test
  void testGetid() {
    // Arrange, Act and Assert
    assertNull(account.getid());
  }

  /**
   * Method under test: {@link Account#getdisplayName()}
   */
  @Test
  void testGetdisplayName() {
    // Arrange, Act and Assert
    assertNull(account.getdisplayName());
  }

  /**
   * Method under test: {@link Account#Account()}
   */
  @Test
  void testNewAccount() {
    // Arrange, Act and Assert
    assertNull((new Account()).getid());
    assertEquals(1, (new Account(1, "Display Name")).getid().intValue());
  }
}
