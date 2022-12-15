package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/budgets")
@CrossOrigin
public class BudgetsController {
    private ArrayList<Budget> budgets = new ArrayList<>(List.of(
            new Budget(0L,"Grocery",1000.00, new ArrayList<String>())
    ));
    private Long nextBudgetId = 1L;

    @GetMapping
    public Iterable<Budget> getBudgets() {
        return budgets;
    }

    @PutMapping("/{id}")
    public Budget putBudgets(@PathVariable Long id, @RequestBody Budget budget) {
        for (Budget b : budgets)
            if (id.equals(b.id)) {
                budgets.remove(b);
                budgets.add(budget);
                return budget;
            }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Budget postBudgets(@RequestBody Budget budget) {
        budget.id = nextBudgetId++;
        budgets.add(budget);
        return budget;
    }
}
