package com.EmployeeManagementSys.EmployeeManagementSys.repository;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    Optional<Employee> findById(Long aLong);

    Optional<Employee> findByEmail(String email);
}

