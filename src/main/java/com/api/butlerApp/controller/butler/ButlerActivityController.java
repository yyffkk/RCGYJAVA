package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerActivityService;
import com.api.vo.butlerApp.ButlerActivityVo;
import com.api.vo.butlerApp.ButlerVisitorVo;
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
 * 管家app 活动管理
 */
@RestController
@RequestMapping("butlerApp/user/activity")
public class ButlerActivityController {
    @Resource
    ButlerActivityService butlerActivityService;

    /**
     * 管家app 查询所有的活动管理信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<ButlerActivityVo> butlerActivityVos =butlerActivityService.list();
        PageInfo<ButlerActivityVo> pageInfo = new PageInfo<>(butlerActivityVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 管家app 根据活动管理主键id查询活动详情
     * @param activityId 活动管理主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer activityId){
        return butlerActivityService.findById(activityId);
    }
}
