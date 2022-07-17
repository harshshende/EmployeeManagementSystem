package com.EmployeeManagementSys.EmployeeManagementSys.controller;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Assets;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.AssetRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.OrganizationRepository;
import com.EmployeeManagementSys.EmployeeManagementSys.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @PostMapping("/create")
    public ResponseEntity<Assets> saveOrganization(@Valid @RequestBody Assets assets){
        return  new ResponseEntity<Assets>(assetService.saveAsset(assets), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Assets> updateEmployee(@RequestBody Assets assets, @PathVariable("id") long id){
        assets.setId(id);
        return  new ResponseEntity<Assets>(assetService.updateAsset(assets), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Assets> getAllEmployee(){
        return assetService.getAllAsset();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assets> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Assets>(assetService.getByAssetId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        assetService.deleteByAssetId(id);
        return new ResponseEntity<String>("Asset Deleted", HttpStatus.OK);
    }

    @PutMapping("/{asset_id}/to/{org_id}")
    Assets assignOrg(@PathVariable long asset_id, @PathVariable long org_id){
        Assets assets = assetRepository.findById(asset_id).get();
        Organization organization = organizationRepository.findById(org_id).get();
        assets.assignOrg(organization);
        return assetRepository.save(assets);

    }
}
