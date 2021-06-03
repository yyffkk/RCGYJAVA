package com.api.manage.controller.operationManagement;


import com.api.model.operationManagement.SearchAnnouncementManagement;
import com.api.model.operationManagement.SysAnnouncementManagement;
import com.api.manage.service.operationManagement.SysAnnouncementManagementService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoFindByIdAnnouncementManagement;
import com.api.vo.operationManagement.VoPreviewAnnouncementManagement;
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
 * 公告管理
 */
@RestController
@RequestMapping("manage/announcementManagement")
public class SysAnnouncementManagementController   {
    @Resource
    SysAnnouncementManagementService sysAnnouncementManagementService;

    /**
     * 查询所有公告信息 （包含条件搜索）
     * @param searchAnnouncementManagement 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501","05"},logical = Logical.AND)
    public Map<String,Object> list(SearchAnnouncementManagement searchAnnouncementManagement){
        PageHelper.startPage(searchAnnouncementManagement.getPageNum(),searchAnnouncementManagement.getSize());
        List<VoAnnouncementManagement> voAnnouncementManagementList = sysAnnouncementManagementService.list(searchAnnouncementManagement);
        PageInfo<VoAnnouncementManagement> pageInfo = new PageInfo<>(voAnnouncementManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加公告信息
     * @param sysAnnouncementManagement 公告信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0503","05"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysAnnouncementManagement sysAnnouncementManagement){
        return sysAnnouncementManagementService.insert(sysAnnouncementManagement);
    }

    /**
     * 根据主键id查询公告信息
     * @param id 主键id
     * @return 公告信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0502","05"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysAnnouncementManagementService.findById(id);
    }

    /**
     * 更新公告信息
     * @param sysAnnouncementManagement 新公告信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0505","05"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysAnnouncementManagement sysAnnouncementManagement){
        return sysAnnouncementManagementService.update(sysAnnouncementManagement);
    }


    /**
     * 批量删除公告信息
     * @param ids 公告信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0504","05"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysAnnouncementManagementService.delete(ids.getIds());
    }

    /**
     * 发布公告管理
     * @param ids 主键id数组
     * @return map
     */
    @PostMapping("/release")
    @RequiresPermissions(value = {"0506","05"},logical = Logical.AND)
    public Map<String,Object> release(@RequestBody VoIds ids){
        return sysAnnouncementManagementService.release(ids.getIds());
    }

    /**
     * 公告信息预览
     * @param id 主键id
     * @return 公告管理预览Vo 回显
     */
    @GetMapping("/preview")
    @RequiresPermissions(value = {"0502","05"},logical = Logical.AND)
    public VoPreviewAnnouncementManagement preview(Integer id){
        return sysAnnouncementManagementService.preview(id);
    }





}
