package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {
    private ArrayList<Transaction> transactions = new ArrayList<>(List.of(
            new Transaction(0L,"Whole Foods",10.00, 0L, 0L)
    ));
    private Long nextTransactionId = 1L;

    @GetMapping
    public Iterable<Transaction> getTransactions() {
        return transactions;
    }

    @PostMapping
    public Transaction postTransaction(@RequestBody Transaction transaction) {
        transaction.id = nextTransactionId++;
        transactions.add(transaction);
        return transaction;
    }

    @PutMapping("/{id}")
    public Transaction putTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        for (Transaction t : transactions) {
            if (id.equals(t.id)) {
                transactions.remove(t);
                transactions.add(transaction);
                return transaction;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
