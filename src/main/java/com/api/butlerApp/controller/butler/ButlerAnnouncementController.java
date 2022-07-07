package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerAnnouncementService;
import com.api.vo.app.AppAnnouncementVo;
import com.api.vo.butlerApp.ButlerAnnouncementVo;
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
 * 管家app 公告管理
 */
@RestController
@RequestMapping("butlerApp/user/announcement")
public class ButlerAnnouncementController {
    @Resource
    ButlerAnnouncementService butlerAnnouncementService;
    /**
     * 管家app，查询所有的社区公告
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<ButlerAnnouncementVo> butlerAnnouncementVos =butlerAnnouncementService.list();
        PageInfo<ButlerAnnouncementVo> pageInfo = new PageInfo<>(butlerAnnouncementVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 管家app，根据社区公告主键id查询社区公告信息
     * @param announcementId 社区公告主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer announcementId){
        return butlerAnnouncementService.findById(announcementId);
    }

}
