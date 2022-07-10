package com.EmployeeManagementSys.EmployeeManagementSys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization", orphanRemoval = true)
    private List<Employee> employee;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization", orphanRemoval = true)
    private List<Assets> asset;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Assets> getAsset() {
        return asset;
    }

    public void setAsset(List<Assets> asset) {
        this.asset = asset;
    }
}

