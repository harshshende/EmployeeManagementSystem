package com.EmployeeManagementSys.EmployeeManagementSys.security;

import com.EmployeeManagementSys.EmployeeManagementSys.exception.EmployeeNotFoundException;
import com.EmployeeManagementSys.EmployeeManagementSys.exception.EmployeeNotFoundException;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Employee employee= this.employeeRepository.findByEmail(username).orElseThrow(() -> new EmployeeNotFoundException(username));

        return employee;
    }
}
