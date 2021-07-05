package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysMaterialInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 物料盘点管理
 */
@RestController
@RequestMapping("manage/materialInventory")
public class SysMaterialInventoryController {
    @Resource
    SysMaterialInventoryService sysMaterialInventoryService;


}
