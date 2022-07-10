package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;

import java.util.List;

public interface OrganizationService {
    Organization saveOrganization(Organization organization);
    Organization updateOrganization(Organization organization);
    List<Organization> getAllOrganization();
    Organization getByOrganizationId(long id);
    void deleteByOrganizationId(long id);
}

