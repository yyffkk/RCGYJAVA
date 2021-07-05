package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysMaterialInventoryService;
import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.vo.operationManagement.VoMaterialInventory;
import com.api.vo.operationManagement.VoMaterialRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物料盘点管理
 */
@RestController
@RequestMapping("manage/materialInventory")
public class SysMaterialInventoryController {
    @Resource
    SysMaterialInventoryService sysMaterialInventoryService;

    /**
     * 查询所有的物料盘点管理信息
     * @param searchMaterialInventory 物资盘点搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchMaterialInventory searchMaterialInventory){
        PageHelper.startPage(searchMaterialInventory.getPageNum(),searchMaterialInventory.getSize());
        List<VoMaterialInventory> voMaterialRecordList = sysMaterialInventoryService.list(searchMaterialInventory);
        PageInfo<VoMaterialInventory> pageInfo = new PageInfo<>(voMaterialRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
