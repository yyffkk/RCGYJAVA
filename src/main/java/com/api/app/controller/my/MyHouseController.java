package com.api.app.controller.my;

import com.api.app.service.my.MyHouseService;
import com.api.model.my.MyHouse;
import com.api.vo.basicArchives.VoIds;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
     * 查询用户所有拥有的房屋信息
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/houseList")
    public Map<String,Object> houseList(Integer id){
        return myHouseService.houseList(id);
    }


    /**
     * 查询所有的房屋审核信息
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/examineList")
    public Map<String,Object> examineList(Integer id){
        return myHouseService.examineList(id);
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


    /**
     * 修改选中的房产id
     * @param examineId 房产id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/changeSelectExamineId")
    public Map<String,Object> changeSelectExamineId(Integer examineId,Integer id){
        return myHouseService.changeSelectExamineId(examineId,id);
    }

}
