package net.yorksolutions.budgetbe.models;

public class Account {
    public Long id;
    public String name;
    public String type;
    public Double balance;

    public Account(Long id, String name, String type, Double balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }
}
