package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.FunctionAuthorityService;
import com.api.manage.service.system.SysRoleService;
import com.api.manage.shiro.ShiroExceptions;
import com.api.model.businessManagement.*;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoListJurisdiction;
import com.api.vo.system.VoCheckRole;
import com.api.vo.system.VoRole;
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
 * 功能权限管理
 */
@RestController
@RequestMapping("manage/functionAuthority")
public class FunctionAuthorityController extends ShiroExceptions {
    @Resource
    FunctionAuthorityService functionAuthorityService;
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
     * 查询当前用户的所有角色信息（带选择字段）
     * @return 用户角色信息
     */
    @GetMapping("/roleCheckList")
    @RequiresPermissions(value = {"0101","01"},logical = Logical.AND)
    public List<VoCheckRole> roleCheckList(Integer id){
        return sysRoleService.roleCheckList(id);
    }

    /**
     * 查询所属角色下所有的员工信息 （包含条件搜索）
     * @param searchFunctionAuthority 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101","01"},logical = Logical.AND)
    public Map<String,Object> list(SearchFunctionAuthority searchFunctionAuthority){
        PageHelper.startPage(searchFunctionAuthority.getPageNum(),searchFunctionAuthority.getSize());
        List<VoFunctionAuthority> voFunctionAuthorityList = functionAuthorityService.list(searchFunctionAuthority);
        PageInfo<VoFunctionAuthority> pageInfo = new PageInfo<>(voFunctionAuthorityList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据员工主键id查询所属角色
     * @param id 员工主键id
     * @return 员工角色配置
     */
    @GetMapping("/findRoleNameByUserId")
    @RequiresPermissions(value = {"0102","01"},logical = Logical.AND)
    public List<Integer> findRoleNameByUserId(Integer id){
        return functionAuthorityService.findRoleNameByUserId(id);
    }

    /**
     * 给员工修改角色配置
     * @param userIdAndRoleId 员工主键id 和 角色ID
     * @return map
     */
    @PostMapping("/updateRole")
    @RequiresPermissions(value = {"0105","01"},logical = Logical.AND)
    public Map<String,Object> updateRole(@RequestBody UserIdAndRoleId userIdAndRoleId){
        return functionAuthorityService.updateRole(userIdAndRoleId);
    }

    /**
     * 查询当前角色的所有权限信息
     * @param roleIdAndParentId  角色主键id 和 上级权限id
     * @return map
     */
    @GetMapping("/listJurisdiction")
    @RequiresPermissions(value = {"0101","01"},logical = Logical.AND)
    public List<VoListJurisdiction> listJurisdiction(RoleIdAndParentId roleIdAndParentId){
        List<VoListJurisdiction> voListJurisdictionList = functionAuthorityService.listJurisdiction(roleIdAndParentId);
        return voListJurisdictionList;
    }

    /**
     * 修改该角色的权限信息
     * @param roleIdAndJurisdictionIdList 角色id 和 权限id数组
     * @return map
     */
    @PostMapping("/updateJurisdiction")
    @RequiresPermissions(value = {"0105","01"},logical = Logical.AND)
    public Map<String,Object> updateJurisdiction(@RequestBody RoleIdAndJurisdictionIdList roleIdAndJurisdictionIdList){
        return functionAuthorityService.updateJurisdiction(roleIdAndJurisdictionIdList);
    }

    /**
     * 修改单个角色的权限信息
     * @param roleIdAndJurisdictionId 角色id 和 权限id
     * @return map
     */
    @PostMapping("/updateOneJurisdiction")
    @RequiresPermissions(value = {"0105","01"},logical = Logical.AND)
    public Map<String,Object> updateOneJurisdiction(@RequestBody RoleIdAndJurisdictionId roleIdAndJurisdictionId){
        return functionAuthorityService.updateOneJurisdiction(roleIdAndJurisdictionId);
    }




}
