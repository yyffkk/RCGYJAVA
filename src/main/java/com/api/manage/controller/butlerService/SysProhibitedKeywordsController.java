package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.manage.service.butlerService.SysProhibitedKeywordsService;
import com.api.model.butlerService.SysProhibitedKeywords;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoProhibitedKeywords;
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
 * 违禁关键字表
 */
@RestController
@RequestMapping("manage/prohibitedKeywords")
public class SysProhibitedKeywordsController   {
    @Resource
    SysProhibitedKeywordsService sysProhibitedKeywordsService;

    /**
     * 显示所有的违禁关键字信息 （包含条件搜索）
     * @param searchProhibitedKeywords 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchProhibitedKeywords searchProhibitedKeywords){
        PageHelper.startPage(searchProhibitedKeywords.getPageNum(),searchProhibitedKeywords.getSize());
        List<VoProhibitedKeywords> voProhibitedKeywordsList = sysProhibitedKeywordsService.list(searchProhibitedKeywords);
        PageInfo<VoProhibitedKeywords> pageInfo = new PageInfo<>(voProhibitedKeywordsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加违禁关键字信息
     * @param sysProhibitedKeywords 违禁关键字model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysProhibitedKeywords sysProhibitedKeywords){
        return sysProhibitedKeywordsService.insert(sysProhibitedKeywords);
    }

    /**
     * 修改违禁关键字信息
     * @param sysProhibitedKeywords 违禁关键字model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysProhibitedKeywords sysProhibitedKeywords){
        return sysProhibitedKeywordsService.update(sysProhibitedKeywords);
    }

    /**
     * 根据违禁关键字信息主键id删除违禁关键字信息
     * @param ids 违禁关键字信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysProhibitedKeywordsService.delete(ids.getIds());
    }




}
