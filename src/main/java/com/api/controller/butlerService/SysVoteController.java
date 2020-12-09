package com.api.controller.butlerService;

import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SysVote;
import com.api.service.butlerService.SysVoteService;
import com.api.vo.butlerService.VoUserAdvice;
import com.api.vo.butlerService.VoVote;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 投票管理
 */
@RestController
@RequestMapping("vote")
public class SysVoteController {
    @Resource
    SysVoteService sysVoteService;

    /**
     * 查询所有投票信息（包含条件搜索）
     * @param searchVote 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchVote searchVote){
        PageHelper.startPage(searchVote.getPageNum(),searchVote.getSize());
        List<VoVote> voVoteList = sysVoteService.list(searchVote);
        PageInfo<VoVote> pageInfo = new PageInfo<>(voVoteList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据投票主键id查询投票信息（修改页面）
     * @param id 投票主键id
     * @return 投票信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysVoteService.findById(id);
    }

    /**
     * 添加投票管理信息
     * @param sysVote 投票信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysVote sysVote){
        return sysVoteService.insert(sysVote);
    }

    /**
     * 修改投票管理信息
     * @param sysVote 新投票管理信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysVote sysVote){
        return sysVoteService.update(sysVote);
    }








}
