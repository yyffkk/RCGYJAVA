package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerActivityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管家app 活动管理
 */
@RestController
@RequestMapping("butlerApp/user/activity")
public class ButlerActivityController {
    @Resource
    ButlerActivityService butlerActivityService;
}
