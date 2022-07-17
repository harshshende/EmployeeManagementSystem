package com.EmployeeManagementSys.EmployeeManagementSys.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Organization Name Should not be Empty")
    private String name;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization")
    private List<Employee> employee;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization")
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

