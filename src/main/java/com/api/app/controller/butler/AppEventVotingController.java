package com.api.app.controller.butler;

import com.api.app.service.butler.AppEventVotingService;
import com.api.model.app.AppVotePersonnel;
import com.api.vo.app.AppEventVotingVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 活动投票
 */
@RestController
@RequestMapping("app/user/eventVoting")
public class AppEventVotingController {
    @Resource
    AppEventVotingService appEventVotingService;

    /**
     * app查询所有活动投票信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @param type 用户类型
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id,Integer type){
        PageHelper.startPage(pageNum,size);
        List<AppEventVotingVo> appEventVotingVos =appEventVotingService.list(id,type);
        PageInfo<AppEventVotingVo> pageInfo = new PageInfo<>(appEventVotingVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 投票详情
     * @param voteId 投票信息主键id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/voteDetail")
    public Map<String,Object> voteDetail(Integer voteId,Integer id){
        return appEventVotingService.voteDetail(voteId,id);
    }

    /**
     * 用户投票
     * @param appVotePersonnel 投票人投票信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/vote")
    public Map<String,Object> vote(@RequestBody AppVotePersonnel appVotePersonnel, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        appVotePersonnel.setVoterId(id);
        return appEventVotingService.vote(appVotePersonnel);
    }
}
