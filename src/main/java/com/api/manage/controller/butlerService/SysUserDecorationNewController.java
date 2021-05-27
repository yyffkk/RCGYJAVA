package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysUserDecorationNewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 新版装修管理
 */
@RestController
@RequestMapping("manage/userDecorationNew")
public class SysUserDecorationNewController {
    @Resource
    SysUserDecorationNewService sysUserDecorationNewService;
}
