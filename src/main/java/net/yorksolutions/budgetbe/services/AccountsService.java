package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsService {
    private ArrayList<Account> accounts = new ArrayList<>(List.of(
            new Account(0L,"Main","Checking", 1000.00)
    ));
    private Long nextAccountId = 1L;

    public Iterable<Account> getAccounts() {
        return accounts;
    }

    public Account putBudgets(Long id, Account account) throws Exception {
        for (Account a : accounts)
            if (id.equals(a.id)) {
                accounts.remove(a);
                accounts.add(account);
                return account;
            }
        throw new Exception();
    }

    public Account postAccounts(Account account) {
        account.id = nextAccountId++;
        accounts.add(account);
        return account;
    }
}
