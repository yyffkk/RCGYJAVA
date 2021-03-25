package com.api.app.controller.my;


import com.api.app.service.my.MyCarService;
import com.api.vo.my.MyCarVo;
import com.api.vo.my.MyParkingSpaceVo;
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
 * 我的车辆
 */
@RestController
@RequestMapping("app/user/myCar")
public class MyCarController {
    @Resource
    MyCarService myCarService;

    /**
     * 查询所有的车辆
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<MyCarVo> myCarVoList = myCarService.list(id);
        PageInfo<MyCarVo> pageInfo = new PageInfo<>(myCarVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
