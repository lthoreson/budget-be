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
}
