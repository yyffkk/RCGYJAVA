package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerDecorationService;
import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.model.butlerApp.ButlerTrackInspectionCycle;
import com.api.vo.butlerApp.ButlerDecorationVo;
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
@RequestMapping("butlerApp/user/decoration")
public class ButlerDecorationController {
    @Resource
    ButlerDecorationService butlerDecorationService;

    /**
     * 查询装修管理信息list列表
     * @param decorationSearch 管家app 装修管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerDecorationSearch decorationSearch){
        PageHelper.startPage(decorationSearch.getPageNum(),decorationSearch.getSize());
        List<ButlerDecorationVo> butlerDecorationVos = butlerDecorationService.list(decorationSearch);
        PageInfo<ButlerDecorationVo> pageInfo = new PageInfo<>(butlerDecorationVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据装修主键id查询装修详情
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer decorationId){
        return butlerDecorationService.findById(decorationId);
    }

    /**
     * 立即安排（指派）
     * @param trackInspectionCycle 管家app 跟踪检查周期信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/appoint")
    public Map<String,Object> appoint(@RequestBody ButlerTrackInspectionCycle trackInspectionCycle, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerDecorationService.appoint(trackInspectionCycle,id,roleId);
    }





}
