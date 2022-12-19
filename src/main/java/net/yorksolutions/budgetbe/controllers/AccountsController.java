package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.services.AccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountsController {
    private AccountsService service;

    public AccountsController(AccountsService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Account> getAccounts() {
        try {
            return this.service.getAccounts();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public Account putAccounts(@PathVariable Long id, @RequestBody Account account) {
        try {
            return this.service.putAccounts(id, account);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Account postAccounts(@RequestBody Account account) {
        try {
            return this.service.postAccounts(account);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
