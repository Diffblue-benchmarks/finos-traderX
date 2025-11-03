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
import finos.traderx.accountservice.model.AccountUser;
import finos.traderx.accountservice.repository.AccountRepository;
import finos.traderx.accountservice.repository.AccountUserRepository;
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

@ContextConfiguration(classes = {AccountUserService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccountUserServiceDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private AccountUserRepository accountUserRepository;

  @Autowired
  private AccountUserService accountUserService;

  /**
   * Method under test: {@link AccountUserService#getAllAccountUsers()}
   */
  @Test
  void testGetAllAccountUsers() {
    // Arrange
    when(accountUserRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<AccountUser> actualAllAccountUsers = accountUserService.getAllAccountUsers();

    // Assert
    verify(accountUserRepository).findAll();
    assertTrue(actualAllAccountUsers.isEmpty());
  }

  /**
   * Method under test: {@link AccountUserService#getAllAccountUsers()}
   */
  @Test
  void testGetAllAccountUsers2() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    ArrayList<AccountUser> accountUserList = new ArrayList<>();
    accountUserList.add(accountUser);
    when(accountUserRepository.findAll()).thenReturn(accountUserList);

    // Act
    List<AccountUser> actualAllAccountUsers = accountUserService.getAllAccountUsers();

    // Assert
    verify(accountUserRepository).findAll();
    assertEquals(accountUserList, actualAllAccountUsers);
  }

  /**
   * Method under test: {@link AccountUserService#getAllAccountUsers()}
   */
  @Test
  void testGetAllAccountUsers3() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");

    ArrayList<AccountUser> accountUserList = new ArrayList<>();
    accountUserList.add(accountUser2);
    accountUserList.add(accountUser);
    when(accountUserRepository.findAll()).thenReturn(accountUserList);

    // Act
    List<AccountUser> actualAllAccountUsers = accountUserService.getAllAccountUsers();

    // Assert
    verify(accountUserRepository).findAll();
    assertEquals(accountUserList, actualAllAccountUsers);
  }

  /**
   * Method under test: {@link AccountUserService#getAllAccountUsers()}
   */
  @Test
  void testGetAllAccountUsers4() {
    // Arrange
    when(accountUserRepository.findAll()).thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountUserService.getAllAccountUsers());
    verify(accountUserRepository).findAll();
  }

  /**
   * Method under test: {@link AccountUserService#getAccountUserById(int)}
   */
  @Test
  void testGetAccountUserById() throws ResourceNotFoundException {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");
    Optional<AccountUser> ofResult = Optional.of(accountUser);
    when(accountUserRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    AccountUser actualAccountUserById = accountUserService.getAccountUserById(1);

    // Assert
    verify(accountUserRepository).findById(eq(1));
    assertSame(accountUser, actualAccountUserById);
  }

  /**
   * Method under test: {@link AccountUserService#getAccountUserById(int)}
   */
  @Test
  void testGetAccountUserById2() throws ResourceNotFoundException {
    // Arrange
    Optional<AccountUser> emptyResult = Optional.empty();
    when(accountUserRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountUserService.getAccountUserById(1));
    verify(accountUserRepository).findById(eq(1));
  }

  /**
   * Method under test: {@link AccountUserService#getAccountUserById(int)}
   */
  @Test
  void testGetAccountUserById3() throws ResourceNotFoundException {
    // Arrange
    when(accountUserRepository.findById(Mockito.<Integer>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountUserService.getAccountUserById(1));
    verify(accountUserRepository).findById(eq(1));
  }

  /**
   * Method under test: {@link AccountUserService#upsertAccountUser(AccountUser)}
   */
  @Test
  void testUpsertAccountUser() {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");
    when(accountUserRepository.save(Mockito.<AccountUser>any())).thenReturn(accountUser);

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(1);
    accountUser2.setUsername("janedoe");

    // Act
    AccountUser actualUpsertAccountUserResult = accountUserService.upsertAccountUser(accountUser2);

    // Assert
    verify(accountRepository).findById(eq(1));
    verify(accountUserRepository).save(isA(AccountUser.class));
    assertSame(accountUser, actualUpsertAccountUserResult);
  }

  /**
   * Method under test: {@link AccountUserService#upsertAccountUser(AccountUser)}
   */
  @Test
  void testUpsertAccountUser2() {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(accountUserRepository.save(Mockito.<AccountUser>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountUserService.upsertAccountUser(accountUser));
    verify(accountRepository).findById(eq(1));
    verify(accountUserRepository).save(isA(AccountUser.class));
  }

  /**
   * Method under test: {@link AccountUserService#upsertAccountUser(AccountUser)}
   */
  @Test
  void testUpsertAccountUser3() {
    // Arrange
    Optional<Account> emptyResult = Optional.empty();
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> accountUserService.upsertAccountUser(accountUser));
    verify(accountRepository).findById(eq(1));
  }
}
