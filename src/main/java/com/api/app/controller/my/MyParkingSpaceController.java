package com.api.app.controller.my;

import com.api.app.service.my.MyParkingSpaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 我的车位
 */
@RestController
@RequestMapping("app/user/myParkingSpace")
public class MyParkingSpaceController {
    @Resource
    MyParkingSpaceService myParkingSpaceService;

}
