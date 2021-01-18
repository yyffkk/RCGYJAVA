package com.api.app.controller.butler;

import com.api.app.service.butler.AppConvenientTelephoneService;
import com.api.model.butlerService.SearchConveniencePhone;
import com.api.vo.app.AppConvenientTelephoneVo;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.api.vo.butlerService.VoConveniencePhone;
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
 * 便民电话
 */
@RestController
@RequestMapping("app/convenientTelephone")
public class AppConvenientTelephoneController {
    @Resource
    AppConvenientTelephoneService appConvenientTelephoneService;


    /**
     * app便民电话显示(包含条件搜索)
     * @param searchConveniencePhone 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchConveniencePhone searchConveniencePhone){
        PageHelper.startPage(searchConveniencePhone.getPageNum(),searchConveniencePhone.getSize());
        List<AppConvenientTelephoneVo> voCpmBuildingUnitEstateList =appConvenientTelephoneService.list(searchConveniencePhone);
        PageInfo<AppConvenientTelephoneVo> pageInfo = new PageInfo<>(voCpmBuildingUnitEstateList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
