package com.api.manage.controller.chargeManagement;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.chargeManagement.DailyPayment;
import com.api.model.chargeManagement.DailyPaymentOrder;
import com.api.model.chargeManagement.DailyPaymentPush;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.manage.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import com.api.vo.chargeManagement.VoPayResident;
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
 * 日常缴费表
 */
@RestController
@RequestMapping("manage/dailyPayment")
public class SysDailyPaymentController extends ShiroExceptions {
    @Resource
    SysDailyPaymentService sysDailyPaymentService;

    /**
     * 查询所有的日常缴费信息 （包含条件搜索）
     * @param searchDailyPayment 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public Map<String,Object> list(SearchDailyPayment searchDailyPayment){
        PageHelper.startPage(searchDailyPayment.getPageNum(),searchDailyPayment.getSize());
        List<VoDailyPayment> voDailyPaymentList = sysDailyPaymentService.list(searchDailyPayment);
        PageInfo<VoDailyPayment> pageInfo = new PageInfo<>(voDailyPaymentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加缴费信息
     * @param dailyPayment 缴费信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0403","04"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody DailyPayment dailyPayment){
        return sysDailyPaymentService.insert(dailyPayment);
    }


    /**
     * 根据日常缴费主键id查询缴费信息
     * @param id 日常缴费主键id
     * @return 缴费信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0402","04"},logical = Logical.AND)
    public VoFindByIdDailyPayment findById(Integer id){
        return sysDailyPaymentService.findById(id);
    }


//    /**
//     * 更新缴费信息（如果订单已生成，则不可修改信息）【设计图没有更新】
//     * @param dailyPayment 新缴费信息
//     * @return map
//     */
//    public Map<String,Object> update(@RequestBody DailyPayment dailyPayment){
//        return null;
//    }

    /**
     * 人工手动推送日常缴费提醒
     * @param dailyPaymentPush 推送的信息
     * @return map
     */
    @PostMapping("/push")
    @RequiresPermissions(value = {"0407","04"},logical = Logical.AND)
    public Map<String,Object> push(@RequestBody DailyPaymentPush dailyPaymentPush){
        return sysDailyPaymentService.push(dailyPaymentPush);
    }

    /**
     * 添加日常缴费订单信息（缴费）【打印功能未做】
     * @param dailyPaymentOrder 日常缴费订单信息
     * @return map
     */
    @PostMapping("/insertOrder")
    @RequiresPermissions(value = {"0403","04"},logical = Logical.AND)
    public Map<String,Object> insertOrder(@RequestBody DailyPaymentOrder dailyPaymentOrder){
        return sysDailyPaymentService.insertOrder(dailyPaymentOrder);
    }


    /**
     * 根据房产id查询待缴费人信息
     * @param id 房产id
     * @return map
     */
    @GetMapping("/findResidentByEstateId")
    @RequiresPermissions(value = {"0402","04"},logical = Logical.AND)
    public VoPayResident findResidentByEstateId(Integer id){
        return sysDailyPaymentService.findResidentByEstateId(id);
    }




}
