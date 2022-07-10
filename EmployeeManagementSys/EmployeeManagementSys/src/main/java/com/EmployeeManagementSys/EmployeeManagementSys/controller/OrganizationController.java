package com.EmployeeManagementSys.EmployeeManagementSys.controller;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import com.EmployeeManagementSys.EmployeeManagementSys.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization){
        return  new ResponseEntity<Organization>(organizationService.saveOrganization(organization), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organization> updateEmployee(@RequestBody Organization organization, @PathVariable("id") long id){
        organization.setId(id);
        return  new ResponseEntity<Organization>(organizationService.updateOrganization(organization), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Organization> getAllEmployee(){
        return organizationService.getAllOrganization();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Organization>(organizationService.getByOrganizationId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        organizationService.deleteByOrganizationId(id);
        return new ResponseEntity<String>("Organization Deleted", HttpStatus.OK);
    }


}

