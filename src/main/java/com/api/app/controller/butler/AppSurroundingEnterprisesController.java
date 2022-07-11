package com.api.app.controller.butler;

import com.api.app.service.butler.AppSurroundingEnterprisesService;
import com.api.vo.app.AppServiceBrowsingVo;
import com.api.vo.app.AppSurroundingEnterprisesVo;
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
 * 周边企业信息管理
 */
@RestController
@RequestMapping("app/user/surroundingEnterprises")
public class AppSurroundingEnterprisesController {
    @Resource
    AppSurroundingEnterprisesService appSurroundingEnterprisesService;

    /**
     * 查询所有的周边企业信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<AppSurroundingEnterprisesVo> appSurroundingEnterprisesVoList = appSurroundingEnterprisesService.list();
        PageInfo<AppSurroundingEnterprisesVo> pageInfo = new PageInfo<>(appSurroundingEnterprisesVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
