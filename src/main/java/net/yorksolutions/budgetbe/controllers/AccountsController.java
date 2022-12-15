package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountsController {
    private ArrayList<Account> accounts = new ArrayList<>(List.of(
            new Account(0L,"Main","Checking", 1000.00)
    ));
    private Long nextAccountId = 1L;

    @GetMapping
    public Iterable<Account> getAccounts() {
        return accounts;
    }

    @PutMapping("/{id}")
    public Account putBudgets(@PathVariable Long id, @RequestBody Account account) {
        for (Account a : accounts)
            if (id.equals(a.id)) {
                accounts.remove(a);
                accounts.add(account);
                return account;
            }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Account postAccounts(@RequestBody Account account) {
        account.id = nextAccountId++;
        accounts.add(account);
        return account;
    }

}
