package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Destination;
import net.yorksolutions.budgetbe.models.Transaction;
import net.yorksolutions.budgetbe.repositories.BudgetsRepository;
import net.yorksolutions.budgetbe.repositories.DestinationsRepository;
import net.yorksolutions.budgetbe.repositories.TransactionsRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
    private final TransactionsRepository repository;
    private final DestinationsRepository destinationsRepository;
    private final BudgetsRepository budgetsRepository;

    public TransactionsService(TransactionsRepository repository, DestinationsRepository destinationsRepository, BudgetsRepository budgetsRepository) {
        this.repository = repository;
        this.destinationsRepository = destinationsRepository;
        this.budgetsRepository = budgetsRepository;
    }

    public Iterable<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction postTransaction(Transaction transaction) {
        Transaction newTrans = new Transaction();
        newTrans.destination = transaction.destination;
        newTrans.amount = transaction.amount;
        newTrans.budget = transaction.budget;
        newTrans.account = transaction.account;
        updateDestination(newTrans);
        return repository.save(newTrans);
    }

    public Transaction putTransaction(Long id, Transaction transaction) throws Exception {
        Transaction existingTrans = repository.findById(id).orElse(null);
        if (existingTrans == null) {
            throw new Exception();
        }
        existingTrans.amount = transaction.amount;
        existingTrans.budget = transaction.budget;
        existingTrans.account = transaction.account;
        updateDestination(existingTrans);
        return repository.save(transaction);
    }

    private void updateDestination(Transaction transaction) {
        final var destination = destinationsRepository.findDestinationByName(transaction.destination).orElse(null);
        if (destination == null) {
            Destination newDestination = new Destination();
            newDestination.name = transaction.destination;
            if (transaction.budget != null)
                newDestination.budget = budgetsRepository.findById(transaction.budget).orElse(null);
            destinationsRepository.save(newDestination);
        } else if (destination.budget == null && transaction.budget != null) {
            destination.budget = budgetsRepository.findById(transaction.budget).orElse(null);
            destinationsRepository.save(destination);
        }
    }

    public void deleteTransaction(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new Exception();
    }
}
