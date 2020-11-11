package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.TestBuilding;
import com.aku.service.basicArchives.BuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("building")
@RestController
public class BuildingController {
    @Resource
    BuildingService buildingService;

    /**
     * 查询所有楼栋信息(包含条件查询)
     * @return 楼栋信息
     */
    @GetMapping("/list")
    public Map<String,Object> list(TestBuilding testBuilding,int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<TestBuilding> buildingList = buildingService.list(testBuilding);
        PageInfo<TestBuilding> pageInfo = new PageInfo<>(buildingList);
        Map<String,Object> map = new HashMap<>();
        map.put("buildingList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加楼栋信息
     * @param testBuilding 楼栋信息
     * @return {message 消息, status 状态}
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(TestBuilding testBuilding){
        return buildingService.insert(testBuilding);
    }


    /**
     * 根据楼栋ID查询楼栋信息
     * @param id 楼栋ID
     * @return 楼栋信息
     */
    @GetMapping("/listById")
    public TestBuilding listById(String id){
        return buildingService.listById(id);
    }

    /**
     * 修改楼栋信息
     * @return {message 消息, status 状态}
     */
    @PostMapping("/update")
    public Map<String,Object> update(TestBuilding testBuilding){
        return buildingService.update(testBuilding);
    }

    /**
     * 删除楼栋信息
     * @param id 楼栋ID
     * @return {message 消息, status 状态}
     */
    @RequestMapping("/delete")
    public Map<String,Object> delete(String id){
        return buildingService.delete(id);
    }



}
