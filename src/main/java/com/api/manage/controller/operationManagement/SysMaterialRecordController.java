package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysMaterialRecordService;
import com.api.model.operationManagement.SearchMaterialRecord;
import com.api.model.operationManagement.SysMaterialRecord;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoMaterial;
import com.api.vo.operationManagement.VoMaterialRecord;
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
 * 物料出入库记录管理
 */
@RestController
@RequestMapping("manage/materialRecord")
public class SysMaterialRecordController {
    @Resource
    SysMaterialRecordService sysMaterialRecordService;

    /**
     * 查询所有的物料出入库记录信息
     * @param searchMaterialRecord 物料出入库记录搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchMaterialRecord searchMaterialRecord){
        PageHelper.startPage(searchMaterialRecord.getPageNum(),searchMaterialRecord.getSize());
        List<VoMaterialRecord> voMaterialRecordList = sysMaterialRecordService.list(searchMaterialRecord);
        PageInfo<VoMaterialRecord> pageInfo = new PageInfo<>(voMaterialRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加物料出入库记录信息
     * @param sysMaterialRecord 物料出入库记录model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysMaterialRecord sysMaterialRecord){
        return sysMaterialRecordService.insert(sysMaterialRecord);
    }

    /**
     * 根据物资出库入库主键id查询物资出入库记录详情
     * @param id 物资出库入主键id
     * @return 物资出入库记录详情
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysMaterialRecordService.findById(id);
    }

    /**
     * 批量删除物料出入库记录信息
     * @param ids 物料出入库记录信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysMaterialRecordService.delete(ids.getIds());
    }
}
