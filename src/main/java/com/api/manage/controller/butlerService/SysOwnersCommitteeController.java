package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchOwnersCommittee;
import com.api.model.butlerService.SysOwnersCommittee;
import com.api.manage.service.butlerService.SysOwnersCommitteeService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFindByIdOwnersCommittee;
import com.api.vo.butlerService.VoOwnersCommittee;
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
 * 业委会管理
 */
@RestController
@RequestMapping("manage/ownersCommittee")
public class SysOwnersCommitteeController   {
    @Resource
    SysOwnersCommitteeService sysOwnersCommitteeService;

    /**
     * 查询所有的业委会信息 （包含条件搜索）
     * @param searchOwnersCommittee 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchOwnersCommittee searchOwnersCommittee){
        PageHelper.startPage(searchOwnersCommittee.getPageNum(),searchOwnersCommittee.getSize());
        List<VoOwnersCommittee> voOwnersCommitteeList = sysOwnersCommitteeService.list(searchOwnersCommittee);
        PageInfo<VoOwnersCommittee> pageInfo = new PageInfo<>(voOwnersCommitteeList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加业委会信息
     * @param sysOwnersCommittee 业委会信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysOwnersCommittee sysOwnersCommittee){
        return sysOwnersCommitteeService.insert(sysOwnersCommittee);
    }

    /**
     * 根据业委会主键id查询业委会信息
     * @param id 业委会主键id
     * @return 业委会信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public VoFindByIdOwnersCommittee findById(Integer id){
        return sysOwnersCommitteeService.findById(id);
    }

    /**
     * 更新业委会信息
     * @param sysOwnersCommittee 新业委会信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysOwnersCommittee sysOwnersCommittee){
        return sysOwnersCommitteeService.update(sysOwnersCommittee);
    }

    /**
     * 批量删除业委会信息吧
     * @param ids 业委会信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysOwnersCommitteeService.delete(ids.getIds());
    }
}
