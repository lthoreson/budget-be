package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
}
