package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import com.api.model.chargeManagement.SearchMeterReadingRecord;
import com.api.model.chargeManagement.SysMeterReadingRecord;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
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




}
