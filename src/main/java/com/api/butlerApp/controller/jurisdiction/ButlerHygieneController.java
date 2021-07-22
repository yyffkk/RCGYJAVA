package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerHygieneService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.api.vo.butlerApp.ButlerHygieneVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 卫生管理
 */
@RestController
@RequestMapping("butlerApp/user/hygiene")
public class ButlerHygieneController {
    @Resource
    ButlerHygieneService butlerHygieneService;

    /**
     * 查询所有的卫生管理
     * @param butlerHygieneSearch 管家app 卫生任务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerHygieneSearch butlerHygieneSearch){
        PageHelper.startPage(butlerHygieneSearch.getPageNum(),butlerHygieneSearch.getSize());
        List<ButlerHygieneVo> butlerHygieneVoList =butlerHygieneService.list(butlerHygieneSearch);
        PageInfo<ButlerHygieneVo> pageInfo = new PageInfo<>(butlerHygieneVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 确认完成
     * @param sysHygieneTask 卫生任务管理model信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/complete")
    public Map<String,Object> complete(@RequestBody SysHygieneTask sysHygieneTask, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String name = request.getParameter("name");
        //从request获取组织ID organizationId
        Integer organizationId = Integer.valueOf(request.getParameter("organizationId"));
        sysHygieneTask.setDirector(id);//填入负责人员id
        return butlerHygieneService.complete(sysHygieneTask,name,organizationId);
    }
}
