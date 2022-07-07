package com.api.app.controller.my;

import com.api.app.service.my.MyParkingSpaceService;
import com.api.model.my.MyParkingSpace;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.my.MyParkingSpaceVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的车位
 */
@RestController
@RequestMapping("app/user/myParkingSpace")
public class MyParkingSpaceController {
    @Resource
    MyParkingSpaceService myParkingSpaceService;

    /**
     * 查询所有的车位
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer id){
        return myParkingSpaceService.list(id);
    }

}
