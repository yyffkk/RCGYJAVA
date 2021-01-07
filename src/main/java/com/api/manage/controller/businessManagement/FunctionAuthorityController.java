package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.FunctionAuthorityService;
import com.api.manage.service.system.SysRoleService;
import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.model.businessManagement.UserIdAndRoleId;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoUser;
import com.api.vo.system.VoRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class FunctionAuthorityController {
    @Resource
    FunctionAuthorityService functionAuthorityService;
    @Resource
    SysRoleService sysRoleService;

    /**
     * 查询全部用户角色信息
     * @return 用户角色信息
     */
    @GetMapping("/roleList")
    public List<VoRole> roleList(){
        return sysRoleService.roleList();
    }

    /**
     * 查询所属角色下所有的员工信息 （包含条件搜索）
     * @param searchFunctionAuthority 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
    public List<Integer> findRoleNameByUserId(Integer id){
        return functionAuthorityService.findRoleNameByUserId(id);
    }

    /**
     * 给员工修改角色配置
     * @param userIdAndRoleId 员工主键id 和 角色ID
     * @return map
     */
    @PostMapping("/updateRole")
    public Map<String,Object> updateRole(@RequestBody UserIdAndRoleId userIdAndRoleId){
        return functionAuthorityService.updateRole(userIdAndRoleId);
    }



}
