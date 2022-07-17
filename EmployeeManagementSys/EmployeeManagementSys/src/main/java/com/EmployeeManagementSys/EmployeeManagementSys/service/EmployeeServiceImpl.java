package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.exception.EmployeeNotFoundException;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getByEmployeeId(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @Override
    public void deleteByEmployeeId(long id) {
        employeeRepository.deleteById(id);

    }
}

