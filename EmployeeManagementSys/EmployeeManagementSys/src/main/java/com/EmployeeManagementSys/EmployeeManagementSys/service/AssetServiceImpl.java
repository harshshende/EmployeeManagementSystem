package com.EmployeeManagementSys.EmployeeManagementSys.service;

import com.EmployeeManagementSys.EmployeeManagementSys.model.Assets;
import com.EmployeeManagementSys.EmployeeManagementSys.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Assets saveAsset(Assets assets) {
        return assetRepository.save(assets);
    }

    @Override
    public Assets updateAsset(Assets assets) {
        return assetRepository.save(assets);
    }

    @Override
    public List<Assets> getAllAsset() {
        return assetRepository.findAll();
    }

    @Override
    public Assets getByAssetId(long id) {
        return assetRepository.findById(id).get();
    }

    @Override
    public void deleteByAssetId(long id) {
        assetRepository.deleteById(id);

    }
}

