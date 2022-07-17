package com.EmployeeManagementSys.EmployeeManagementSys.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    private int id;

    private String name;

}
