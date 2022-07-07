package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerUserDecorationNewService;
import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.model.butlerApp.ButlerUserDecorationNewCheck;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 装修管理
 */
@RestController
@RequestMapping("butlerApp/user/userDecorationNew")
public class ButlerUserDecorationNewController {
    @Resource
    ButlerUserDecorationNewService butlerUserDecorationNewService;


    /**
     * 查询所有的装修管理信息
     * @param butlerUserDecorationNewSearch 管家app 新版装修搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch){
        PageHelper.startPage(butlerUserDecorationNewSearch.getPageNum(),butlerUserDecorationNewSearch.getSize());
        List<ButlerUserDecorationNewVo> butlerUserDecorationNewVoList =butlerUserDecorationNewService.list(butlerUserDecorationNewSearch);
        PageInfo<ButlerUserDecorationNewVo> pageInfo = new PageInfo<>(butlerUserDecorationNewVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 提交检查报告
     * @param butlerUserDecorationNewCheck 管家app 新版装修检查信息model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/submitReport")
    public Map<String,Object> submitReport(@RequestBody ButlerUserDecorationNewCheck butlerUserDecorationNewCheck, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerUserDecorationNewService.submitReport(butlerUserDecorationNewCheck,id);
    }

}
