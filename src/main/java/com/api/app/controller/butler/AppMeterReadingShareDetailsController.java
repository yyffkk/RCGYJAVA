package com.api.app.controller.butler;


import com.api.app.service.butler.AppMeterReadingShareDetailsService;
import com.api.model.alipay.SysMeterReadingShareDetailsOrder;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppMeterShareOrderVo;
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

    /**
     * 根据手机号查询所有的抄表公摊缴费订单记录
     * @param tel 手机号
     * @return map
     */
    @GetMapping("/findAllMeterShareOrderByTel")
    public Map<String,Object> findAllMeterShareOrderByTel(int pageNum,int size,String tel){
        PageHelper.startPage(pageNum,size);
        List<AppMeterShareOrderVo> appMeterShareOrderVos = appMeterReadingShareDetailsService.findAllMeterShareOrderByTel(tel);
        PageInfo<AppMeterShareOrderVo> pageInfo = new PageInfo<>(appMeterShareOrderVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
