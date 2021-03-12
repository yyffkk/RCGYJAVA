package com.api.systemDataBigScreen.controller;

import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.app.AppActivityVo;
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
 * 系统数据
 */
@RestController
@RequestMapping("/systemData")
public class SystemDataController {
    @Resource
    SystemDataService systemDataService;

    /**
     * 查询投诉表扬信息集合（创建时间、类型、内容）
     * @return map
     */
    @GetMapping("/sysAdviceList")
    public Map<String,Object> sysAdviceList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
//        List<AppActivityVo> activityVoList =systemDataService.sysAdviceList();
//        PageInfo<AppActivityVo> pageInfo = new PageInfo<>(activityVoList);
        Map<String,Object> map = new HashMap<>();
//        map.put("tableList",pageInfo.getList());
//        map.put("rowCount",pageInfo.getTotal());
//        map.put("pageCount",pageInfo.getPages());
        return map;
    }







}
