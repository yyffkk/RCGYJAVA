package com.api.app.controller.butler;

import com.api.app.service.butler.AppAdviceService;
import com.api.model.app.SearchAppAdvice;
import com.api.model.app.UserIdAndAdviceId;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.app.AppMyArticleBorrowVo;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/user/advice")
public class AppAdviceController {
    @Resource
    AppAdviceService appAdviceService;

    /**
     * 查询所有的app建议咨询信息（包含条件搜索 type 【类型(1.咨询，2.建议，3.投诉，4.表扬)】）
     * @param searchAppAdvice 建议咨询/投诉表扬 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppAdvice searchAppAdvice){
        PageHelper.startPage(searchAppAdvice.getPageNum(),searchAppAdvice.getSize());
        List<AppAdviceVo> appAdviceVos =appAdviceService.list(searchAppAdvice);
        PageInfo<AppAdviceVo> pageInfo = new PageInfo<>(appAdviceVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加建议咨询/投诉表扬 信息
     * @param sysAdvice 咨询建议表信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysAdvice sysAdvice, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        sysAdvice.setCreateId(id);
        return appAdviceService.insert(sysAdvice);
    }


    /**
     * 根据 用户id 和 咨询建议主键id 查询 咨询建议反馈详情
     * @param userIdAndAdviceId 用户id 和 咨询建议主键id
     * @return map
     */
    @GetMapping("findAdviceDetailByAdviceId")
    public Map<String,Object> findAdviceDetailByAdviceId(UserIdAndAdviceId userIdAndAdviceId){
        return appAdviceService.findAdviceDetailByAdviceId(userIdAndAdviceId);
    }

    /**
     * 继续提问
     * @param sysAdviceDetail 建议反馈表信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/reQuestion")
    public Map<String,Object> reQuestion(@RequestBody SysAdviceDetail sysAdviceDetail,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        sysAdviceDetail.setCreateId(id);
        return appAdviceService.reQuestion(sysAdviceDetail);
    }


    /**
     * 评价
     * @param sysAdvice 咨询建议表信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/evaluate")
    public Map<String,Object> evaluate(@RequestBody SysAdvice sysAdvice,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        sysAdvice.setCreateId(id);
        return appAdviceService.evaluate(sysAdvice);
    }

    /**
     * app批量删除咨询建议信息
     * @param ids 咨询建议主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return appAdviceService.falseDelete(ids.getIds(),id);
    }
}
