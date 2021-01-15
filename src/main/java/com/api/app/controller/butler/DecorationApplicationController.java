package com.api.app.controller.butler;

import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.UserDecoration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app装修申请(少显示页面)
 */
@RestController
@RequestMapping("app/decorationApplication")
public class DecorationApplicationController {
    @Resource
    DecorationApplicationService decorationApplicationService;

    /**
     * 提交装修申请
     * @param userDecoration 装修信息表
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody UserDecoration userDecoration){
        return null;
    }

}
