package com.example.posttracking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoleMenuPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Menu menu;

    private boolean canAdd;
    private boolean canUpdate;
    private boolean canDelete;
    private boolean canView;
}
