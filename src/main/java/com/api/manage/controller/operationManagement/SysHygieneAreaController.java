package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysHygieneAreaService;
import com.api.manage.shiro.ShiroExceptions;
import com.api.model.operationManagement.SearchHygieneArea;
import com.api.model.operationManagement.SysHygieneArea;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoGreenTask;
import com.api.vo.operationManagement.VoHygieneArea;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卫生区域管理
 */
@RestController
@RequestMapping("manage/hygieneArea")
public class SysHygieneAreaController extends ShiroExceptions {
    @Resource
    SysHygieneAreaService sysHygieneAreaService;


    /**
     * 查询所有的卫生区域信息（包含条件搜索）
     * @param searchHygieneArea 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchHygieneArea searchHygieneArea){
        PageHelper.startPage(searchHygieneArea.getPageNum(),searchHygieneArea.getSize());
        List<VoHygieneArea> voHygieneAreaList = sysHygieneAreaService.list(searchHygieneArea);
        PageInfo<VoHygieneArea> pageInfo = new PageInfo<>(voHygieneAreaList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加卫生区域信息
     * @param sysHygieneArea 卫生区域model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysHygieneArea sysHygieneArea){
        return sysHygieneAreaService.insert(sysHygieneArea);
    }

    /**
     * 根据卫生区域主键id查询卫生区域信息
     * @param id 卫生区域主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysHygieneAreaService.findById(id);
    }


    /**
     * 修改卫生区域信息
     * @param sysHygieneArea 卫生区域model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysHygieneArea sysHygieneArea){
        return sysHygieneAreaService.update(sysHygieneArea);
    }

    /**
     * 批量删除卫生区域信息
     * @param ids 卫生区域主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysHygieneAreaService.delete(ids.getIds());
    }
}
