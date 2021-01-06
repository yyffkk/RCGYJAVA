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
}
