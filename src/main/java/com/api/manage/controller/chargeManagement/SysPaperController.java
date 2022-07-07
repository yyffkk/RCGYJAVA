package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysPaperService;
import com.api.model.chargeManagement.SearchPaper;
import com.api.model.chargeManagement.SysPaper;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.chargeManagement.SysPaperVo;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发票管理
 */
@RestController
@RequestMapping("manage/paper")
public class SysPaperController {
    @Resource
    SysPaperService sysPaperService;

    /**
     * 查询所有的票据信息（包含条件搜索）
     * @param searchPaper 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchPaper searchPaper){
        PageHelper.startPage(searchPaper.getPageNum(),searchPaper.getSize());
        List<SysPaperVo> sysPaperVoList = sysPaperService.list(searchPaper);
        PageInfo<SysPaperVo> pageInfo = new PageInfo<>(sysPaperVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加票据信息
     * @param sysPaper 票据管理mode
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysPaper sysPaper){
        return sysPaperService.insert(sysPaper);
    }

    /**
     * 领用票据
     * @param sysPaper 票据管理mode
     * @return map
     */
    @PostMapping("/recipients")
    public Map<String,Object> recipients(@RequestBody SysPaper sysPaper){
        return sysPaperService.recipients(sysPaper);
    }

    /**
     * 批量删除
     * @param ids 票据管理主键id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysPaperService.delete(ids.getIds());
    }
}
