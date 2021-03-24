package com.api.app.controller.my;


import com.api.app.service.my.MyCarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 我的车
 */
@RestController
@RequestMapping("app/user/myCar")
public class MyCarController {
    @Resource
    MyCarService myCarService;


}
