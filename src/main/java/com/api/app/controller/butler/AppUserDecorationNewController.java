package com.api.app.controller.butler;


import com.api.app.service.butler.AppUserDecorationNewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app 新版装修
 */
@RestController
@RequestMapping("app/user/userDecorationNew")
public class AppUserDecorationNewController {
    @Resource
    AppUserDecorationNewService appUserDecorationNewService;
}
