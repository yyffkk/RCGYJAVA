package com.api.app.controller.butler;

import com.api.app.service.butler.VisitorAccessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("app/user/visitorAccess")
public class VisitorAccessController {

    @Resource
    VisitorAccessService visitorAccessService;



}
