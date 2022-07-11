package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysMaterialService;
import com.api.model.operationManagement.SearchMaterial;
import com.api.model.operationManagement.SysMaterial;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoKeyBorrow;
import com.api.vo.operationManagement.VoMaterial;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物料管理
 */
@RestController
@RequestMapping("manage/material")
public class SysMaterialController {
    @Resource
    SysMaterialService sysMaterialService;

    /**
     * 查询所有的物料管理信息
     * @param searchMaterial 物料管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchMaterial searchMaterial){
        PageHelper.startPage(searchMaterial.getPageNum(),searchMaterial.getSize());
        List<VoMaterial> voMaterialList = sysMaterialService.list(searchMaterial);
        PageInfo<VoMaterial> pageInfo = new PageInfo<>(voMaterialList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加物料管理信息
     * @param sysMaterial 物料管理model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysMaterial sysMaterial){
        return sysMaterialService.insert(sysMaterial);
    }


    /**
     * 批量删除物资管理信息
     * @param ids 物资管理信息主键id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysMaterialService.delete(ids.getIds());
    }

    /**
     * 修改物资管理信息
     * @param sysMaterial 物料管理model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysMaterial sysMaterial){
        return sysMaterialService.update(sysMaterial);
    }
}
