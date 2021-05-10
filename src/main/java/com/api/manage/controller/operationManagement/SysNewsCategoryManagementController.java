package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysNewsCategoryManagementService;
import com.api.model.operationManagement.SearchNewsCategoryManagement;
import com.api.model.operationManagement.SysNewsCategoryManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoNewsCategoryManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资讯分类管理
 */
@RestController
@RequestMapping("manage/newsCategoryManagement")
public class SysNewsCategoryManagementController {
    @Resource
    SysNewsCategoryManagementService sysNewsCategoryManagementService;


    /**
     * 查询所有的资讯分类
     * @param searchNewsCategoryManagement 资讯分类搜索条件
     * @return map
     */
    @RequestMapping("/list")
    public Map<String,Object> list(SearchNewsCategoryManagement searchNewsCategoryManagement){
        PageHelper.startPage(searchNewsCategoryManagement.getPageNum(),searchNewsCategoryManagement.getSize());
        List<VoNewsCategoryManagement> voNewsCategoryManagementList = sysNewsCategoryManagementService.list(searchNewsCategoryManagement);
        PageInfo<VoNewsCategoryManagement> pageInfo = new PageInfo<>(voNewsCategoryManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加资讯分类
     * @param sysNewsCategoryManagement 资讯分类管理信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysNewsCategoryManagement sysNewsCategoryManagement){
        return sysNewsCategoryManagementService.insert(sysNewsCategoryManagement);
    }

    /***
     * 根据资讯分类主键id 查询 资讯分类信息
     * @param id 资讯分类主键id
     * @return 资讯分类信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysNewsCategoryManagementService.findById(id);
    }

    /**
     * 修改资讯分类信息
     * @param sysNewsCategoryManagement 资讯分类信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysNewsCategoryManagement sysNewsCategoryManagement){
        return sysNewsCategoryManagementService.update(sysNewsCategoryManagement);
    }

    /**
     * 批量删除资讯分类
     * @param ids 资讯分类主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysNewsCategoryManagementService.delete(ids.getIds());
    }
}
