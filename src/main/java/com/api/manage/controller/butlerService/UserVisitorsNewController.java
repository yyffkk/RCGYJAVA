package com.api.manage.controller.butlerService;


import com.api.manage.service.butlerService.UserVisitorsNewService;
import com.api.model.butlerService.SearchVisitorsNew;
import com.api.vo.butlerService.VoUserVisitors;
import com.api.vo.butlerService.VoVisitorsNew;
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
 * 新版访客管理表
 */
@RestController
@RequestMapping("manage/visitorsNew")
public class UserVisitorsNewController {
    @Resource
    UserVisitorsNewService userVisitorsNewService;

    /**
     * 查询所有的新版访客信息
     * @param searchVisitorsNew 新版访客信息搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchVisitorsNew searchVisitorsNew){
        PageHelper.startPage(searchVisitorsNew.getPageNum(),searchVisitorsNew.getSize());
        List<VoVisitorsNew> voVisitorsNewList =userVisitorsNewService.list(searchVisitorsNew);
        PageInfo<VoVisitorsNew> pageInfo = new PageInfo<>(voVisitorsNewList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
