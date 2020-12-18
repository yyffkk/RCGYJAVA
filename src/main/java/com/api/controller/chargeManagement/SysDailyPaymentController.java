package com.api.controller.chargeManagement;

import com.api.model.chargeManagement.DailyPayment;
import com.api.model.chargeManagement.DailyPaymentPush;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日常缴费表
 */
@RestController
@RequestMapping("dailyPayment")
public class SysDailyPaymentController {
    @Resource
    SysDailyPaymentService sysDailyPaymentService;

    /**
     * 查询所有的日常缴费信息 （包含条件搜索）
     * @param searchDailyPayment 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
     * 添加缴费信息 ？？？？？？
     * @param dailyPayment 缴费信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody DailyPayment dailyPayment){
        return null;
    }


    /**
     * 根据日常缴费主键id查询缴费信息
     * @param id 日常缴费主键id
     * @return 缴费信息
     */
    @GetMapping("/findById")
    public VoFindByIdDailyPayment findById(Integer id){
        return sysDailyPaymentService.findById(id);
    }

    /**
     * 更新缴费信息 ？？？？
     * @param dailyPayment 新缴费信息
     * @return map
     */
    public Map<String,Object> update(@RequestBody DailyPayment dailyPayment){
        return null;
    }

    /**
     * 人工手动推送日常缴费提醒
     * @param dailyPaymentPush 推送的信息
     * @return map
     */
    @PostMapping("/push")
    public Map<String,Object> push(@RequestBody DailyPaymentPush dailyPaymentPush){
        return sysDailyPaymentService.push(dailyPaymentPush);
    }


}
