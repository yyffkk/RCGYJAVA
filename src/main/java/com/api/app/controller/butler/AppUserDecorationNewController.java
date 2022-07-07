package com.api.app.controller.butler;


import com.api.app.service.butler.AppUserDecorationNewService;
import com.api.model.app.AppUserDecorationNew;
import com.api.model.app.SearchAppUserDecorationNew;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 新版装修
 */
@RestController
@RequestMapping("app/user/userDecorationNew")
public class AppUserDecorationNewController {
    @Resource
    AppUserDecorationNewService appUserDecorationNewService;

    /**
     * 查询所有的新版装修信息
     * @param searchAppUserDecorationNew 新版装修 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppUserDecorationNew searchAppUserDecorationNew){
        PageHelper.startPage(searchAppUserDecorationNew.getPageNum(),searchAppUserDecorationNew.getSize());
        List<ButlerUserDecorationNewVo> butlerUserDecorationNewVoList =appUserDecorationNewService.list(searchAppUserDecorationNew);
        PageInfo<ButlerUserDecorationNewVo> pageInfo = new PageInfo<>(butlerUserDecorationNewVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加新版装修信息（申请装修）
     * @param appUserDecorationNew app新版装修 model信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody AppUserDecorationNew appUserDecorationNew, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return appUserDecorationNewService.insert(appUserDecorationNew,id);
    }


    /**
     * 申请完工检查
     * @param id 用户主键id
     * @param userDecorationNewId 新版装修主键id
     * @return map
     */
    @GetMapping("/applicationCompletion")
    public Map<String,Object> applicationCompletion(Integer id,Integer userDecorationNewId){
        return appUserDecorationNewService.applicationCompletion(id,userDecorationNewId);
    }

}
