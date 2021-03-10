package com.api.app.controller.butler;

import com.api.app.service.butler.AppActivityService;
import com.api.vo.app.AppActivityRegistrationVo;
import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppQuestionnaireVo;
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
 * app社区活动
 */
@RestController
@RequestMapping("app/user/activity")
public class AppActivityController {
    @Resource
    AppActivityService appActivityService;

    /**
     * 查询所有的活动信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppActivityVo> activityVoList =appActivityService.list(id);
        PageInfo<AppActivityVo> pageInfo = new PageInfo<>(activityVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据社区活动主键id查询社区活动详情
     * @param activityId 社区活动主键id
     * @return 社区活动详情
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer activityId){
        return appActivityService.findById(activityId);
    }


    /**
     * 报名
     * @param id 用户id
     * @param activityId 活动id
     * @return map
     */
    @GetMapping("/signUp")
    public Map<String,Object> signUp(Integer id,Integer activityId){
        return appActivityService.signUp(id,activityId);
    }

    /**
     * 查看参与人数
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param activityId 活动id
     * @return map
     */
    @GetMapping("/participantsList")
    public Map<String,Object> participantsList(int pageNum,int size,Integer activityId){
        PageHelper.startPage(pageNum,size);
        List<AppActivityRegistrationVo> registrationVoList =appActivityService.participantsList(activityId);
        PageInfo<AppActivityRegistrationVo> pageInfo = new PageInfo<>(registrationVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
