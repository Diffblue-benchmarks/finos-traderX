package finos.traderx.accountservice.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.accountservice.model.AccountUserID;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for creating test objects for AccountUserRepository tests.
 * This factory provides methods to create valid AccountUserID instances for testing.
 */
public class AccountUserRepositoryTestFactory {

  /**
   * Creates a valid AccountUserID instance for testing repository methods.
   * The AccountUserID is created with valid accountId and username values.
   *
   * @return a non-null AccountUserID instance suitable for repository testing
   */
  @InterestingTestFactory
  public static AccountUserID createAccountUserID() {
    return new AccountUserID(1, "testuser");
  }

  /**
   * Creates a valid Iterable&lt;AccountUserID&gt; for testing deleteAllById method.
   * The Iterable contains a single AccountUserID with valid values.
   *
   * @return a non-null Iterable&lt;AccountUserID&gt; instance suitable for repository testing
   */
  @InterestingTestFactory
  public static Iterable<AccountUserID> createAccountUserIDIterable() {
    List<AccountUserID> ids = new ArrayList<>();
    ids.add(new AccountUserID(1, "testuser"));
    return ids;
  }
}
