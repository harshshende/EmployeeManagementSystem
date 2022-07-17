package com.EmployeeManagementSys.EmployeeManagementSys.repository;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Override
    Optional<Role> findById(Integer integer);

    Role findByName(String name);
}
