package com.api.manage.controller.basicArchives;

import com.api.manage.service.basicArchives.AuditManagementService;
import com.api.model.basicArchives.AuditManagementSearch;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
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
}
