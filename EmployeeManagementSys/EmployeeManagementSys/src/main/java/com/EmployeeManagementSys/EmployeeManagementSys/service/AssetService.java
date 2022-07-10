package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Assets;

import java.util.List;

public interface AssetService {
    Assets saveAsset(Assets assets);
    Assets updateAsset(Assets assets);
    List<Assets> getAllAsset();
    Assets getByAssetId(long id);
    void deleteByAssetId(long id);
}
