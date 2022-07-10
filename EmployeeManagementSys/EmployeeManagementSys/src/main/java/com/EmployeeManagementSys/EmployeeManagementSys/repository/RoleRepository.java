package com.EmployeeManagementSys.EmployeeManagementSys.repository;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
