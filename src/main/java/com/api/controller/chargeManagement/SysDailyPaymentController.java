package com.api.controller.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
