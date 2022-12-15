package net.yorksolutions.budgetbe.models;

public class Transaction {
    public Long id;
    public String destination;
    public Double amount;
    public Long budget;
    public Long account;

    public Transaction(Long id, String destination, Double amount, Long budget, Long account) {
        this.id = id;
        this.destination = destination;
        this.amount = amount;
        this.budget = budget;
        this.account = account;
    }
}
