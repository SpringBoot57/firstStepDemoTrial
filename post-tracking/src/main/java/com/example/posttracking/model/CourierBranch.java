package com.example.posttracking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourierBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactNumber;
    private String address;
    private String area;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private CourierAgency agency;
}
