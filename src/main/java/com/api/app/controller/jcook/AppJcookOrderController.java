package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.model.jcook.appDto.AppDeleteDTO;
import com.api.model.jcook.appDto.AppJcookCancelOrderDTO;
import com.api.model.jcook.appDto.JcookOrderSearch;
import com.api.model.jcook.manageDto.ManageJcookCancelOrderDTO;
import com.api.vo.jcook.appOrder.MyOrderVo;
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
 * 京库克商城（第三方对接）App端订单
 */
@RestController
@RequestMapping("app/user/jcookOrder")
public class AppJcookOrderController {
    @Resource
    AppJcookOrderService appJcookOrderService;


    /**
     * 我的订单
     * @param jcookOrderSearch 订单搜索条件
     * @return map
     */
    @GetMapping("/myOrder")
    public Map<String,Object> myOrder(JcookOrderSearch jcookOrderSearch){
        PageHelper.startPage(jcookOrderSearch.getPageNum(),jcookOrderSearch.getSize());
        List<MyOrderVo> myOrderVoList = appJcookOrderService.myOrder(jcookOrderSearch);
        PageInfo<MyOrderVo> pageInfo = new PageInfo<>(myOrderVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * app取消订单
     * @param appJcookCancelOrderDTO app取消订单 DTO
     * @return map
     */
    @GetMapping("/cancel")
    public Map<String,Object> cancel(AppJcookCancelOrderDTO appJcookCancelOrderDTO){
        return appJcookOrderService.cancel(appJcookCancelOrderDTO);
    }

    /**
     * app删除订单
     * @param appDelete app删除DTO
     * @return map
     */
    @GetMapping("/appDelete")
    public Map<String,Object> appDelete(AppDeleteDTO appDelete){
        return appJcookOrderService.appDelete(appDelete);
    }



}
