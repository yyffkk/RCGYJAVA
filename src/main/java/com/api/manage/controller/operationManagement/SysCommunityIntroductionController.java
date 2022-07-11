package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysCommunityIntroductionService;

import com.api.model.operationManagement.SearchCommunityIntroduction;
import com.api.model.operationManagement.SysCommunityIntroduction;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoCommunityIntroduction;
import com.api.vo.operationManagement.VoGreenArea;
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
 * 社区介绍管理
 */
@RestController
@RequestMapping("manage/communityIntroduction")
public class SysCommunityIntroductionController   {
    @Resource
    SysCommunityIntroductionService sysCommunityIntroductionService;

    /**
     * 查询所有的社区介绍信息（包含条件搜索）
     * @param searchCommunityIntroduction 社区介绍搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchCommunityIntroduction searchCommunityIntroduction){
        PageHelper.startPage(searchCommunityIntroduction.getPageNum(),searchCommunityIntroduction.getSize());
        List<VoCommunityIntroduction> voCommunityIntroductionList = sysCommunityIntroductionService.list(searchCommunityIntroduction);
        PageInfo<VoCommunityIntroduction> pageInfo = new PageInfo<>(voCommunityIntroductionList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加社区介绍信息
     * @param sysCommunityIntroduction 社区介绍model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysCommunityIntroduction sysCommunityIntroduction){
        return sysCommunityIntroductionService.insert(sysCommunityIntroduction);
    }

    /**
     * 根据社区介绍主键Id查询社区介绍信息
     * @param id 社区介绍主键Id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysCommunityIntroductionService.findById(id);
    }

    /**
     * 修改社区介绍信息
     * @param sysCommunityIntroduction 社区介绍model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysCommunityIntroduction sysCommunityIntroduction){
        return sysCommunityIntroductionService.update(sysCommunityIntroduction);
    }

    /**
     * 批量删除社区介绍信息
     * @param ids 社区介绍主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysCommunityIntroductionService.delete(ids.getIds());
    }

    /**
     * 启用社区介绍信息
     * @param id 社区介绍主键Id
     * @return map
     */
    @GetMapping("/enable")
    public Map<String,Object> enable(Integer id){
        return sysCommunityIntroductionService.enable(id);
    }

}
