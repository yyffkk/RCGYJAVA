package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysGreenAreaService;
import com.api.model.operationManagement.SearchGreenArea;
import com.api.model.operationManagement.SysGreenArea;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoGreenArea;
import com.api.vo.operationManagement.VoKeyManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 绿化区域管理
 */
@RestController
@RequestMapping("manage/greenArea")
public class SysGreenAreaController {
    @Resource
    SysGreenAreaService sysGreenAreaService;

    /**
     * 查询所有的绿化区域信息（包含条件搜索）
     * @param searchGreenArea 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchGreenArea searchGreenArea){
        PageHelper.startPage(searchGreenArea.getPageNum(),searchGreenArea.getSize());
        List<VoGreenArea> voGreenAreaList = sysGreenAreaService.list(searchGreenArea);
        PageInfo<VoGreenArea> pageInfo = new PageInfo<>(voGreenAreaList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加绿化区域信息
     * @param sysGreenArea 绿化区域model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysGreenArea sysGreenArea){
        return sysGreenAreaService.insert(sysGreenArea);
    }


    /**
     * 根据绿化区域主键id查询绿化区域信息
     * @param id 绿化区域主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysGreenAreaService.findById(id);
    }

    /**
     * 修改绿化区域信息
     * @param sysGreenArea 绿化区域model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysGreenArea sysGreenArea){
        return sysGreenAreaService.update(sysGreenArea);
    }

    /**
     * 批量删除绿化区域
     * @param ids 绿化区域主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysGreenAreaService.delete(ids.getIds());
    }
}
