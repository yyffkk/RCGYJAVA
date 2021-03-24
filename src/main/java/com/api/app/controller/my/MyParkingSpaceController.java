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
     * 查询所有的车位审核信息
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

    /**
     * 车位认证
     * @param myParkingSpace 我的车位审核model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/authentication")
    public Map<String,Object> authentication(@RequestBody MyParkingSpace myParkingSpace, HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id")); //从request获取用户id
        myParkingSpace.setResidentId(id); //填入用户id
        return myParkingSpaceService.authentication(myParkingSpace);
    }

    /**
     * 假删除车位审核信息
     * @param voIds 车位审核主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds voIds){
        return myParkingSpaceService.falseDelete(voIds.getIds());
    }

}
