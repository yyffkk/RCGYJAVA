package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 设施管理
 */
@RestController
@RequestMapping("manage/facilitiesManage")
public class SysFacilitiesManageController {
    @Resource
    SysFacilitiesManageService sysFacilitiesManageService;

}
