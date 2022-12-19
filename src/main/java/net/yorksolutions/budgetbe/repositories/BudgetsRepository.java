package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetsRepository extends CrudRepository<Budget, Long> {
}
