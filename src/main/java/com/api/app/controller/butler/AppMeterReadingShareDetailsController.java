package com.api.app.controller.butler;


import com.api.app.service.butler.AppMeterReadingShareDetailsService;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppMeterShareVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 抄表分摊详情管理
 */
@RestController
@RequestMapping("app/user/meterReadingShareDetails")
public class AppMeterReadingShareDetailsController {
    @Resource
    AppMeterReadingShareDetailsService appMeterReadingShareDetailsService;


    /**
     * 查询所有未缴纳的公摊缴费
     * @param estateId 房产主键id
     * @return map
     */
    @GetMapping("/findAllUnPayList")
    public Map<String,Object> findAllUnPayList(Integer estateId){
        return appMeterReadingShareDetailsService.findAllUnPayList(estateId);
    }

}
