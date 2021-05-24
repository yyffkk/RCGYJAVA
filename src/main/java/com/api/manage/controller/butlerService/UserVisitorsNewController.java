package com.api.manage.controller.butlerService;


import com.api.manage.service.butlerService.UserVisitorsNewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 新版访客管理表
 */
@RestController
@RequestMapping("manage/visitorsNew")
public class UserVisitorsNewController {
    @Resource
    UserVisitorsNewService userVisitorsNewService;

//    public Map<String,Object>
}
