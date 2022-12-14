package com.api.manage.controller.system;

import com.api.manage.service.system.SysDataDictionaryService;
import com.api.model.system.SysDataDictionary;
import com.api.model.system.SysDataDictionarySearch;
import com.api.vo.businessManagement.VoSalary;
import com.api.vo.system.VoDataDictionary;
import com.api.vo.system.VoDataDictionaryList;
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
 * 数据字典表
 */
@RestController
@RequestMapping("manage/dataDictionary")
public class SysDataDictionaryController {
    @Resource
    SysDataDictionaryService sysDataDictionaryService;

    /**
     * 查询所有的数据字典信息
     * @param sysDataDictionarySearch 数据字典搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SysDataDictionarySearch sysDataDictionarySearch){
        PageHelper.startPage(sysDataDictionarySearch.getPageNum(),sysDataDictionarySearch.getSize());
        List<VoDataDictionaryList> voDataDictionaryLists = sysDataDictionaryService.list(sysDataDictionarySearch);
        PageInfo<VoDataDictionaryList> pageInfo = new PageInfo<>(voDataDictionaryLists);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 修改数据字典信息
     * @param sysDataDictionary 系统数据字典表
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysDataDictionary sysDataDictionary){
        return sysDataDictionaryService.update(sysDataDictionary);
    }


    /**
     * 查询车位状态 cpm_parking_space_status
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findParkingSpaceStatus")
    public List<VoDataDictionary> findParkingSpaceStatus(){
        return sysDataDictionaryService.findParkingSpaceStatus();
    }

    /**
     * 查询住户证件类型 user_resident_id_type
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findUserResidentIdType")
    public List<VoDataDictionary> findUserResidentIdType(){
        return sysDataDictionaryService.findUserResidentIdType();
    }

    /**
     * 查询车位类型 cpm_parking_space_type
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findParkingSpaceType")
    public List<VoDataDictionary> findParkingSpaceType(){
        return sysDataDictionaryService.findParkingSpaceType();
    }

    /**
     * 查询房屋状态 cpm_building_unit_estate_status
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findEstateStatus")
    public List<VoDataDictionary> findEstateStatus(){
        return sysDataDictionaryService.findEstateStatus();
    }

    /**
     * 查询房屋类型 cpm_building_unit_estate_type
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findEstateType")
    public List<VoDataDictionary> findEstateType(){
        return sysDataDictionaryService.findEstateType();
    }


    /**
     * 查询车辆类型 user_car_type
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findUserCarType")
    public List<VoDataDictionary> findUserCarType(){
        return sysDataDictionaryService.findUserCarType();
    }

    /**
     * 查询车辆状态 user_car_status
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findUserCarStatus")
    public List<VoDataDictionary> findUserCarStatus(){
        return sysDataDictionaryService.findUserCarStatus();
    }


    /**
     * 查询租户状态 cpm_resident_estate_status
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("findResidentEstateStatus")
    public List<VoDataDictionary> findResidentEstateStatus(){
        return sysDataDictionaryService.findResidentEstateStatus();
    }

    /**
     * 查询亲属身份 user_resident_relatives_identity
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("findResidentRelativesIdentity")
    public List<VoDataDictionary> findResidentRelativesIdentity(){
        return sysDataDictionaryService.findResidentRelativesIdentity();
    }

    /**
     * 查询装修成员身份 cpm_decoration_staff_identity
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("findDecorationStaffIdentity")
    public List<VoDataDictionary> findDecorationStaffIdentity(){
        return sysDataDictionaryService.findDecorationStaffIdentity();
    }

    /**
     * 查询住户类型 user_resident_type
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("findUserResidentType")
    public List<VoDataDictionary> findUserResidentType(){
        return sysDataDictionaryService.findUserResidentType();
    }

    /**
     * 查询日常缴费计费单位 sys_daily_payment
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findSysDailyPaymentType")
    public List<VoDataDictionary> findSysDailyPaymentType(){
        return sysDataDictionaryService.findSysDailyPaymentType();
    }

    /**
     * 查询派工单详情表-派工类型 sys_dispatch_list_detail
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findSysDispatchListDetailType")
    public List<VoDataDictionary> findSysDispatchListDetailType(){
        return sysDataDictionaryService.findSysDispatchListDetailType();
    }

    /**
     * 查询派工单延时信息表-延时时间 sys_dispatch_list_delayed_delayed
     * @return List<VoDecoration> 回显字典数据集合
     */
    @GetMapping("/findSysDispatchListDelayedDelayed")
    public List<VoDataDictionary> findSysDispatchListDelayedDelayed(){
        return sysDataDictionaryService.findSysDispatchListDelayedDelayed();
    }







}
