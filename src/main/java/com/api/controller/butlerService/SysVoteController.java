package com.api.controller.butlerService;

import com.api.service.butlerService.SysVoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 投票管理
 */
@RestController
@RequestMapping("vote")
public class SysVoteController {
    @Resource
    SysVoteService sysVoteService;

}
