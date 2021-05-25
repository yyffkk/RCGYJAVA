package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerInterviewService;
import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.vo.butlerApp.ButlerInterviewVo;
import com.api.vo.butlerApp.ButlerRegulationManagementVo;
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
}
