package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.TestHouse;
import com.aku.model.vo.VoUnit;
import com.aku.service.basicArchives.HouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("house")
@RestController
public class HouseController {
    @Resource
    HouseService houseService;

    @GetMapping("/list")
    public Map<String,Object> list(TestHouse testHouse,int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<TestHouse> testHouseList = houseService.list(testHouse);
        PageInfo<TestHouse> pageInfo = new PageInfo<>(testHouseList);
        Map<String,Object> map = new HashMap<>();
        map.put("testHouseList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
