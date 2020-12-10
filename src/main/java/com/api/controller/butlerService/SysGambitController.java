package com.api.controller.butlerService;

import com.api.service.butlerService.SysGambitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 话题管理表
 */
@RestController
@RequestMapping("gambit")
public class SysGambitController {
    @Resource
    SysGambitService sysGambitService;
}
