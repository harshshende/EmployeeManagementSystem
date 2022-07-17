package com.EmployeeManagementSys.EmployeeManagementSys.controller;

import com.EmployeeManagementSys.EmployeeManagementSys.exception.EmployeeNotFoundException;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Role;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.EmployeeRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.OrganizationRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.RoleRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id){
        employee.setId(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Employee verifiedEmployee;
        try {
            if(authentication.getName().equals(employee.getEmail()) || authentication.getAuthorities().contains(new SimpleGrantedAuthority("Role_Admin"))){
                if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("Role_Admin")))
                    employee.setRoles(employeeService.getByEmployeeId(employee.getId()).getRoles());
                verifiedEmployee=employeeService.updateEmployee(employee);
            }
            else
                return new ResponseEntity<String>("Unauthorized access Request ",HttpStatus.UNAUTHORIZED);
        } catch (EmployeeNotFoundException e){
            return new ResponseEntity<String>("Employee Id doesn't match.",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(verifiedEmployee,HttpStatus.OK);
    }


    @GetMapping("/getall")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals(employeeService.getByEmployeeId(id).getEmail()) || authentication.getAuthorities().contains(new SimpleGrantedAuthority("Role_Admin")))
            try{
                return new ResponseEntity<Employee>(employeeService.getByEmployeeId(id),HttpStatus.OK);
            }catch (EmployeeNotFoundException e){
                return new ResponseEntity<String>("Employee not found",HttpStatus.NOT_FOUND);
            }
        else
            return new ResponseEntity<String>("Unauthorized access Request ",HttpStatus.UNAUTHORIZED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteByEmployeeId(id);
        return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
    }

    @PutMapping("/{emp_id}/to/{org_id}")
    Employee assignOrg(@PathVariable long emp_id, @PathVariable long org_id){
        Employee employee = employeeRepository.findById(emp_id).get();
        Organization organization = organizationRepository.findById(org_id).get();
        employee.assignOrg(organization);
        return employeeRepository.save(employee);

    }

}

