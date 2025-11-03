package finos.traderx.accountservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import finos.traderx.accountservice.model.AccountUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {AccountUserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.accountservice.model"})
@DataJpaTest
class AccountUserRepositoryDiffblueTest {
  @Autowired
  private AccountUserRepository accountUserRepository;

  /**
   * Method under test: {@link AccountUserRepository#count()}
   */
  @Test
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
   * Method under test: {@link AccountUserRepository#delete(Object)}
   */
  @Test
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
   * Method under test: {@link AccountUserRepository#deleteAll()}
   */
  @Test
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
   * Method under test: {@link AccountUserRepository#deleteAll(Iterable)}
   */
  @Test
  void testDeleteAll2() {
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
   * Method under test: {@link AccountUserRepository#deleteAllById(Iterable)}
   */
  @Test
  void testDeleteAllById() {
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
    Iterable<Integer> ids = mock(Iterable.class);

    ArrayList<Integer> integerList = new ArrayList<>();
    when(ids.iterator()).thenReturn(integerList.iterator());

    // Act
    accountUserRepository.deleteAllById(ids);

    // Assert
    verify(ids).iterator();
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
   * Method under test: {@link AccountUserRepository#findAll()}
   */
  @Test
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
   * Method under test: {@link AccountUserRepository#findAllById(Iterable)}
   */
  @Test
  void testFindAllById() {
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
    Iterable<Integer> ids = mock(Iterable.class);

    ArrayList<Integer> integerList = new ArrayList<>();
    when(ids.iterator()).thenReturn(integerList.iterator());

    // Act
    Iterable<AccountUser> actualFindAllByIdResult = accountUserRepository.findAllById(ids);

    // Assert
    verify(ids).iterator();
    assertTrue(actualFindAllByIdResult instanceof List);
    assertTrue(((List<AccountUser>) actualFindAllByIdResult).isEmpty());
  }

  /**
   * Method under test: {@link AccountUserRepository#save(Object)}
   */
  @Test
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
   * Method under test: {@link AccountUserRepository#saveAll(Iterable)}
   */
  @Test
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
