package com.api.butlerApp.controller.personalData;

import com.api.butlerApp.service.personalData.ButlerPersonalDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("butlerApp/user/personal")
public class ButlerPersonalDataController {
    @Resource
    ButlerPersonalDataService butlerPersonalDataService;

}
