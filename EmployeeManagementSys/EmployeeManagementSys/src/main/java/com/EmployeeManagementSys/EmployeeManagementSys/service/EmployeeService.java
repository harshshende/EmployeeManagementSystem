package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getByEmployeeId(long id);
    void deleteByEmployeeId(long id);
}

