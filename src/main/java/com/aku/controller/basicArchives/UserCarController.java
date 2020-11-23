package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.SearchUserCar;
import com.aku.model.basicArchives.UserCar;
import com.aku.service.basicArchives.UserCarService;
import com.aku.vo.basicArchives.VoParkingSpace;
import com.aku.vo.basicArchives.VoUserCar;
import com.aku.vo.basicArchives.VoUserCarFindById;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆表
 */
@RestController
@RequestMapping("userCar")
public class UserCarController {
    @Resource
    UserCarService userCarService;

    /**
     * 查询所有车辆信息（包含条件搜索）
     * @param searchUserCar 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserCar searchUserCar){
        PageHelper.startPage(searchUserCar.getPageNum(),searchUserCar.getSize());
        List<VoUserCar> voUserCarList =userCarService.list(searchUserCar);
        PageInfo<VoUserCar> pageInfo = new PageInfo<>(voUserCarList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加车辆信息
     * @param userCar 车辆信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody UserCar userCar){
        return userCarService.insert(userCar);
    }

    /**
     * 根据主键id查询车辆信息
     * @param id 主键id
     * @return UserCar车辆信息
     */
    @GetMapping("/findById")
    public VoUserCarFindById findById(Integer id){
        return userCarService.findById(id);
    }

    /**
     * 修改车辆信息
     * @param userCar 车辆信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody UserCar userCar){
        return userCarService.update(userCar);
    }

    /**
     * 删除车辆信息
     * @param id 车辆主键id
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        return userCarService.delete(id);
    }


}
