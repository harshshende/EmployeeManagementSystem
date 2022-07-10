package com.EmployeeManagementSys.EmployeeManagementSys.repository;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
