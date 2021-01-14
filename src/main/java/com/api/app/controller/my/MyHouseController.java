package com.api.app.controller.my;

import com.api.app.service.my.MyHouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 我的房屋
 */
@RestController
@RequestMapping("app/user/myHouse")
public class MyHouseController {
    @Resource
    MyHouseService myHouseService;
}
