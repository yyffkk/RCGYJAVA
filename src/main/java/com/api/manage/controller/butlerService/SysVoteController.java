package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SearchVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.manage.service.butlerService.SysVoteService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFindDetailByIdVoteCandidate;
import com.api.vo.butlerService.VoVote;
import com.api.vo.butlerService.VoVotePersonnel;
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
 * 投票管理
 */
@RestController
@RequestMapping("manage/vote")
public class SysVoteController   {
    @Resource
    SysVoteService sysVoteService;

    /**
     * 查询所有投票信息（包含条件搜索）
     * @param searchVote 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
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
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysVoteService.findById(id);
    }

    /**
     * 根据投票主键id查询投票信息（详情页面）
     * @param id 投票主键id
     * @return 投票信息
     */
    @GetMapping("/findDetailById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> findDetailById(Integer id){
        return sysVoteService.findDetailById(id);
    }


    /**
     * 添加投票管理信息
     * @param sysVote 投票信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysVote sysVote){
        return sysVoteService.insert(sysVote);
    }

    /**
     * 修改投票管理信息
     * @param sysVote 新投票管理信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysVote sysVote){
        return sysVoteService.update(sysVote);
    }

    /**
     * 根据投票管理主键id批量删除投票信息(假删除)
     * @param ids 投票管理主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysVoteService.falseDelete(ids.getIds());
    }

    /**
     * 根据投票管理主键id批量发布投票信息
     * @param ids 投票管理主键id数组
     * @return map
     */
    @PostMapping("/release")
    @RequiresPermissions(value = {"0313","03"},logical = Logical.AND)
    public Map<String,Object> release(@RequestBody VoIds ids){
        return sysVoteService.release(ids.getIds());
    }

    /**
     * 根据投票管理主键id查询所有投票候选人信息（详情页面）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 投票管理主键id
     * @return map
     */
    @GetMapping("/listDetailCandidate")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> listDetailCandidate(int pageNum,int size,int id){
        PageHelper.startPage(pageNum,size);
        List<VoFindDetailByIdVoteCandidate> voFindDetailByIdVoteCandidates = sysVoteService.listDetailCandidate(id);
        PageInfo<VoFindDetailByIdVoteCandidate> pageInfo = new PageInfo<>(voFindDetailByIdVoteCandidates);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据投票管理主键id和候选人主键ID查询候选人投票详情信息
     * @param searchVotePersonnel 投票人搜索条件
     * @return map
     */
    @GetMapping("/listVotePersonnel")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> listVotePersonnel(SearchVotePersonnel searchVotePersonnel){
        PageHelper.startPage(searchVotePersonnel.getPageNum(),searchVotePersonnel.getSize());
        List<VoVotePersonnel> voVotePersonnelList = sysVoteService.listVotePersonnel(searchVotePersonnel);
        PageInfo<VoVotePersonnel> pageInfo = new PageInfo<>(voVotePersonnelList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 即将开始的投票数
     * @return map
     */
    @GetMapping("countVoteExpectedStart")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> countVoteExpectedStart(){
        return sysVoteService.countVoteExpectedStart();
    }











}
