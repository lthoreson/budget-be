package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
    public Double total;
    @ElementCollection
    public ArrayList<String> associations;

    public Budget(Long id, String name, Double total, ArrayList<String> associations) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.associations = associations;
    }

    public Budget() {

    }
}
