package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.model.butlerApp.ButlerExecuteMap;
import com.api.model.butlerApp.ButlerExecutePointSubmit;
import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.ButlerInspectionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
     * 扫码二维码查询巡检执行点信息
     * @param executeId 巡检执行情况主键id
     * @param executePointCode 巡检执行点编号（二维码携带内容）
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findCheckDetailByQR")
    public Map<String,Object> findCheckDetailByQR(Integer executeId,String executePointCode,String roleId){
        return butlerInspectionService.findCheckDetailByQR(executeId,executePointCode,roleId);
    }

    /**
     * 提交巡检执行点信息
     * @param executePointSubmit 执行巡检点提交信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/submitPointDetail")
    public Map<String,Object> submitPointDetail(@RequestBody ButlerExecutePointSubmit executePointSubmit, HttpServletRequest request){
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerInspectionService.submitPointDetail(executePointSubmit,roleId);
    }


    /**
     * 查询巡检执行点信息（当前巡检执行计划状态为2.已巡检，3.巡检中）
     * @param executePointId 巡检执行点主键id
     * @return map
     */
    @GetMapping("/findCheckDetailById")
    public Map<String,Object> findCheckDetailById(Integer executePointId){
        return butlerInspectionService.findCheckDetailById(executePointId);
    }

    /**
     * 查询巡检执行点信息（当前巡检执行计划状态为1.待巡检，4.未巡检）
     * @param planPointId 计划巡检点主键id
     * @return map
     */
    @GetMapping("/findCheckDetailById2")
    public Map<String,Object> findCheckDetailById2(Integer planPointId){
        return butlerInspectionService.findCheckDetailById2(planPointId);
    }

    /**
     * 上传巡检定位信息
     * @param butlerExecuteMap 巡检执行路线地图经纬度信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/uploadLocation")
    public Map<String,Object> uploadLocation(@RequestBody ButlerExecuteMap butlerExecuteMap, HttpServletRequest request){
        //从request获取用户主键id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        butlerExecuteMap.setCreateId(id); //填入创建人
        return butlerInspectionService.uploadLocation(butlerExecuteMap,roleId);
    }


    /**
     * 获取巡检执行的定位信息
     * @param executeId 巡检执行情况主键id
     * @return map
     */
    @GetMapping("/getLocation")
    public Map<String,Object> getLocation(Integer executeId){
        return butlerInspectionService.getLocation(executeId);
    }


}
