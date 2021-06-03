package com.api.manage.controller.businessManagement;

import com.api.manage.service.system.SysRoleService;
import com.api.model.system.SysRole;
import com.api.vo.system.VoCheckRole;
import com.api.vo.system.VoRole;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 */
@RestController
@RequestMapping("manage/sysRole")
public class SysRoleController {
    @Resource
    SysRoleService sysRoleService;

    /**
     * 查询全部用户角色信息
     * @return 用户角色信息
     */
    @GetMapping("/roleList")
    @RequiresPermissions(value = {"0101","01"},logical = Logical.AND)
    public List<VoRole> roleList(){
        return sysRoleService.roleList();
    }

    /**
     * 添加角色信息
     * @param sysRole 角色表
     * @return map
     */
    @PostMapping("/insertRole")
    public Map<String,Object> insertRole(@RequestBody SysRole sysRole){
        return sysRoleService.insertRole(sysRole);
    }

    /**
     * 修改角色信息
     * @param sysRole 角色表
     * @return map
     */
    @PostMapping("/updateRole")
    public Map<String,Object> updateRole(@RequestBody SysRole sysRole){
        return sysRoleService.updateRole(sysRole);
    }

    /**
     * 删除角色信息
     * @param sysRole 角色表
     * @return map
     */
    @PostMapping("/deleteRole")
    public Map<String,Object> deleteRole(@RequestBody SysRole sysRole){
        return sysRoleService.deleteRole(sysRole);
    }

}
