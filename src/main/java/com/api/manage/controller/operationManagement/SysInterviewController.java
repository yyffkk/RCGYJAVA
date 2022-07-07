package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysInterviewService;
import com.api.model.operationManagement.Interview;
import com.api.model.operationManagement.SearchInterview;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoInterview;
import com.api.vo.operationManagement.VoKeyBorrow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户访谈管理
 */
@RestController
@RequestMapping("manage/interview")
public class SysInterviewController {
    @Resource
    SysInterviewService sysInterviewService;

    /**
     * 查询所有的访谈信息
     * @param searchInterview 客户访谈搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchInterview searchInterview){
        PageHelper.startPage(searchInterview.getPageNum(),searchInterview.getSize());
        List<VoInterview> voInterviewList = sysInterviewService.list(searchInterview);
        PageInfo<VoInterview> pageInfo = new PageInfo<>(voInterviewList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加访谈信息
     * @param interview 客户访谈model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Interview interview){
        return sysInterviewService.insert(interview);
    }

    /**
     * 批量删除访谈信息
     * @param ids 访谈信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysInterviewService.delete(ids.getIds());
    }
}
