package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import com.api.model.chargeManagement.SearchMeterReadingRecord;
import com.api.model.chargeManagement.SearchShareBillDetails;
import com.api.model.chargeManagement.SysMeterReadingRecord;
import com.api.model.chargeManagement.SysMeterReadingShareBill;
import com.api.vo.chargeManagement.VoDailyPaymentPlan;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingShareBillDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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



}
