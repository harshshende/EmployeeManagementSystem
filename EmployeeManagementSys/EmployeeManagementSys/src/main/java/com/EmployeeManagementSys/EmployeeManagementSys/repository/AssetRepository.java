package com.EmployeeManagementSys.EmployeeManagementSys.repository;

//import com.EMS.EmployementManagementSys.model.Assets;
import com.EmployeeManagementSys.EmployeeManagementSys.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Assets, Long> {
}