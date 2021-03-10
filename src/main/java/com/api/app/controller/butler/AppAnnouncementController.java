package com.api.app.controller.butler;

import com.api.app.service.butler.AppAnnouncementService;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.app.AppAnnouncementVo;
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
 * app社区公告
 */
@RestController
@RequestMapping("app/announcement")
public class AppAnnouncementController {
    @Resource
    AppAnnouncementService appAnnouncementService;

    /**
     * 查询所有的社区公告
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param type 用户类型
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,int type){
        PageHelper.startPage(pageNum,size);
        List<AppAnnouncementVo> announcementVos =appAnnouncementService.list(type);
        PageInfo<AppAnnouncementVo> pageInfo = new PageInfo<>(announcementVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据社区公告主键id查询社区公告信息
     * @param announcementId 社区公告主键id
     * @param type 用户类型
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer announcementId,Integer type){
        return appAnnouncementService.findById(announcementId,type);
    }
}
