package com.api.app.controller.butler;

import com.api.app.service.butler.AppElectronicCommerceService;
import com.api.model.app.AppElectronicCommerceVo;
import com.api.model.app.SearchAppElectronicCommerce;
import com.api.model.app.SearchAppNews;
import com.api.vo.app.AppNewsVo;
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
 * app电子商务信息
 */
@RestController
@RequestMapping("app/user/electronicCommerce")
public class AppElectronicCommerceController {
    @Resource
    AppElectronicCommerceService appElectronicCommerceService;


    /**
     * 查询所有的电子商务分类(【全部】是app页面默认显示的值)
     * @return map
     */
    @GetMapping("/categoryList")
    public Map<String,Object> categoryList(){
        return appElectronicCommerceService.categoryList();
    }

    /**
     * 根据电子商务分类主键id查询电子商务信息
     * @param searchAppElectronicCommerce app 电子商务 搜素条件
     * @return map
     */
    @GetMapping("/electronicCommerceList")
    public Map<String,Object> electronicCommerceList(SearchAppElectronicCommerce searchAppElectronicCommerce){
        PageHelper.startPage(searchAppElectronicCommerce.getPageNum(),searchAppElectronicCommerce.getSize());
        List<AppElectronicCommerceVo> appElectronicCommerceVoList = appElectronicCommerceService.electronicCommerceList(searchAppElectronicCommerce);
        PageInfo<AppElectronicCommerceVo> pageInfo = new PageInfo<>(appElectronicCommerceVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据电子商务主键id 查询电子商务信息详情
     * @param electronicCommerceId 电子商务主键id
     * @return map
     */
    @GetMapping("/findElectronicCommerceById")
    public Map<String,Object> findElectronicCommerceById(Integer electronicCommerceId){
        return appElectronicCommerceService.findElectronicCommerceById(electronicCommerceId);
    }
}
