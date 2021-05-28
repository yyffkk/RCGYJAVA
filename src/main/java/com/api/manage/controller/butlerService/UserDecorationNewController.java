package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.UserDecorationNewService;
import com.api.model.app.AppUserDecorationNew;
import com.api.model.butlerService.UserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新版装修管理
 */
@RestController
@RequestMapping("manage/userDecorationNew")
public class UserDecorationNewController {
    @Resource
    UserDecorationNewService userDecorationNewService;

    /**
     * 查询所有的新版装修管理信息
     * @param userDecorationNewSearch 新版装修管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(UserDecorationNewSearch userDecorationNewSearch){
        PageHelper.startPage(userDecorationNewSearch.getPageNum(),userDecorationNewSearch.getSize());
        List<ButlerUserDecorationNewVo> butlerUserDecorationNewVoList =userDecorationNewService.list(userDecorationNewSearch);
        PageInfo<ButlerUserDecorationNewVo> pageInfo = new PageInfo<>(butlerUserDecorationNewVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 审核装修信息（2.通过/3.驳回）
     * @param appUserDecorationNew app新版装修 model信息
     * @return map
     */
    @PostMapping("/examine")
    public Map<String,Object> examine(@RequestBody AppUserDecorationNew appUserDecorationNew){
        return userDecorationNewService.examine(appUserDecorationNew);
    }
}
