package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetsService {
    private ArrayList<Budget> budgets = new ArrayList<>(List.of(
            new Budget(0L,"Grocery",1000.00, new ArrayList<String>())
    ));
    private Long nextBudgetId = 1L;

    public ArrayList<Budget> getBudgets() {
        return budgets;
    }

    public Budget putBudgets(Long id, Budget budget) throws Exception {
        for (Budget b : budgets)
            if (id.equals(b.id)) {
                budgets.remove(b);
                budgets.add(budget);
                return budget;
            }
        throw new Exception();
    }

    public Budget postBudgets(Budget budget) {
        budget.id = nextBudgetId++;
        budgets.add(budget);
        return budget;
    }
}
