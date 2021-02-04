package com.api.app.controller.butler;

import com.api.app.service.butler.AppArticleOutService;
import com.api.model.app.AppArticleOut;
import com.api.model.app.UserIdAndArticleOutId;
import com.api.model.butlerService.UserArticleOut;
import com.api.vo.app.AppArticleOutVo;
import com.api.vo.app.AppConvenientTelephoneVo;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
     * 查询当前用户所有的物品出户信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppArticleOutVo> appArticleOutVos =appArticleOutService.list(id);
        PageInfo<AppArticleOutVo> pageInfo = new PageInfo<>(appArticleOutVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 提交物品出户信息
     * @param appArticleOut app物品出门表
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody AppArticleOut appArticleOut, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入业主id ???
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


    /**
     * app批量删除物品出户信息
     * @param ids 物品出户id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return appArticleOutService.falseDelete(ids.getIds(),id);
    }


    /**
     * 根据 用户主键id 和 物品出户主键id 查询二维码信息
     * @param id 用户主键id
     * @param articleOutId 物品出户主键id
     * @return map
     */
    @GetMapping("/getQRCode")
    public Map<String,Object> getQRCode(Integer id,Integer articleOutId){
        UserIdAndArticleOutId userIdAndArticleOutId = new UserIdAndArticleOutId();
        userIdAndArticleOutId.setUserId(id);
        userIdAndArticleOutId.setArticleOutId(articleOutId);
        return appArticleOutService.getQRCode(userIdAndArticleOutId);
    }




}
