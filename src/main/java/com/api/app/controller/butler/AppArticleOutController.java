package com.api.app.controller.butler;

import com.api.app.service.butler.AppArticleOutService;
import com.api.model.app.AppArticleOut;
import com.api.model.butlerService.UserArticleOut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * app物品出门
 */
@RestController
@RequestMapping("app/user/articleOut")
public class AppArticleOutController {
    @Resource
    AppArticleOutService appArticleOutService;


    /**
     * 提交物品出户信息
     * @param appArticleOut app物品出门表
     * @return map
     */
    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody AppArticleOut appArticleOut, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入业主id
        appArticleOut.setResidentId(id);
        //填入申请人（用户业主表）
        appArticleOut.setApplicantId(id);
        return appArticleOutService.submit(appArticleOut);
    }

    /**
     * 获取搬家公司手机号
     * @return map
     */
    @GetMapping("getMovingCompanyTel")
    public Map<String,Object> getMovingCompanyTel(){
        return appArticleOutService.getMovingCompanyTel();
    }




}
