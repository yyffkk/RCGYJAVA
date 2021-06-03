package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SysWorkOrderTypeDetail;
import com.api.manage.service.butlerService.SysWorkOrderTypeDetailService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoWorkOrderTypeDetail;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 工单类型明细管理
 */
@RestController
@RequestMapping("manage/workOrderTypeDetail")
public class SysWorkOrderTypeDetailController   {
    @Resource
    SysWorkOrderTypeDetailService sysWorkOrderTypeDetailService;

    /**
     * 根据工单大类主键id查询工单类型明细信息
     * @param id 工单大类主键id
     * @return 工单类型明细信息集合
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public List<VoWorkOrderTypeDetail> list(Integer id){
        return  sysWorkOrderTypeDetailService.list(id);
    }

    /**
     * 添加工单类型明细信息
     * @param sysWorkOrderTypeDetail 工单类型明细信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysWorkOrderTypeDetail sysWorkOrderTypeDetail){
        return sysWorkOrderTypeDetailService.insert(sysWorkOrderTypeDetail);
    }

    /**
     * 根据工单类型明细主键id查询工单类型明细信息
     * @param id 工单类型明细主键id
     * @return 工单类型明细信息集合
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public VoWorkOrderTypeDetail findById(Integer id){
        return sysWorkOrderTypeDetailService.findById(id);
    }

    /**
     * 更新工单类型明细信息
     * @param sysWorkOrderTypeDetail 新工单类型明细信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysWorkOrderTypeDetail sysWorkOrderTypeDetail){
        return sysWorkOrderTypeDetailService.update(sysWorkOrderTypeDetail);
    }

    /**
     * 删除工单类型明细
     * @param ids 工单类型明细主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysWorkOrderTypeDetailService.delete(ids.getIds());
    }


}
