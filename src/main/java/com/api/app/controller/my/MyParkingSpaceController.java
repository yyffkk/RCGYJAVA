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
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<MyParkingSpaceVo> myParkingSpaceVoList = myParkingSpaceService.list(id);
        PageInfo<MyParkingSpaceVo> pageInfo = new PageInfo<>(myParkingSpaceVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
