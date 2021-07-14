package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysDailyPaymentPlanService;
import com.api.model.chargeManagement.DailyPaymentPlan;
import com.api.model.chargeManagement.SearchDailyPaymentPlan;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoDailyPaymentPlan;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日常缴费计划表【暂定每月1号生成对应缴费记录，新添加的计费计划次月生效，当月物业费需线下解决】
 */
@RestController
@RequestMapping("manage/dailyPaymentPlan")
public class SysDailyPaymentPlanController {
    @Resource
    SysDailyPaymentPlanService sysDailyPaymentPlanService;

    /**
     * 查询所有的缴费计划
     * @param searchDailyPaymentPlan 缴费计划搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchDailyPaymentPlan searchDailyPaymentPlan){
        PageHelper.startPage(searchDailyPaymentPlan.getPageNum(),searchDailyPaymentPlan.getSize());
        List<VoDailyPaymentPlan> voDailyPaymentPlanList = sysDailyPaymentPlanService.list(searchDailyPaymentPlan);
        PageInfo<VoDailyPaymentPlan> pageInfo = new PageInfo<>(voDailyPaymentPlanList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加缴费计划
     * @param dailyPaymentPlan 缴费计划（周期生成缴费记录）
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody DailyPaymentPlan dailyPaymentPlan){
        return sysDailyPaymentPlanService.insert(dailyPaymentPlan);
    }

    /**
     * 修改缴费计划
     * @param dailyPaymentPlan 缴费计划（周期生成缴费记录）
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody DailyPaymentPlan dailyPaymentPlan){
        return sysDailyPaymentPlanService.update(dailyPaymentPlan);
    }

}
