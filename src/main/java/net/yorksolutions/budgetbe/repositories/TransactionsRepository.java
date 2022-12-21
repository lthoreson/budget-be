package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Long> {
}
