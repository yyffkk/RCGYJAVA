package com.api.manage.controller.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.manage.service.operationManagement.SysSponsorManagementService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoFindByIdSponsorManagement;
import com.api.vo.operationManagement.VoSponsorActivityDetail;
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
@RequestMapping("manage/sponsorManagement")
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

    /**
     * 根据主键id查询主办方信息
     * @param id 主键id
     * @return 主办方信息
     */
    @GetMapping("/findById")
    public VoFindByIdSponsorManagement findById(Integer id){
        return sysSponsorManagementService.findById(id);
    }

    /**
     * 修改主办方信息
     * @param sponsorManagement 新主办方信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SponsorManagement sponsorManagement){
        return sysSponsorManagementService.update(sponsorManagement);
    }

    /**
     * 批量删除主办方信息
     * @param ids 主办方信息主键id 数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysSponsorManagementService.falseDelete(ids.getIds());
    }

    /**
     * 主办活动详情
     * @param id 主办方主键id
     * @return 活动名称集合
     */
    @GetMapping("/sponsorActivityDetail")
    public List<VoSponsorActivityDetail> sponsorActivityDetail(Integer id){
        return sysSponsorManagementService.sponsorActivityDetail(id);
    }


}
