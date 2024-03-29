package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.dto.FrontBudget;
import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.services.BudgetsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/budgets")
@CrossOrigin
public class BudgetsController {
    private BudgetsService service;

    public BudgetsController(BudgetsService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Budget> getBudgets() {
        try {
            return service.getBudgets();
        } catch (Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public Budget putBudgets(@PathVariable Long id, @RequestBody Budget budget) {
        try {
            return service.putBudgets(id, budget);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Budget postBudgets(@RequestBody FrontBudget budget) {
        try {
            return service.postBudgets(budget);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
