package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Transaction;
import net.yorksolutions.budgetbe.repositories.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService {
    private TransactionsRepository repository;

    public TransactionsService(TransactionsRepository repository) {
        this.repository = repository;
    }

    public Iterable<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction postTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction putTransaction(Long id, Transaction transaction) throws Exception {
        if (repository.existsById(id)) {
            return repository.save(transaction);
        }
        throw new Exception();
    }

    public void deleteTransaction(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new Exception();
    }
}
