package com.api.app.controller.butler;

import com.api.app.service.butler.AppFacilitiesAppointmentService;
import com.api.model.app.AppointmentStopUseFactor;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppFacilitiesCategoryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 设施预约
 */
@RestController
@RequestMapping("app/user/facilitiesAppointment")
public class AppFacilitiesAppointmentController {
    @Resource
    AppFacilitiesAppointmentService facilitiesAppointmentService;

    /**
     * 查询所有的设施预约 （包含搜索条件）
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppFacilitiesAppointment appFacilitiesAppointment){
        PageHelper.startPage(appFacilitiesAppointment.getPageNum(),appFacilitiesAppointment.getSize());
        List<AppFacilitiesAppointmentVo> appFacilitiesAppointmentVoList =facilitiesAppointmentService.list(appFacilitiesAppointment);
        PageInfo<AppFacilitiesAppointmentVo> pageInfo = new PageInfo<>(appFacilitiesAppointmentVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加设施预约
     * @param facilitiesAppointment 设施预约管理model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody FacilitiesAppointment facilitiesAppointment, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入预约人id
        facilitiesAppointment.setAppointmentId(id);
        return facilitiesAppointmentService.insert(facilitiesAppointment);
    }

    /**
     * 查询所有的设施分类信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findCategoryList")
    public Map<String,Object> findCategoryList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppFacilitiesCategoryVo> facilitiesCategoryVoList = facilitiesAppointmentService.findCategoryList();
        PageInfo<AppFacilitiesCategoryVo> pageInfo = new PageInfo<>(facilitiesCategoryVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据设施分类主键id查询设施信息
     * @param categoryId 设施分类主键id
     * @return map
     */
    @GetMapping("/findFacilitiesByCategoryId")
    public Map<String,Object> findFacilitiesByCategoryId(Integer categoryId){
        return facilitiesAppointmentService.findFacilitiesByCategoryId(categoryId);
    }

    /**
     * 结束使用
     * @param appointmentStopUseFactor 设施预约结束使用条件
     * @return map
     */
    @GetMapping("/useStop")
    public Map<String,Object> useStop(AppointmentStopUseFactor appointmentStopUseFactor){
        return facilitiesAppointmentService.useStop(appointmentStopUseFactor);
    }
}
