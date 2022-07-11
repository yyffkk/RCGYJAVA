package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysPackageCollectionService;

import com.api.model.operationManagement.SearchPackageCollection;
import com.api.model.operationManagement.SysPackageCollection;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoPackageCollection;
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
 * 包裹代收管理
 */
@RestController
@RequestMapping("manage/packageCollection")
public class SysPackageCollectionController   {
    @Resource
    SysPackageCollectionService sysPackageCollectionService;

    /**
     * 查询所有的包裹代收信息（包含条件搜索）
     * @param searchPackageCollection 包裹代收搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchPackageCollection searchPackageCollection){
        PageHelper.startPage(searchPackageCollection.getPageNum(),searchPackageCollection.getSize());
        List<VoPackageCollection> voPackageCollectionList = sysPackageCollectionService.list(searchPackageCollection);
        PageInfo<VoPackageCollection> pageInfo = new PageInfo<>(voPackageCollectionList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加包裹代收信息
     * @param sysPackageCollection 包裹代收model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysPackageCollection sysPackageCollection){
        return sysPackageCollectionService.insert(sysPackageCollection);
    }

    /**
     * 根据包裹代收主键id 查询包裹代收信息
     * @param id 包裹代收主键id
     * @return 包裹代收信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysPackageCollectionService.findById(id);
    }


    /**
     * 修改包裹代收信息
     * @param sysPackageCollection 包裹代收model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysPackageCollection sysPackageCollection){
        return sysPackageCollectionService.update(sysPackageCollection);
    }

    /**
     * 批量删除包裹代收信息
     * @param ids 包裹代收信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysPackageCollectionService.delete(ids.getIds());
    }

}
