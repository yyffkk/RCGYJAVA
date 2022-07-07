package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerInterviewService;
import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.model.operationManagement.Interview;
import com.api.vo.butlerApp.ButlerInterviewVo;
import com.api.vo.butlerApp.ButlerRegulationManagementVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 客户访谈管理
 */
@RestController
@RequestMapping("butlerApp/user/interview")
public class ButlerInterviewController {
    @Resource
    ButlerInterviewService butlerInterviewService;

    /**
     * 查询所有客户访谈信息
     * @param butlerInterviewSearch 管家app 客户访谈搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerInterviewSearch butlerInterviewSearch){
        PageHelper.startPage(butlerInterviewSearch.getPageNum(),butlerInterviewSearch.getSize());
        List<ButlerInterviewVo> butlerInterviewVoList =butlerInterviewService.list(butlerInterviewSearch);
        PageInfo<ButlerInterviewVo> pageInfo = new PageInfo<>(butlerInterviewVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 访谈回复
     * @param interview 客户访谈model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/feedBack")
    public Map<String,Object> feedBack(@RequestBody Interview interview, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerInterviewService.feedBack(interview,id);
    }
}
