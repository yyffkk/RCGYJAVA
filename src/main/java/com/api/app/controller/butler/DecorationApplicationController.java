package com.api.app.controller.butler;

import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.SearchAppDecoration;
import com.api.model.app.UserDecoration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app装修申请(缺少显示页面)
 */
@RestController
@RequestMapping("app/user/decorationApplication")
public class DecorationApplicationController {
    @Resource
    DecorationApplicationService decorationApplicationService;

    /**
     * 查询装修列表
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppDecoration searchAppDecoration){
        return decorationApplicationService.list(searchAppDecoration);
    }

    /**
     * 装修费用详情回显
     * @return map
     */
    @GetMapping("/decorationCostDetail")
    public Map<String,Object> decorationCostDetail(){
        return decorationApplicationService.decorationCostDetail();
    }


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
