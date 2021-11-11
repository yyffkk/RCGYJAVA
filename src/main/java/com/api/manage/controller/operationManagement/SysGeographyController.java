package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysGeographyService;
import com.api.model.operationManagement.GeographyInsert;
import com.api.model.operationManagement.GeographySearch;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.SysGeographyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 地理信息管理
 */
@RestController
@RequestMapping("manage/geography")
public class SysGeographyController {
    @Resource
    SysGeographyService sysGeographyService;

    /**
     * 查询所有的地理信息（包含条件搜索）
     * @param geographySearch 地理信息 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(GeographySearch geographySearch){
        PageHelper.startPage(geographySearch.getPageNum(), geographySearch.getSize());
        List<SysGeographyVo> sysGeographyList = sysGeographyService.list(geographySearch);
        PageInfo<SysGeographyVo> pageInfo = new PageInfo<>(sysGeographyList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 新增地理模版
     * @param geographyInsert 地理新增model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody GeographyInsert geographyInsert){
        return sysGeographyService.insert(geographyInsert);
    }

    /**
     * 根据地理主键id查询地理信息
     * @param geographyId 地理主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer geographyId){
        return sysGeographyService.findById(geographyId);
    }

    /**
     * 修改地理模版
     * @param geographyInsert 地理新增model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody GeographyInsert geographyInsert){
        return sysGeographyService.update(geographyInsert);
    }

    /**
     * 开启模版
     * @param geographyId 地理主键id
     * @return map
     */
    @GetMapping("/enable")
    public Map<String,Object> enable(Integer geographyId){
        return sysGeographyService.enable(geographyId);
    }

    /**
     * 删除地理模版
     * @param ids 地理模版主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysGeographyService.delete(ids.getIds());
    }
}
