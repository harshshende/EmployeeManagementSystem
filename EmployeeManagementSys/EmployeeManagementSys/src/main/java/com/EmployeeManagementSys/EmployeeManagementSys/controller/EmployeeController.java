package com.EmployeeManagementSys.EmployeeManagementSys.controller;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Employee;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.EmployeeRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.OrganizationRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id){
        employee.setId(id);
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }


    @GetMapping("/getall")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getByEmployeeId(id), HttpStatus.OK);
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

