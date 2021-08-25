package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysSecurityManagementService;
import com.api.model.butlerService.SearchSecurityManagement;
import com.api.vo.butlerService.VoReportRepair;
import com.api.vo.butlerService.VoSecurityManagement;
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
 * 安全管理表
 */
@RestController
@RequestMapping("manage/securityManagement")
public class SysSecurityManagement {
    @Resource
    SysSecurityManagementService sysSecurityManagementService;


    /**
     * 查询所有的安全管理信息
     * @param searchSecurityManagement 安全管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchSecurityManagement searchSecurityManagement){
        PageHelper.startPage(searchSecurityManagement.getPageNum(),searchSecurityManagement.getSize());
        List<VoSecurityManagement> voSecurityManagementList = sysSecurityManagementService.list(searchSecurityManagement);
        PageInfo<VoSecurityManagement> pageInfo = new PageInfo<>(voSecurityManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
