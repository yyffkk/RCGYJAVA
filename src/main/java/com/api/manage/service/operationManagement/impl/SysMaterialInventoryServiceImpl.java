package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysMaterialInventoryDao;
import com.api.manage.service.operationManagement.SysMaterialInventoryService;
import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.vo.operationManagement.VoMaterialInventory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysMaterialInventoryServiceImpl implements SysMaterialInventoryService {
    @Resource
    SysMaterialInventoryDao sysMaterialInventoryDao;

    @Override
    public List<VoMaterialInventory> list(SearchMaterialInventory searchMaterialInventory) {
        return sysMaterialInventoryDao.list(searchMaterialInventory);
    }
}
