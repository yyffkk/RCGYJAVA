package com.api.manage.controller.butlerService;

import com.api.model.butlerService.SysWorkOrderType;
import com.api.manage.service.butlerService.SysWorkOrderTypeService;
import com.api.vo.butlerService.VoWorkOrderType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 工单类型管理
 */
@RequestMapping("manage/workOrderType")
@RestController
public class SysWorkOrderTypeController {
    @Resource
    SysWorkOrderTypeService sysWorkOrderTypeService;

    /**
     * 查询所有工单大类信息
     * @return 工单大类信息集合
     */
    @GetMapping("/list")
    public List<VoWorkOrderType> list(){
        return sysWorkOrderTypeService.list();
    }

    /**
     * 添加工单大类信息
     * @param sysWorkOrderType 工单大类信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysWorkOrderType sysWorkOrderType){
        return sysWorkOrderTypeService.insert(sysWorkOrderType);
    }

    /**
     * 根据工单大类主键id 查询 工单大类信息
     * @param id 工单大类主键id
     * @return 工单大类信息
     */
    @GetMapping("/findById")
    public VoWorkOrderType findById(Integer id){
        return sysWorkOrderTypeService.findById(id);
    }

    /**
     * 更新工单大类信息
     * @param sysWorkOrderType 新工单大类信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysWorkOrderType sysWorkOrderType){
        return sysWorkOrderTypeService.update(sysWorkOrderType);
    }

    /**
     * 根据主键id删除工单大类信息
     * @param id 工单大类主键id
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        return sysWorkOrderTypeService.delete(id);
    }
}
