package com.api.app.controller.my;

import com.api.app.service.my.MyHouseService;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 房屋认证(有问题)
     * @param residentIdAndEstateId 房产id 和 业主id
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/authentication")
    public Map<String,Object> authentication(@RequestBody ResidentIdAndEstateId residentIdAndEstateId, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入用户id
        residentIdAndEstateId.setResidentId(id);
        return myHouseService.authentication(residentIdAndEstateId);
    }

}
