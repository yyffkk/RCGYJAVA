package com.api.app.controller.my;

import com.api.app.service.my.AppLeaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app 租赁房屋
 */
@RestController
@RequestMapping("app/user/lease")
public class AppLeaseController {
    @Resource
    AppLeaseService appLeaseService;
}
