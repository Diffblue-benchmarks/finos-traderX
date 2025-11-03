package finos.traderx.accountservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import finos.traderx.accountservice.exceptions.ResourceNotFoundException;
import finos.traderx.accountservice.model.Account;
import finos.traderx.accountservice.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccountServiceDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private AccountService accountService;

  /**
   * Method under test: {@link AccountService#getAllAccount()}
   */
  @Test
  void testGetAllAccount() {
    // Arrange
    when(accountRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Account> actualAllAccount = accountService.getAllAccount();

    // Assert
    verify(accountRepository).findAll();
    assertTrue(actualAllAccount.isEmpty());
  }

  /**
   * Method under test: {@link AccountService#getAllAccount()}
   */
  @Test
  void testGetAllAccount2() {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    ArrayList<Account> accountList = new ArrayList<>();
    accountList.add(account);
    when(accountRepository.findAll()).thenReturn(accountList);

    // Act
    List<Account> actualAllAccount = accountService.getAllAccount();

    // Assert
    verify(accountRepository).findAll();
    assertEquals(accountList, actualAllAccount);
  }

  /**
   * Method under test: {@link AccountService#getAllAccount()}
   */
  @Test
  void testGetAllAccount3() {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    Account account2 = new Account();
    account2.setDisplayName("42");
    account2.setId(2);

    ArrayList<Account> accountList = new ArrayList<>();
    accountList.add(account2);
    accountList.add(account);
    when(accountRepository.findAll()).thenReturn(accountList);

    // Act
    List<Account> actualAllAccount = accountService.getAllAccount();

    // Assert
    verify(accountRepository).findAll();
    assertEquals(accountList, actualAllAccount);
  }

  /**
   * Method under test: {@link AccountService#getAllAccount()}
   */
  @Test
  void testGetAllAccount4() {
    // Arrange
    when(accountRepository.findAll()).thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountService.getAllAccount());
    verify(accountRepository).findAll();
  }

  /**
   * Method under test: {@link AccountService#getAccountById(int)}
   */
  @Test
  void testGetAccountById() throws ResourceNotFoundException {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Account actualAccountById = accountService.getAccountById(1);

    // Assert
    verify(accountRepository).findById(eq(1));
    assertSame(account, actualAccountById);
  }

  /**
   * Method under test: {@link AccountService#getAccountById(int)}
   */
  @Test
  void testGetAccountById2() throws ResourceNotFoundException {
    // Arrange
    Optional<Account> emptyResult = Optional.empty();
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountService.getAccountById(1));
    verify(accountRepository).findById(eq(1));
  }

  /**
   * Method under test: {@link AccountService#getAccountById(int)}
   */
  @Test
  void testGetAccountById3() throws ResourceNotFoundException {
    // Arrange
    when(accountRepository.findById(Mockito.<Integer>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountService.getAccountById(1));
    verify(accountRepository).findById(eq(1));
  }

  /**
   * Method under test: {@link AccountService#upsertAccount(Account)}
   */
  @Test
  void testUpsertAccount() {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);

    // Act
    Account actualUpsertAccountResult = accountService.upsertAccount(account2);

    // Assert
    verify(accountRepository).save(isA(Account.class));
    assertSame(account, actualUpsertAccountResult);
  }

  /**
   * Method under test: {@link AccountService#upsertAccount(Account)}
   */
  @Test
  void testUpsertAccount2() {
    // Arrange
    when(accountRepository.save(Mockito.<Account>any())).thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountService.upsertAccount(account));
    verify(accountRepository).save(isA(Account.class));
  }
}
