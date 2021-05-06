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
     * @param estateId 房产id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer estateId){
        return myCarService.list(estateId);
    }


}
