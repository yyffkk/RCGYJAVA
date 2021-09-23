package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysElectronicCommerceService;

import com.api.model.operationManagement.SearchElectronicCommerce;
import com.api.model.operationManagement.SysElectronicCommerce;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoElectronicCommerce;
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
 * 电子商务管理
 */
@RestController
@RequestMapping("manage/electronicCommerce")
public class SysElectronicCommerceController   {
    @Resource
    SysElectronicCommerceService sysElectronicCommerceService;

    /**
     * 查询所有的电子商务信息 （包含条件搜索）
     * @param searchElectronicCommerce 电子商务搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501"},logical = Logical.AND)
    public Map<String,Object> list(SearchElectronicCommerce searchElectronicCommerce){
        PageHelper.startPage(searchElectronicCommerce.getPageNum(),searchElectronicCommerce.getSize());
        List<VoElectronicCommerce> voElectronicCommerceList = sysElectronicCommerceService.list(searchElectronicCommerce);
        PageInfo<VoElectronicCommerce> pageInfo = new PageInfo<>(voElectronicCommerceList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加电子商务信息
     * @param sysElectronicCommerce 电子商务信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysElectronicCommerce sysElectronicCommerce){
        return sysElectronicCommerceService.insert(sysElectronicCommerce);
    }

    /**
     * 根据电子商务主键id 查询 电子商务信息
     * @param id 电子商务主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysElectronicCommerceService.findById(id);
    }

    /**
     * 修改电子商务信息
     * @param sysElectronicCommerce 电子商务信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysElectronicCommerce sysElectronicCommerce){
        return sysElectronicCommerceService.update(sysElectronicCommerce);
    }

    /**
     * 批量删除电子商务信息
     * @param ids 电子商务信息主键id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysElectronicCommerceService.delete(ids.getIds());
    }

}
