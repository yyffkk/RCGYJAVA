package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingShareBill;
import com.api.vo.chargeManagement.VoMeterReadingShareBillDetails;
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
 * 抄表记录管理
 */
@RestController
@RequestMapping("manage/meterReadingRecord")
public class SysMeterReadingRecordController {
    @Resource
    SysMeterReadingRecordService meterReadingRecordService;

    /**
     * 查询所有的抄表记录信息
     * @param searchMeterReadingRecord 抄表记录搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0401"},logical = Logical.AND)
    public Map<String,Object> list(SearchMeterReadingRecord searchMeterReadingRecord){
        PageHelper.startPage(searchMeterReadingRecord.getPageNum(),searchMeterReadingRecord.getSize());
        List<VoMeterReadingRecord> voMeterReadingRecordList = meterReadingRecordService.list(searchMeterReadingRecord);
        PageInfo<VoMeterReadingRecord> pageInfo = new PageInfo<>(voMeterReadingRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加备注
     * @param sysMeterReadingRecord 抄表记录管理
     * @return map
     */
    @PostMapping("/updateRemakes")
    public Map<String,Object> updateRemakes(@RequestBody SysMeterReadingRecord sysMeterReadingRecord){
        return meterReadingRecordService.updateRemakes(sysMeterReadingRecord);
    }

    /**
     * 生成公摊账单
     * @return map
     */
    @PostMapping("/createShareBill")
    public Map<String,Object> createShareBill(@RequestBody SysMeterReadingShareBill sysMeterReadingShareBill){
        return meterReadingRecordService.createShareBill(sysMeterReadingShareBill);
    }

    /**
     * 查询所有的公摊账单信息
     * @param SearchShareBill 公摊账单搜索条件
     * @return map
     */
    @GetMapping("/shareBillList")
    @RequiresPermissions(value = {"0401"},logical = Logical.AND)
    public Map<String,Object> shareBillList(SearchShareBill SearchShareBill){
        PageHelper.startPage(SearchShareBill.getPageNum(),SearchShareBill.getSize());
        List<VoMeterReadingShareBill> voMeterReadingShareBillList = meterReadingRecordService.shareBillList(SearchShareBill);
        PageInfo<VoMeterReadingShareBill> pageInfo = new PageInfo<>(voMeterReadingShareBillList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据公摊账单主键id查询公摊账单明细信息
     * @return map
     */
    @GetMapping("/findShareBillDetailsListByShareId")
    public Map<String,Object> findShareBillDetailsListByShareId(SearchShareBillDetails searchShareBillDetails){
        PageHelper.startPage(searchShareBillDetails.getPageNum(),searchShareBillDetails.getSize());
        List<VoMeterReadingShareBillDetails> voMeterReadingShareBillDetailsList = meterReadingRecordService.findShareBillDetailsListByShareId(searchShareBillDetails);
        PageInfo<VoMeterReadingShareBillDetails> pageInfo = new PageInfo<>(voMeterReadingShareBillDetailsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 人工手动推送公摊账单提醒（群发）
     * @param shareBillPush 抄表公摊账单推送信息
     * @return map
     */
    @PostMapping("/ShareBillPush")
    public Map<String,Object> ShareBillPush(@RequestBody MeterReadingShareBillPush shareBillPush){
        return meterReadingRecordService.ShareBillPush(shareBillPush);
    }

    /**
     * 人工手动推送公摊账单明细提醒（单体）
     * @param shareBillDetailsPush 抄表公摊账单明细推送信息
     * @return map
     */
    @PostMapping("/ShareBillPushDetails")
    public Map<String,Object> ShareBillPushDetails(@RequestBody MeterReadingShareBillDetailsPush shareBillDetailsPush){
        return meterReadingRecordService.ShareBillPushDetails(shareBillDetailsPush);
    }
}
