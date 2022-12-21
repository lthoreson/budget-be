package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.dto.FrontBudget;
import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.repositories.BudgetsRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetsService {
    private BudgetsRepository repository;

    public BudgetsService(BudgetsRepository repository) {
        this.repository = repository;
    }

    public Iterable<Budget> getBudgets() {
        return repository.findAll();
    }

    public Budget putBudgets(Long id, Budget budget) throws Exception {
        if (repository.existsById(id)) {
            return repository.save(budget);
        }
        throw new Exception();
    }

    public Budget postBudgets(FrontBudget budget) {
        final var newBudget = new Budget();
        newBudget.name = budget.name;
        newBudget.total = budget.total;
        return repository.save(newBudget);
    }
}
