package net.yorksolutions.budgetbe.models;

import java.util.ArrayList;

public class Budget {
    public Long id;
    public String name;
    public Double total;
    public ArrayList<String> associations;

    public Budget(Long id, String name, Double total, ArrayList<String> associations) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.associations = associations;
    }
}
