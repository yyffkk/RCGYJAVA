package com.api.controller.chargeManagement;

import com.api.model.chargeManagement.SearchFixedAmountAllocation;
import com.api.model.chargeManagement.SearchFixedAmountAllocationResult;
import com.api.model.chargeManagement.SysFixedAmountAllocation;
import com.api.service.chargeManagement.SysFixedAmountAllocationService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFixedAmountAllocationResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 固定金额分摊
 */
@RestController
@RequestMapping("/fixedAmountAllocation")
public class SysFixedAmountAllocationController {
    @Resource
    SysFixedAmountAllocationService sysFixedAmountAllocationService;

    /**
     * 查询所有的固定金额分摊信息（包含条件搜索）
     * @param searchFixedAmountAllocation 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchFixedAmountAllocation searchFixedAmountAllocation){
        PageHelper.startPage(searchFixedAmountAllocation.getPageNum(),searchFixedAmountAllocation.getSize());
        List<VoFixedAmountAllocation> voFixedAmountAllocationList = sysFixedAmountAllocationService.list(searchFixedAmountAllocation);
        PageInfo<VoFixedAmountAllocation> pageInfo = new PageInfo<>(voFixedAmountAllocationList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加固定金额分摊信息
     * @param sysFixedAmountAllocation 固定金额分摊信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysFixedAmountAllocation sysFixedAmountAllocation){
        return sysFixedAmountAllocationService.insert(sysFixedAmountAllocation);
    }


    /**
     * 根据主键id查询固定金额分摊信息
     * @param id 主键id
     * @return 固定金额分摊信息
     */
    @GetMapping("/findById")
    public VoFindByIdFAA findById(Integer id){
        return sysFixedAmountAllocationService.findById(id);
    }

    /**
     * 修改固定金额分摊信息
     * @param sysFixedAmountAllocation 新固定金额分摊信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysFixedAmountAllocation sysFixedAmountAllocation){
        return sysFixedAmountAllocationService.update(sysFixedAmountAllocation);
    }

    /**
     * 批量删除固定金额分摊信息
     * @param ids 主键id 数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysFixedAmountAllocationService.falseDelete(ids.getIds());
    }

    /**
     * 分摊
     * @param id 固定金额分摊主键id
     * @return map
     */
    @GetMapping("/share")
    public Map<String,Object> share(Integer id){
        return sysFixedAmountAllocationService.share(id);
    }

    /**
     * 查询当前固定金额的分摊结果 （包含条件搜索）
     * @param searchFixedAmountAllocationResult 搜索条件
     * @return map
     */
    @GetMapping("/listResult")
    public Map<String,Object> listResult(SearchFixedAmountAllocationResult searchFixedAmountAllocationResult){
        PageHelper.startPage(searchFixedAmountAllocationResult.getPageNum(),searchFixedAmountAllocationResult.getSize());
        List<VoFixedAmountAllocationResult> voFixedAmountAllocationResultList = sysFixedAmountAllocationService.listResult(searchFixedAmountAllocationResult);
        PageInfo<VoFixedAmountAllocationResult> pageInfo = new PageInfo<>(voFixedAmountAllocationResultList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
