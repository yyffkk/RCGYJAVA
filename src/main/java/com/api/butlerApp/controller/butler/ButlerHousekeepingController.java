package com.api.butlerApp.controller.butler;


import com.api.butlerApp.service.butler.ButlerHousekeepingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 管家app 家政管理
 */
@RestController
@RequestMapping("butlerApp/user/housekeeping")
public class ButlerHousekeepingController {
    @Resource
    ButlerHousekeepingService butlerHousekeepingService;

//    public Map<String,Object> list


}
