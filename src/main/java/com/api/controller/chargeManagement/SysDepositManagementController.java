package com.api.controller.chargeManagement;

import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.service.chargeManagement.SysDepositManagementService;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoDepositManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 押金管理
 */
@RestController
@RequestMapping("/depositManagement")
public class SysDepositManagementController {
    @Resource
    SysDepositManagementService sysDepositManagementService;

    /**
     * 查询所有的押金信息 （包含条件搜索）
     * @param searchDepositManagement 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchDepositManagement searchDepositManagement){
        PageHelper.startPage(searchDepositManagement.getPageNum(),searchDepositManagement.getSize());
        List<VoDepositManagement> voDepositManagementList = sysDepositManagementService.list(searchDepositManagement);
        PageInfo<VoDepositManagement> pageInfo = new PageInfo<>(voDepositManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
