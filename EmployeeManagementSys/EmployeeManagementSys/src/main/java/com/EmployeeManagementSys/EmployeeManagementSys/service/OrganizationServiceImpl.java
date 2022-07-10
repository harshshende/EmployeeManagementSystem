package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization) ;
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getByOrganizationId(long id) {
        return organizationRepository.findById(id).get();
    }

    @Override
    public void deleteByOrganizationId(long id) {
        organizationRepository.deleteById(id);

    }
}

