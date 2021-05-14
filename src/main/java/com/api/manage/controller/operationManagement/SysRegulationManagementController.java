package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysRegulationManagementService;
import com.api.manage.shiro.ShiroExceptions;
import com.api.model.operationManagement.SearchRegulationManagement;
import com.api.model.operationManagement.SysRegulationManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoPackageCollection;
import com.api.vo.operationManagement.VoRegulationManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规程管理
 */
@RestController
@RequestMapping("manage/regulationManagement")
public class SysRegulationManagementController extends ShiroExceptions {
    @Resource
    SysRegulationManagementService sysRegulationManagementService;


    /**
     * 查询所有的规程管理信息（包含条件搜索）
     * @param searchRegulationManagement 规程管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchRegulationManagement searchRegulationManagement){
        PageHelper.startPage(searchRegulationManagement.getPageNum(),searchRegulationManagement.getSize());
        List<VoRegulationManagement> voRegulationManagementList = sysRegulationManagementService.list(searchRegulationManagement);
        PageInfo<VoRegulationManagement> pageInfo = new PageInfo<>(voRegulationManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加规程信息
     * @param sysRegulationManagement 规程管理model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysRegulationManagement sysRegulationManagement){
        return sysRegulationManagementService.insert(sysRegulationManagement);
    }

    /**
     * 根据规程主键id查询规程信息
     * @param id 规程主键id
     * @return map
     */
    @GetMapping("findById")
    public Map<String,Object> findById(Integer id){
        return sysRegulationManagementService.findById(id);
    }

    /**
     * 修改规程信息
     * @param sysRegulationManagement 规程管理model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysRegulationManagement sysRegulationManagement){
        return sysRegulationManagementService.update(sysRegulationManagement);
    }

    /**
     * 批量删除规程信息
     * @param ids 规程信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysRegulationManagementService.delete(ids.getIds());
    }
}
