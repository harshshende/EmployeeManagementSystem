package com.EmployeeManagementSys.EmployeeManagementSys.controller;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Role;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    public Role saveRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @GetMapping("/getall")
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable("id") int id){
        roleRepository.deleteById(id);
        return new ResponseEntity<String>("Role Deleted", HttpStatus.OK);
    }
}
