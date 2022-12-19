package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Transaction;
import net.yorksolutions.budgetbe.services.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {
    private TransactionsService service;

    public TransactionsController(TransactionsService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Transaction> getTransactions() {
        try {
            return service.getTransactions();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Transaction postTransaction(@RequestBody Transaction transaction) {
        try {
            return service.postTransaction(transaction);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Transaction putTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        try {
            return service.putTransaction(id, transaction);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransaction(@PathVariable Long id) {
        try {
            service.deleteTransaction(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
