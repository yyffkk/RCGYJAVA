package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerUserDecorationNewService;
import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
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
 * 管家app 装修管理
 */
@RestController
@RequestMapping("butlerApp/user/userDecorationNew")
public class ButlerUserDecorationNewController {
    @Resource
    ButlerUserDecorationNewService butlerUserDecorationNewService;


    /**
     * 查询所有的装修管理信息
     * @param butlerUserDecorationNewSearch 管家app 新版装修搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch){
        PageHelper.startPage(butlerUserDecorationNewSearch.getPageNum(),butlerUserDecorationNewSearch.getSize());
        List<ButlerUserDecorationNewVo> butlerUserDecorationNewVoList =butlerUserDecorationNewService.list(butlerUserDecorationNewSearch);
        PageInfo<ButlerUserDecorationNewVo> pageInfo = new PageInfo<>(butlerUserDecorationNewVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
