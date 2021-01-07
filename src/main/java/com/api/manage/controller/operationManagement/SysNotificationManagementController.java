package com.api.manage.controller.operationManagement;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.operationManagement.NotificationManagement;
import com.api.model.operationManagement.SearchNotificationManagement;
import com.api.manage.service.operationManagement.SysNotificationManagementService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoFindByIdNotificationManagement;
import com.api.vo.operationManagement.VoNotificationManagement;
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
 * 通知管理
 */
@RestController
@RequestMapping("manage/notificationManagement")
public class SysNotificationManagementController extends ShiroExceptions {
    @Resource
    SysNotificationManagementService sysNotificationManagementService;

    /**
     * 查询所有的通知信息（包含条件搜索）
     * @param searchNotificationManagement 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501","05"},logical = Logical.AND)
    public Map<String,Object> list(SearchNotificationManagement searchNotificationManagement){
        PageHelper.startPage(searchNotificationManagement.getPageNum(),searchNotificationManagement.getSize());
        List<VoNotificationManagement> voNotificationManagementList = sysNotificationManagementService.list(searchNotificationManagement);
        PageInfo<VoNotificationManagement> pageInfo = new PageInfo<>(voNotificationManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加通知信息
     * @param notificationManagement 通知信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0503","05"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody NotificationManagement notificationManagement){
        return sysNotificationManagementService.insert(notificationManagement);
    }

    /**
     * 根据主键id查询通知信息
     * @param id 主键id
     * @return 通知信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0502","05"},logical = Logical.AND)
    public VoFindByIdNotificationManagement findById(Integer id){
        return sysNotificationManagementService.findById(id);
    }

    /**
     * 修改通知信息
     * @param notificationManagement 新通知信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0505","05"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody NotificationManagement notificationManagement){
        return sysNotificationManagementService.update(notificationManagement);
    }

    /**
     * 批量删除通知信息
     * @param ids 通知信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0504","05"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysNotificationManagementService.delete(ids.getIds());
    }



}
