package com.api.app.controller.butler;

import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.SearchAppDecoration;
import com.api.model.app.UserDecoration;
import com.api.model.app.UserIdAndEstateId;
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
     * 申请装修
     * @param userIdAndEstateId 用户id和房产id
     * @return map
     */
    @GetMapping("/applicationDecoration")
    public Map<String,Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId){
        return decorationApplicationService.applicationDecoration(userIdAndEstateId);
    }

    /**
     * 修改或完善装修申请
     * @param userDecoration 装修信息表
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody UserDecoration userDecoration){
        return decorationApplicationService.update(userDecoration);
    }

    /**
     * 查询申请装修信息
     * @param id 装修主键id
     * @return map
     */
    @GetMapping("/findApplicationDecoration")
    public Map<String,Object> findApplicationDecoration(Integer id){
        return decorationApplicationService.findApplicationDecoration(id);
    }

}
