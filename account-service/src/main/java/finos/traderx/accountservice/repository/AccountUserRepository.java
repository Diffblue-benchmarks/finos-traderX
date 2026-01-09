package finos.traderx.accountservice.repository;

import finos.traderx.accountservice.model.AccountUser;
import finos.traderx.accountservice.model.AccountUserID;

import org.springframework.data.repository.CrudRepository;

public interface AccountUserRepository extends CrudRepository<AccountUser, AccountUserID> {
}
