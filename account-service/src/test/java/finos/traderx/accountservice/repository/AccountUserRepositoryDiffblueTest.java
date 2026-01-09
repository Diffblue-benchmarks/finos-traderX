package finos.traderx.accountservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import finos.traderx.accountservice.model.AccountUser;
import finos.traderx.accountservice.model.AccountUserID;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {AccountUserRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.accountservice.model"})
class AccountUserRepositoryDiffblueTest {
  @Autowired private AccountUserRepository accountUserRepository;

  /**
   * Test {@link AccountUserRepository#count()}.
   *
   * <p>Method under test: {@link AccountUserRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AccountUserRepository.count()"})
  void testCount() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act and Assert
    assertEquals(2L, accountUserRepository.count());
  }

  /**
   * Test {@link AccountUserRepository#delete(Object)}.
   *
   * <p>Method under test: {@link AccountUserRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountUserRepository.delete(Object)"})
  void testDelete() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");

    AccountUser accountUser3 = new AccountUser();
    accountUser3.setAccountId(1);
    accountUser3.setUsername("janedoe");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);
    accountUserRepository.save(accountUser3);

    // Act
    accountUserRepository.delete(accountUser3);

    // Assert
    Iterable<AccountUser> findAllResult = accountUserRepository.findAll();
    assertTrue(findAllResult instanceof List);
    assertEquals(1, ((List<AccountUser>) findAllResult).size());
    AccountUser getResult = ((List<AccountUser>) findAllResult).get(0);
    assertEquals("Username", getResult.getUsername());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#deleteAll()}.
   *
   * <p>Method under test: {@link AccountUserRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountUserRepository.deleteAll()"})
  void testDeleteAll() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act
    accountUserRepository.deleteAll();

    // Assert
    Iterable<AccountUser> findAllResult = accountUserRepository.findAll();
    assertTrue(findAllResult instanceof List);
    assertTrue(((List<AccountUser>) findAllResult).isEmpty());
  }

  /**
   * Test {@link AccountUserRepository#deleteAllById(Iterable)}.
   *
   * <p>Method under test: {@link AccountUserRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountUserRepository.deleteAllById(Iterable)"})
  void testDeleteAllById() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);
    AccountUserID createAccountUserIDResult =
        AccountUserRepositoryTestFactory.createAccountUserID();
    AccountUserID createAccountUserIDResult2 =
        AccountUserRepositoryTestFactory.createAccountUserID();

    List<AccountUserID> ids =
        Arrays.asList(
            createAccountUserIDResult,
            createAccountUserIDResult2,
            AccountUserRepositoryTestFactory.createAccountUserID());

    // Act
    accountUserRepository.deleteAllById(ids);

    // Assert
    Iterable<AccountUser> findAllResult = accountUserRepository.findAll();
    assertTrue(findAllResult instanceof List);
    assertEquals(2, ((List<AccountUser>) findAllResult).size());
    AccountUser getResult = ((List<AccountUser>) findAllResult).get(1);
    assertEquals("Username", getResult.getUsername());
    AccountUser getResult2 = ((List<AccountUser>) findAllResult).get(0);
    assertEquals("janedoe", getResult2.getUsername());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#deleteAll(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link AccountUserRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountUserRepository.deleteAll(Iterable)"})
  void testDeleteAllWithIterable() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");

    AccountUser accountUser3 = new AccountUser();
    accountUser3.setAccountId(1);
    accountUser3.setUsername("janedoe");

    AccountUser accountUser4 = new AccountUser();
    accountUser4.setAccountId(1);
    accountUser4.setUsername("janedoe");

    AccountUser accountUser5 = new AccountUser();
    accountUser5.setAccountId(1);
    accountUser5.setUsername("janedoe");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);
    accountUserRepository.save(accountUser3);
    accountUserRepository.save(accountUser4);
    accountUserRepository.save(accountUser5);

    List<AccountUser> entities = Arrays.asList(accountUser3, accountUser4, accountUser5);

    // Act
    accountUserRepository.deleteAll(entities);

    // Assert
    Iterable<AccountUser> findAllResult = accountUserRepository.findAll();
    assertTrue(findAllResult instanceof List);
    assertEquals(1, ((List<AccountUser>) findAllResult).size());
    AccountUser getResult = ((List<AccountUser>) findAllResult).get(0);
    assertEquals("Username", getResult.getUsername());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#deleteById(Object)}.
   *
   * <p>Method under test: {@link AccountUserRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountUserRepository.deleteById(Object)"})
  void testDeleteById() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act
    accountUserRepository.deleteById(AccountUserRepositoryTestFactory.createAccountUserID());

    // Assert
    Iterable<AccountUser> findAllResult = accountUserRepository.findAll();
    assertTrue(findAllResult instanceof List);
    assertEquals(2, ((List<AccountUser>) findAllResult).size());
    AccountUser getResult = ((List<AccountUser>) findAllResult).get(1);
    assertEquals("Username", getResult.getUsername());
    AccountUser getResult2 = ((List<AccountUser>) findAllResult).get(0);
    assertEquals("janedoe", getResult2.getUsername());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#existsById(Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link AccountUserID} {@link AccountUserID#getAccountId()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserRepository#existsById(Object)}
   */
  @Test
  @DisplayName(
      "Test existsById(Object); given one; when AccountUserID getAccountId() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccountUserRepository.existsById(Object)"})
  void testExistsById_givenOne_whenAccountUserIDGetAccountIdReturnOne_thenReturnTrue() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    AccountUserID accountUserID = mock(AccountUserID.class);
    when(accountUserID.getAccountId()).thenReturn(1);
    when(accountUserID.getUsername()).thenReturn("janedoe");

    // Act
    boolean actualExistsByIdResult = accountUserRepository.existsById(accountUserID);

    // Assert
    verify(accountUserID).getAccountId();
    verify(accountUserID).getUsername();
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link AccountUserRepository#existsById(Object)}.
   *
   * <ul>
   *   <li>When createAccountUserID.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object); when createAccountUserID; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccountUserRepository.existsById(Object)"})
  void testExistsById_whenCreateAccountUserID_thenReturnFalse() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act and Assert
    assertFalse(
        accountUserRepository.existsById(AccountUserRepositoryTestFactory.createAccountUserID()));
  }

  /**
   * Test {@link AccountUserRepository#findAll()}.
   *
   * <p>Method under test: {@link AccountUserRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AccountUserRepository.findAll()"})
  void testFindAll() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act
    Iterable<AccountUser> actualFindAllResult = accountUserRepository.findAll();

    // Assert
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(2, ((List<AccountUser>) actualFindAllResult).size());
    AccountUser getResult = ((List<AccountUser>) actualFindAllResult).get(1);
    assertEquals("Username", getResult.getUsername());
    AccountUser getResult2 = ((List<AccountUser>) actualFindAllResult).get(0);
    assertEquals("janedoe", getResult2.getUsername());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#findAllById(Iterable)}.
   *
   * <p>Method under test: {@link AccountUserRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AccountUserRepository.findAllById(Iterable)"})
  void testFindAllById() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);
    AccountUserID createAccountUserIDResult =
        AccountUserRepositoryTestFactory.createAccountUserID();
    AccountUserID createAccountUserIDResult2 =
        AccountUserRepositoryTestFactory.createAccountUserID();

    List<AccountUserID> ids =
        Arrays.asList(
            createAccountUserIDResult,
            createAccountUserIDResult2,
            AccountUserRepositoryTestFactory.createAccountUserID());

    // Act
    Iterable<AccountUser> actualFindAllByIdResult = accountUserRepository.findAllById(ids);

    // Assert
    assertTrue(actualFindAllByIdResult instanceof List);
    assertTrue(((List<AccountUser>) actualFindAllByIdResult).isEmpty());
  }

  /**
   * Test {@link AccountUserRepository#findById(Object)}.
   *
   * <p>Method under test: {@link AccountUserRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AccountUserRepository.findById(Object)"})
  void testFindById() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(2);
    accountUser2.setUsername("Username");
    accountUserRepository.save(accountUser);
    accountUserRepository.save(accountUser2);

    // Act and Assert
    assertFalse(
        accountUserRepository
            .findById(AccountUserRepositoryTestFactory.createAccountUserID())
            .isPresent());
  }

  /**
   * Test {@link AccountUserRepository#save(Object)}.
   *
   * <p>Method under test: {@link AccountUserRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AccountUserRepository.save(Object)"})
  void testSave() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    // Act
    AccountUser actualSaveResult = accountUserRepository.save(accountUser);

    // Assert
    assertEquals("janedoe", actualSaveResult.getUsername());
    assertEquals(1, actualSaveResult.getAccountId().intValue());
  }

  /**
   * Test {@link AccountUserRepository#saveAll(Iterable)}.
   *
   * <p>Method under test: {@link AccountUserRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AccountUserRepository.saveAll(Iterable)"})
  void testSaveAll() {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(1);
    accountUser2.setUsername("janedoe");

    AccountUser accountUser3 = new AccountUser();
    accountUser3.setAccountId(1);
    accountUser3.setUsername("janedoe");

    List<AccountUser> entities = Arrays.asList(accountUser, accountUser2, accountUser3);

    // Act
    Iterable<AccountUser> actualSaveAllResult = accountUserRepository.saveAll(entities);

    // Assert
    assertTrue(actualSaveAllResult instanceof List);
    assertEquals(3, ((List<AccountUser>) actualSaveAllResult).size());
    AccountUser getResult = ((List<AccountUser>) actualSaveAllResult).get(0);
    assertEquals("janedoe", getResult.getUsername());
    assertEquals(1, getResult.getAccountId().intValue());
    assertSame(getResult, ((List<AccountUser>) actualSaveAllResult).get(1));
    assertSame(getResult, ((List<AccountUser>) actualSaveAllResult).get(2));
  }
}
