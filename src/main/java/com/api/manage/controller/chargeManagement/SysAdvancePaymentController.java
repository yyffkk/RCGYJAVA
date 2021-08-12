package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysAdvancePaymentService;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.model.chargeManagement.SysAdvancePaymentRefundRecord;
import com.api.vo.chargeManagement.VoAdvancePayment;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预缴管理
 */
@RestController
@RequestMapping("manage/advancePayment")
public class SysAdvancePaymentController {
    @Resource
    SysAdvancePaymentService sysAdvancePaymentService;


    /**
     * 查询预缴管理所有预缴信息（包含条件搜索）
     * @param searchAdvancePayment 预缴搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAdvancePayment searchAdvancePayment){
        PageHelper.startPage(searchAdvancePayment.getPageNum(),searchAdvancePayment.getSize());
        List<VoAdvancePayment> voAdvancePaymentList = sysAdvancePaymentService.list(searchAdvancePayment);
        PageInfo<VoAdvancePayment> pageInfo = new PageInfo<>(voAdvancePaymentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据房产主键id查询预缴详情
     * @param estateId 房产主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer estateId){
        return sysAdvancePaymentService.findDetailById(estateId);
    }

    /**
     * 预缴退款
     * @param sysAdvancePaymentRefundRecord 预缴退款记录
     * @return map
     */
    @PostMapping("/refund")
    public Map<String,Object> refund(@RequestBody SysAdvancePaymentRefundRecord sysAdvancePaymentRefundRecord){
        return sysAdvancePaymentService.refund(sysAdvancePaymentRefundRecord);
    }
}
