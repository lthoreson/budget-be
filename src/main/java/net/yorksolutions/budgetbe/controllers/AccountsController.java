package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Account postAccounts(@RequestBody Account account) {
        account.id = nextAccountId++;
        accounts.add(account);
        return account;
    }

}
