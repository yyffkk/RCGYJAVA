package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysOrganizationService;

import com.api.model.businessManagement.SysOrganization;
import com.api.vo.businessManagement.VoFindByIdOrganization;
import com.api.vo.businessManagement.VoOrganization;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 组织（部门）管理
 */
@RequestMapping("manage/sysOrganization")
@RestController
public class SysOrganizationController   {
    @Resource
    SysOrganizationService sysOrganizationService;

    /**
     * 查询所有的组织架构信息
     * @return 组织架构Vo 回显 list
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public List<VoOrganization> list(){
        return sysOrganizationService.list();
    }


    /**
     * 添加部门
     * @param sysOrganization 组织信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0104"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysOrganization sysOrganization){
        return sysOrganizationService.insert(sysOrganization);
    }

    /**
     * 根据组织ID查找组织信息
     * @param id 组织主键ID
     * @return 组织架构Vo findById 回显
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0102"},logical = Logical.AND)
    public VoFindByIdOrganization findById(Integer id){
        return sysOrganizationService.findById(id);
    }

    /**
     * 修改部门信息
     * @param sysOrganization 组织信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0105"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysOrganization sysOrganization){
        return sysOrganizationService.update(sysOrganization);
    }

    /**
     * 删除部门信息
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/delete")
    @RequiresPermissions(value = {"0110"},logical = Logical.AND)
    public Map<String,Object> delete(Integer id){
        return sysOrganizationService.delete(id);
    }

    /**
     * 停用部门
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/stop")
    @RequiresPermissions(value = {"0103"},logical = Logical.AND)
    public Map<String,Object> stop(Integer id){
        return sysOrganizationService.stop(id);
    }

    /**
     * 恢复部门
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/recovery")
    @RequiresPermissions(value = {"0107"},logical = Logical.AND)
    public Map<String,Object> recovery(Integer id){
        return sysOrganizationService.recovery(id);
    }

    /**
     * 查询所有的部门id 和 name（类别为部门、工作组、单位、维修公司的）
     * @return map
     */
    @GetMapping("/findAllDepartment")
    public Map<String,Object> findAllDepartment(){
        return sysOrganizationService.findAllDepartment();
    }

}
