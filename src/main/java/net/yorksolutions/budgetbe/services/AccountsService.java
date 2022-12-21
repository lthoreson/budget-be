package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.repositories.AccountsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
    private AccountsRepository repository;

    public AccountsService(AccountsRepository repository) {
        this.repository = repository;
    }

    public Iterable<Account> getAccounts() {
        return repository.findAll();
    }

    public Account putAccounts(Long id, Account account) throws Exception {
        if (repository.existsById(id)) {
            repository.save(account);
            return account;
        }
        throw new Exception();
    }

    public Account postAccounts(Account account) {
        repository.save(account);
        return account;
    }
}
