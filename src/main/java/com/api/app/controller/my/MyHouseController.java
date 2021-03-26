package com.api.app.controller.my;

import com.api.app.service.my.MyHouseService;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.my.MyHouse;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.my.MyHouseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的房屋
 */
@RestController
@RequestMapping("app/user/myHouse")
public class MyHouseController {
    @Resource
    MyHouseService myHouseService;


    /**
     * 查询所有的房屋审核信息
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer id){
        return myHouseService.list(id);
    }

    /**
     * 房屋认证(新增房屋)
     * @param myHouse 房产认证model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/authentication")
    public Map<String,Object> authentication(@RequestBody MyHouse myHouse, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户type
        Integer type = Integer.valueOf(request.getParameter("type"));
        //填入用户id
        myHouse.setResidentId(id);
        return myHouseService.authentication(myHouse,type);
    }


    /**
     * 再次认证回显数据
     * @param estateExamineId 房产审核表主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer estateExamineId){
        return myHouseService.findById(estateExamineId);
    }

    /**
     * 假删除审核信息
     * @param voIds 审核主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds voIds, HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        return myHouseService.falseDelete(voIds.getIds(),residentId);
    }

}
