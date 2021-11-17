package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.model.jcook.dto.CreateOrderDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端订单
 */
@RestController
@RequestMapping("app/user/jcookOrder")
public class AppJcookOrderController {
    @Resource
    AppJcookOrderService appJcookOrderService;




}
