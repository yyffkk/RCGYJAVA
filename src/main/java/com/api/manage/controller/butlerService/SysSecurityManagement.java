package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysSecurityManagementService;
import com.api.model.butlerService.SearchSecurityManagement;
import com.api.model.butlerService.SecurityManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoReportRepair;
import com.api.vo.butlerService.VoSecurityManagement;
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

    /**
     * 添加安全管理信息
     * @param securityManagement 安全管理信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SecurityManagement securityManagement){
        return sysSecurityManagementService.insert(securityManagement);
    }

    /**
     * 查询所有的登记人姓名和id
     * @return map
     */
    @GetMapping("/findAllCreateName")
    public Map<String,Object> findAllCreateName(){
        return sysSecurityManagementService.findAllCreateName();
    }

    /**
     * 根据安全管理主键id查询安全管理信息
     * @param id 安全管理主键id
     * @return 安全管理信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysSecurityManagementService.findById(id);
    }

    /**
     * 修改安全管理信息
     * @param securityManagement 安全管理信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SecurityManagement securityManagement){
        return sysSecurityManagementService.update(securityManagement);
    }

    /**
     * 批量删除安全管理信息
     * @param ids 安全管理信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysSecurityManagementService.delete(ids.getIds());
    }
}
