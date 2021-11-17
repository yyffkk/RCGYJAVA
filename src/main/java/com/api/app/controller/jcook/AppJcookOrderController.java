package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.model.jcook.dto.JcookOrderSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
        return appJcookOrderService.myOrder(jcookOrderSearch);
    }




}
