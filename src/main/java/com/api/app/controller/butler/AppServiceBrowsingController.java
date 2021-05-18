package com.api.app.controller.butler;

import com.api.app.service.butler.AppServiceBrowsingService;
import com.api.vo.app.AppReportRepairVo;
import com.api.vo.app.AppServiceBrowsingVo;
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
 * app服务浏览
 */
@RestController
@RequestMapping("app/user/serviceBrowsing")
public class AppServiceBrowsingController {
    @Resource
    AppServiceBrowsingService appServiceBrowsingService;

    /**
     * 查询所有的app服务浏览信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppServiceBrowsingVo> appServiceBrowsingVoList =appServiceBrowsingService.list();
        PageInfo<AppServiceBrowsingVo> pageInfo = new PageInfo<>(appServiceBrowsingVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
