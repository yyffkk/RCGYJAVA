package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysMaterialRecordService;
import com.api.model.operationManagement.SearchMaterialRecord;
import com.api.model.operationManagement.SysMaterialRecord;
import com.api.vo.operationManagement.VoMaterial;
import com.api.vo.operationManagement.VoMaterialRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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


}
