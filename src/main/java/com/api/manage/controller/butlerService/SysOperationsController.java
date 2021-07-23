package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysOperationsService;
import com.api.model.butlerService.SearchOperations;
import com.api.model.butlerService.SysOperations;
import com.api.vo.butlerService.VoOperations;
import com.api.vo.butlerService.VoUserAdvice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运维管理
 */
@RestController
@RequestMapping("manage/sysOperations")
public class SysOperationsController {
    @Resource
    SysOperationsService sysOperationsService;


    /**
     * 查询所有的运维管理（包含条件搜索）
     * @param searchOperations 运维管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchOperations searchOperations){
        PageHelper.startPage(searchOperations.getPageNum(),searchOperations.getSize());
        List<VoOperations> voOperationsList = sysOperationsService.list(searchOperations);
        PageInfo<VoOperations> pageInfo = new PageInfo<>(voOperationsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加运维管理信息
     * @param sysOperations 运维管理model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysOperations sysOperations){
        return sysOperationsService.insert(sysOperations);
    }

}
