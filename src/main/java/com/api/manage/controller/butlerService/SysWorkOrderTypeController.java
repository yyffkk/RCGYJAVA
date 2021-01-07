package com.api.manage.controller.butlerService;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.butlerService.SysWorkOrderType;
import com.api.manage.service.butlerService.SysWorkOrderTypeService;
import com.api.vo.butlerService.VoWorkOrderType;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 工单类型管理
 */
@RequestMapping("manage/workOrderType")
@RestController
public class SysWorkOrderTypeController extends ShiroExceptions {
    @Resource
    SysWorkOrderTypeService sysWorkOrderTypeService;

    /**
     * 查询所有工单大类信息
     * @return 工单大类信息集合
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public List<VoWorkOrderType> list(){
        return sysWorkOrderTypeService.list();
    }

    /**
     * 添加工单大类信息
     * @param sysWorkOrderType 工单大类信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysWorkOrderType sysWorkOrderType){
        return sysWorkOrderTypeService.insert(sysWorkOrderType);
    }

    /**
     * 根据工单大类主键id 查询 工单大类信息
     * @param id 工单大类主键id
     * @return 工单大类信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public VoWorkOrderType findById(Integer id){
        return sysWorkOrderTypeService.findById(id);
    }

    /**
     * 更新工单大类信息
     * @param sysWorkOrderType 新工单大类信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysWorkOrderType sysWorkOrderType){
        return sysWorkOrderTypeService.update(sysWorkOrderType);
    }

    /**
     * 根据主键id删除工单大类信息
     * @param id 工单大类主键id
     * @return map
     */
    @GetMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(Integer id){
        return sysWorkOrderTypeService.delete(id);
    }
}
