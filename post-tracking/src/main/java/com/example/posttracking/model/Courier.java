package com.example.posttracking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private CourierBranch branch;
}
