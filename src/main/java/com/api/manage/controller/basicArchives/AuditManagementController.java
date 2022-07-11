package com.api.manage.controller.basicArchives;

import com.api.manage.service.basicArchives.AuditManagementService;
import com.api.model.basicArchives.AuditManagementSearch;
import com.api.model.basicArchives.Review;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.api.vo.basicArchives.VoIds;
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
 * 审核管理
 */
@RestController
@RequestMapping("manage/auditManagement")
public class AuditManagementController {
    @Resource
    AuditManagementService auditManagementService;

    /**
     * 查询所有的房屋审核信息（包含条件搜索）
     * @param auditManagementSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0201"},logical = Logical.AND)
    public Map<String,Object> list(AuditManagementSearch auditManagementSearch){
        PageHelper.startPage(auditManagementSearch.getPageNum(),auditManagementSearch.getSize());
        List<VoAuditManagement> voAuditManagementList =auditManagementService.list(auditManagementSearch);
        PageInfo<VoAuditManagement> pageInfo = new PageInfo<>(voAuditManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据房屋审核主键id 查询房屋审核信息（审核页面回显）
     * @param estateExamineId 房屋审核主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0202"},logical = Logical.AND)
    public Map<String,Object> findById(Integer estateExamineId){
        return auditManagementService.findById(estateExamineId);
    }

    /**
     * 审核通过/审核不通过
     * @param review 审核内容
     * @return map
     */
    @PostMapping("/reviewResult")
    public Map<String,Object> review(@RequestBody Review review){
        return auditManagementService.review(review);
    }

    /**
     * 删除审核管理信息
     * @param voIds 审核管理主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0204"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds voIds){
        return auditManagementService.delete(voIds.getIds());
    }

    /**
     * 查看审核信息
     * @param estateExamineId 房屋审核主键id
     * @return map
     */
    @GetMapping("/checkById")
    @RequiresPermissions(value = {"0202"},logical = Logical.AND)
    public Map<String,Object> checkById(Integer estateExamineId){
        return auditManagementService.checkById(estateExamineId);
    }


}
