package com.api.app.controller.butler;

import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * app装修申请
 */
@RestController
@RequestMapping("app/user/decorationApplication")
public class DecorationApplicationController {
    @Resource
    DecorationApplicationService decorationApplicationService;

    /**
     * 查询装修列表
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppDecoration searchAppDecoration){
        return decorationApplicationService.list(searchAppDecoration);
    }

    /**
     * 装修费用详情回显
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/decorationCostDetail")
    public Map<String,Object> decorationCostDetail(Integer decorationId){
        return decorationApplicationService.decorationCostDetail(decorationId);
    }

    /**
     * 申请装修
     * @param userIdAndEstateId 用户id和房产id
     * @return map
     */
    @GetMapping("/applicationDecoration")
    public Map<String,Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId){
        return decorationApplicationService.applicationDecoration(userIdAndEstateId);
    }

    /**
     * 修改或完善装修申请
     * @param userDecoration 装修信息表
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody AppUserDecoration userDecoration){
        return decorationApplicationService.update(userDecoration);
    }

    /**
     * 查询申请装修信息
     * @param id 装修主键id
     * @return map
     */
    @GetMapping("/findApplicationDecoration")
    public Map<String,Object> findApplicationDecoration(Integer id){
        return decorationApplicationService.findApplicationDecoration(id);
    }


    /**
     * 申请付款
     * @param appDepositManagement app押金管理model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/applicationPay")
    public Map<String,Object> applicationPay(@RequestBody AppDepositManagement appDepositManagement, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入创建人
        appDepositManagement.setCreateId(id);
        return decorationApplicationService.applicationPay(appDepositManagement);
    }


    /**
     * 添加装修人员信息(app提交)
     * @param decorationSubmit 装修公司提交信息
     * @return map
     */
    @PostMapping("/insertDecorationPerson")
    public Map<String,Object> insertDecorationPerson(@RequestBody AppUserDecorationSubmit decorationSubmit){
        return decorationApplicationService.insertDecorationPerson(decorationSubmit);
    }

    /**
     * 根据装修主键id查询装修详情
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer decorationId){
        return decorationApplicationService.findDetailById(decorationId);
    }


    /**
     * 开始装修
     * @param decorationId 装修主键id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/startDecoration")
    public Map<String,Object> startDecoration(Integer decorationId,Integer id){
        return decorationApplicationService.startDecoration(decorationId,id);
    }


    /**
     * 查看全部详情信息
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/findAllDetail")
    public Map<String,Object> findAllDetail(Integer decorationId){
        return decorationApplicationService.findAllDetail(decorationId);
    }

    /**
     * 查询检查结果（跟踪记录）信息
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/findTrackRecord")
    public Map<String,Object> findTrackRecord(Integer decorationId){
        return decorationApplicationService.findTrackRecord(decorationId);
    }


    /**
     * 延长装修时间信息
     * @param appExtendDecoration app延长装修信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/extendDecorationTime")
    public Map<String,Object> extendDecorationTime(@RequestBody AppExtendDecoration appExtendDecoration, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return decorationApplicationService.extendDecorationTime(appExtendDecoration,id);
    }

    /**
     * 完成装修
     * @param decorationId 装修主键id
     * @return map
     */
    @GetMapping("/finishDecoration")
    public Map<String,Object> finishDecoration(Integer decorationId,Integer id){
        return decorationApplicationService.finishDecoration(decorationId,id);
    }







}
