package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysServiceBrowsingService;
import com.api.manage.shiro.ShiroExceptions;
import com.api.model.operationManagement.SearchServiceBrowsing;
import com.api.model.operationManagement.SysServiceBrowsing;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoKeyManagement;
import com.api.vo.operationManagement.VoServiceBrowsing;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务浏览
 */
@RestController
@RequestMapping("manage/serviceBrowsing")
public class SysServiceBrowsingController extends ShiroExceptions {
    @Resource
    SysServiceBrowsingService sysServiceBrowsingService;

    /**
     * 查询所有的服务浏览信息（包含条件搜索）
     * @param searchServiceBrowsing 服务浏览搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchServiceBrowsing searchServiceBrowsing){
        PageHelper.startPage(searchServiceBrowsing.getPageNum(),searchServiceBrowsing.getSize());
        List<VoServiceBrowsing> voServiceBrowsingList = sysServiceBrowsingService.list(searchServiceBrowsing);
        PageInfo<VoServiceBrowsing> pageInfo = new PageInfo<>(voServiceBrowsingList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysServiceBrowsing sysServiceBrowsing){
        return sysServiceBrowsingService.insert(sysServiceBrowsing);
    }

    /**
     * 根据服务浏览主键id查询服务浏览信息
     * @param id 服务浏览主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysServiceBrowsingService.findById(id);
    }

    /**
     * 修改服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysServiceBrowsing sysServiceBrowsing){
        return sysServiceBrowsingService.update(sysServiceBrowsing);
    }

    /**
     * 批量删除服务浏览信息
     * @param ids 服务浏览信息主键Id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysServiceBrowsingService.delete(ids.getIds());
    }
}
