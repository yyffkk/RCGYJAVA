package com.api.butlerApp.controller.visitor;

import com.api.butlerApp.service.visitor.ButlerVisitorService;
import com.api.model.butlerApp.ButlerVisitorSearch;
import com.api.vo.app.AppActivityVo;
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
 * 管家app 访客管理
 */
@RestController
@RequestMapping("butlerApp/user/visitor")
public class ButlerVisitorController {
    @Resource
    ButlerVisitorService butlerVisitorService;

    /**
     * 管家app显示所有的访客信息 （包含条件搜索）
     * @param butlerVisitorSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerVisitorSearch butlerVisitorSearch){
        PageHelper.startPage(butlerVisitorSearch.getPageNum(),butlerVisitorSearch.getSize());
        List<ButlerVisitorVo> butlerVisitorVos =butlerVisitorService.list(butlerVisitorSearch);
        PageInfo<ButlerVisitorVo> pageInfo = new PageInfo<>(butlerVisitorVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
