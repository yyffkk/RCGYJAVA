package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesAppointmentService;

import com.api.model.butlerService.FacilitiesAppointment;
import com.api.model.butlerService.SearchFacilitiesAppointment;
import com.api.vo.butlerService.VoFacilitiesAppointment;
import com.api.vo.butlerService.VoFacilitiesCategory;
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
 * 设施预约管理
 */
@RestController
@RequestMapping("manage/facilitiesAppointment")
public class SysFacilitiesAppointmentController   {
    @Resource
    SysFacilitiesAppointmentService facilitiesAppointmentService;

    /**
     * 查询所有的设施预约信息（包含搜索条件）
     * @param searchFacilitiesAppointment 设施预约管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchFacilitiesAppointment searchFacilitiesAppointment){
        PageHelper.startPage(searchFacilitiesAppointment.getPageNum(),searchFacilitiesAppointment.getSize());
        List<VoFacilitiesAppointment> voFacilitiesAppointmentList = facilitiesAppointmentService.list(searchFacilitiesAppointment);
        PageInfo<VoFacilitiesAppointment> pageInfo = new PageInfo<>(voFacilitiesAppointmentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加设施预约信息
     * @param facilitiesAppointment 设施预约管理model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody FacilitiesAppointment facilitiesAppointment){
        return facilitiesAppointmentService.insert(facilitiesAppointment);
    }

    /**
     * 作废设施预约信息
     * @param facilitiesAppointment 设施预约信息主键id 和 作废原因
     * @return map
     */
    @PostMapping("/nullify")
    public Map<String,Object> nullify(@RequestBody FacilitiesAppointment facilitiesAppointment){
        return facilitiesAppointmentService.nullify(facilitiesAppointment);
    }

    /**
     * 查询今日新增预约数量
     * @return map
     */
    @GetMapping("/countAppointmentNow")
    public Map<String,Object> countAppointmentNow(){
        return facilitiesAppointmentService.countAppointmentNow();
    }

    /**
     * 修改设施预约信息
     * @param facilitiesAppointment 设施预约管理model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody FacilitiesAppointment facilitiesAppointment){
        return facilitiesAppointmentService.update(facilitiesAppointment);
    }


}
