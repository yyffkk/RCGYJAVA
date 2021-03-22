package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.ButlerInspectionVo;
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
 * 巡检管理
 */
@RestController
@RequestMapping("butlerApp/user/inspection")
public class ButlerInspectionController {
    @Resource
    ButlerInspectionService butlerInspectionService;

    /**
     * 查询所有的巡检管理信息（包含条件搜索）
     * @param butlerInspectionSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerInspectionSearch butlerInspectionSearch){
        PageHelper.startPage(butlerInspectionSearch.getPageNum(),butlerInspectionSearch.getSize());
        List<ButlerInspectionVo> butlerInspectionVoList = butlerInspectionService.list(butlerInspectionSearch);
        PageInfo<ButlerInspectionVo> pageInfo = new PageInfo<>(butlerInspectionVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据巡检执行情况主键id查询巡检详情
     * @param executeId 巡检执行情况主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer executeId){
        return butlerInspectionService.findDetailById(executeId);
    }

    /**
     * 根据巡检计划主键id查询巡检点部分信息（开始巡检前调用）
     * @param planId 巡检计划主键id
     * @return map
     */
    @GetMapping("/findPointByPlanId")
    public Map<String,Object> findPointByPlanId(Integer planId){
        return butlerInspectionService.findPointByPlanId(planId);
    }

    /**
     * 根据巡检执行情况主键id查询巡检点部分信息（开始巡检后调用）
     * @param executeId 巡检执行情况主键id
     * @return map
     */
    @GetMapping("/findPointByExecuteId")
    public Map<String,Object> findPointByExecuteId(Integer executeId){
        return butlerInspectionService.findPointByExecuteId(executeId);
    }

    /**
     * 开始巡检
     * @param executeId 巡检执行情况主键id
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/startInspection")
    public Map<String,Object> startInspection(Integer executeId,String roleId){
        return butlerInspectionService.startInspection(executeId,roleId);
    }


    /**
     * 扫码二维码查询巡检信息
     * @param executeId 巡检执行情况主键id
     * @param executePointId 巡检执行点主键id（二维码携带内容）
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findCheckDetailByQR")
    public Map<String,Object> findCheckDetailByQR(Integer executeId,Integer executePointId,String roleId){
        return butlerInspectionService.findCheckDetailByQR(executeId,executePointId,roleId);
    }

}
