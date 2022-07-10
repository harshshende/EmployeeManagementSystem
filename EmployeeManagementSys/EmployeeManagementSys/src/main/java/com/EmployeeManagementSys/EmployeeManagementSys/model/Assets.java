package com.EmployeeManagementSys.EmployeeManagementSys.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Asset Name Should not be empty")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Asset quantity Should not be empty")
    @Column(nullable = false)
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void assignOrg(Organization organization) {
        this.organization= organization;
    }
}
