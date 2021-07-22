package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 绿化管理
 */
@RestController
@RequestMapping("butlerApp/user/green")
public class ButlerGreenController {
    @Resource
    ButlerGreenService butlerGreenService;

    /**
     * 查询所有的绿化管理
     * @param butlerGreenSearch 管家app 绿化任务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerGreenSearch butlerGreenSearch){
        PageHelper.startPage(butlerGreenSearch.getPageNum(),butlerGreenSearch.getSize());
        List<ButlerGreenVo> butlerGreenVoList =butlerGreenService.list(butlerGreenSearch);
        PageInfo<ButlerGreenVo> pageInfo = new PageInfo<>(butlerGreenVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 确认完成
     * @param sysGreenTask 绿化任务管理model信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/complete")
    public Map<String,Object> complete(@RequestBody SysGreenTask sysGreenTask, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String name = request.getParameter("name");
        //从request获取组织ID organizationId
        Integer organizationId = Integer.valueOf(request.getParameter("organizationId"));
        sysGreenTask.setDirector(id);//填入负责人员id
        return butlerGreenService.complete(sysGreenTask,name,organizationId);
    }

}
