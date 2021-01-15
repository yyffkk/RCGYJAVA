package com.api.app.controller.butler;

import com.api.app.service.butler.AppConvenientTelephoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 便民电话
 */
@RestController
@RequestMapping("app/convenientTelephone")
public class AppConvenientTelephoneController {
    @Resource
    AppConvenientTelephoneService appConvenientTelephoneService;
}
