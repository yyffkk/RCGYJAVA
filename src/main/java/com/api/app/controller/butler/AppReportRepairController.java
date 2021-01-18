package com.api.app.controller.butler;

import com.api.app.service.butler.AppReportRepairService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app报事报修
 */
@RestController
@RequestMapping("app/user/reportRepair")
public class AppReportRepairController {
    @Resource
    AppReportRepairService appReportRepairService;

    public Map<String,Object> list(){
        return null;
    }
}
