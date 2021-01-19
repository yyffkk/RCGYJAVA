package com.api.app.controller.butler;

import com.api.app.service.butler.AppReportRepairService;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * app查询当前用户的报事报修信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        return null;
    }
}
