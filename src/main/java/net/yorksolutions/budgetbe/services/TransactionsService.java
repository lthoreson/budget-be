package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService {
    private ArrayList<Transaction> transactions = new ArrayList<>(List.of(
            new Transaction(0L,"Whole Foods",10.00, 0L, 0L)
    ));
    private Long nextTransactionId = 1L;

    public Iterable<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction postTransaction(Transaction transaction) {
        transaction.id = nextTransactionId++;
        transactions.add(transaction);
        return transaction;
    }

    public Transaction putTransaction(Long id, Transaction transaction) throws Exception {
        for (Transaction t : transactions) {
            if (id.equals(t.id)) {
                transactions.remove(t);
                transactions.add(transaction);
                return transaction;
            }
        }
        throw new Exception();
    }

    public void deleteTransaction(Long id) throws Exception {
        for (Transaction transaction : transactions) {
            if (id.equals(transaction.id)) {
                transactions.remove(transaction);
                return;
            }
        }
        throw new Exception();
    }
}
