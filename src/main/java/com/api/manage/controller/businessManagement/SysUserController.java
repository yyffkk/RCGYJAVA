package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysUserService;
import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdUser;
import com.api.vo.businessManagement.VoUser;
import com.api.vo.operationManagement.VoActivityManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人员管理
 */
@RestController
@RequestMapping("manage/sysUser")
public class SysUserController {
    @Resource
    SysUserService sysUserService;

    /**
     * 查询所有的人员管理 包含条件搜索
     * @param searchUser 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUser searchUser){
        PageHelper.startPage(searchUser.getPageNum(),searchUser.getSize());
        List<VoUser> voActivityManagementList = sysUserService.list(searchUser);
        PageInfo<VoUser> pageInfo = new PageInfo<>(voActivityManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 新建员工
     * @param sysUser 系统用户
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysUser sysUser){
        return sysUserService.insert(sysUser);
    }

    /**
     * 根据主键id查询人员信息
     * @param id 人员主键id
     * @return 人员信息
     */
    @GetMapping("/findById")
    public VoFindByIdUser findById(Integer id){
        return sysUserService.findById(id);
    }

    /**
     * 修改员工信息
     * @param sysUser 新员工信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysUser sysUser){
        return sysUserService.update(sysUser);
    }

    /**
     * 假删除员工信息
     * @param id 员工主键id
     * @return map
     */
    @GetMapping("/falseDelete")
    public Map<String,Object> falseDelete(Integer id){
        return sysUserService.falseDelete(id);
    }

    /**
     * 禁止登录
     * @param id 员工主键id
     * @return map
     */
    @GetMapping("/disableLogins")
    public Map<String,Object> disableLogins(Integer id){
        return sysUserService.disableLogins(id);
    }

    /**
     * 允许登录
     * @param id 员工主键id
     * @return map
     */
    @GetMapping("/allowLogins")
    public Map<String,Object> allowLogins(Integer id){
        return sysUserService.allowLogins(id);
    }

    /**
     * 停用
     * @param id 员工主键id
     * @return map
     */
    @GetMapping("/stop")
    public Map<String,Object> stop(Integer id){
        return sysUserService.stop(id);
    }

    /**
     * 恢复
     * @param id 员工主键id
     * @return map
     */
    @GetMapping("/recovery")
    public Map<String,Object> recovery(Integer id){
        return sysUserService.recovery(id);
    }

    /**
     * 重置密码
     * @param sysUser 人员信息
     * @return map
     */
    @PostMapping("/resetPWD")
    public Map<String,Object> resetPWD(@RequestBody SysUser sysUser){
        return sysUserService.resetPWD(sysUser);
    }

}
