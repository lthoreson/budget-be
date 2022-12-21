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

    public Transaction postTransaction(Transaction transaction) throws Exception {
        createDest(transaction);
        return repository.save(transaction);
    }

    public Transaction putTransaction(Long id, Transaction transaction) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception();
        }
        createDest(transaction);
        return repository.save(transaction);
    }

    private Destination createDest(Transaction transaction) throws Exception{
        final var destination = destinationsRepository.findDestinationByName(transaction.destination).orElse(null);
        if (destination == null) {
            Destination newDestination = new Destination();
            newDestination.name = transaction.destination;
            newDestination.budget = budgetsRepository.findById(transaction.budget).orElse(null);
            destinationsRepository.save(newDestination);
            return newDestination;
        } else if (destination.budget == null && transaction.budget != null) {
            destination.budget = budgetsRepository.findById(transaction.budget).orElse(null);
            return destination;
        }
        return null;
    }

    public void deleteTransaction(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new Exception();
    }
}
