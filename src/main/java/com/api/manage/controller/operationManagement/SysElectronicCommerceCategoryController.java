package com.api.manage.controller.operationManagement;


import com.api.manage.service.operationManagement.SysElectronicCommerceCategoryService;
import com.api.model.operationManagement.SearchElectronicCommerceCategory;
import com.api.model.operationManagement.SysElectronicCommerceCategory;
import com.api.model.operationManagement.SysNewsCategoryManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoElectronicCommerceCategory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电子商务分类管理
 */
@RestController
@RequestMapping("manage/electronicCommerceCategory")
public class SysElectronicCommerceCategoryController {
    @Resource
    SysElectronicCommerceCategoryService sysElectronicCommerceService;

    /**
     * 查询所有的电子商务分类(包含条件搜索)
     * @param searchElectronicCommerceCategory 电子商务分类搜索条件
     * @return map
     */
    @RequestMapping("/list")
    public Map<String,Object> list(SearchElectronicCommerceCategory searchElectronicCommerceCategory){
        PageHelper.startPage(searchElectronicCommerceCategory.getPageNum(),searchElectronicCommerceCategory.getSize());
        List<VoElectronicCommerceCategory> voElectronicCommerceCategoryList = sysElectronicCommerceService.list(searchElectronicCommerceCategory);
        PageInfo<VoElectronicCommerceCategory> pageInfo = new PageInfo<>(voElectronicCommerceCategoryList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加电子商务分类
     * @param sysElectronicCommerceCategory 电子商务分类管理信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysElectronicCommerceCategory sysElectronicCommerceCategory){
        return sysElectronicCommerceService.insert(sysElectronicCommerceCategory);
    }

    /***
     * 根据电子商务分类主键id 查询 电子商务分类信息
     * @param id 电子商务分类主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysElectronicCommerceService.findById(id);
    }

    /**
     * 修改电子商务分类信息
     * @param sysElectronicCommerceCategory 电子商务分类信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysElectronicCommerceCategory sysElectronicCommerceCategory){
        return sysElectronicCommerceService.update(sysElectronicCommerceCategory);
    }

    /**
     * 批量删除电子商务分类
     * @param ids 电子商务分类主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysElectronicCommerceService.delete(ids.getIds());
    }

}
