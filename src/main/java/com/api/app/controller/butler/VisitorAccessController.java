package com.api.app.controller.butler;

import com.api.app.service.butler.VisitorAccessService;
import com.api.model.butlerService.UserVisitors;
import com.api.vo.app.VisitorAccessFindByIdVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("app/user/visitorAccess")
public class VisitorAccessController {

    @Resource
    VisitorAccessService visitorAccessService;


    /**
     * 添加填写的访客信息
     * @param userVisitors 访问管理表信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insertVisitorInfo")
    public Map<String,Object> insertVisitorInfo(@RequestBody UserVisitors userVisitors, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入邀请人 id
        userVisitors.setInvitePeopleId(id);
        //填写是否开车（1.开车，0.不开车）
        String carNum = userVisitors.getCarNum();
        if (carNum != null && !"".equals(carNum.trim())){
            //1.开车
            userVisitors.setIsDrive(1);
        }else {
            //0.不开车
            userVisitors.setIsDrive(0);
        }

        //填写访客状态，默认为1.未到
        userVisitors.setVisitorStatus(1);
        //填写创建人
        userVisitors.setCreateId(id);
        //填写创建时间
        userVisitors.setCreateDate(new Date());
        //填写有效时间
        userVisitors.setEffectiveTime(new Date(userVisitors.getExpectedVisitDate().getTime()+24*60*60*1000));
        //添加访客信息
        return visitorAccessService.insertVisitorInfo(userVisitors);
    }

    /**
     * 根据访客信息通行证认证码 查询访客信息
     * @param accessCode 访客信息通行证认证码
     * @return map
     */
    @GetMapping("/findVisitorByAC")
    public Map<String,Object> findVisitorByAC(Long accessCode){
        return visitorAccessService.findVisitorByAC(accessCode);
    }



}
