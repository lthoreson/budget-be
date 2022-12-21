package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
    @OneToOne
    public Budget budget;
}
