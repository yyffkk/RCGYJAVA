package com.api.controller.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.service.operationManagement.SysSponsorManagementService;
import com.api.vo.operationManagement.VoNotificationManagement;
import com.api.vo.operationManagement.VoSponsorManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主办方管理
 */
@RestController
@RequestMapping("/sponsorManagement")
public class SysSponsorManagementController {
    @Resource
    SysSponsorManagementService sysSponsorManagementService;

    /**
     * 查询所有的主办方信息（包含条件搜索）
     * @param searchSponsorManagement 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchSponsorManagement searchSponsorManagement){
        PageHelper.startPage(searchSponsorManagement.getPageNum(),searchSponsorManagement.getSize());
        List<VoSponsorManagement> voSponsorManagementList = sysSponsorManagementService.list(searchSponsorManagement);
        PageInfo<VoSponsorManagement> pageInfo = new PageInfo<>(voSponsorManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加主办方信息
     * @param sponsorManagement 主办方信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SponsorManagement sponsorManagement){
        return sysSponsorManagementService.insert(sponsorManagement);
    }
}
