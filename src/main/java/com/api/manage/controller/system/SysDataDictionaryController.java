package com.api.manage.controller.system;

import com.api.manage.service.system.SysDataDictionaryService;
import com.api.vo.system.VoDataDictionary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典表
 */
@RestController
@RequestMapping("/dataDictionary")
public class SysDataDictionaryController {
    @Resource
    SysDataDictionaryService sysDataDictionaryService;

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


}
