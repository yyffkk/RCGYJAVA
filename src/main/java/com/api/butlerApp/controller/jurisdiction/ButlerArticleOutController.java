package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerArticleOutService;
import com.api.model.butlerApp.ButlerArticleOutNoRelease;
import com.api.model.butlerApp.ButlerArticleOutRelease;
import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 物品出门
 */
@RestController
@RequestMapping("butlerApp/user/articleOut")
public class ButlerArticleOutController {
    @Resource
    ButlerArticleOutService butlerArticleOutService;


    /**
     * 查询所有的物品出户信息(包含搜索条件)
     * @param articleOutSearch 管家app 物品出门 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerArticleOutSearch articleOutSearch){
        PageHelper.startPage(articleOutSearch.getPageNum(),articleOutSearch.getSize());
        List<ButlerArticleOutVo> butlerArticleOutVos =butlerArticleOutService.list(articleOutSearch);
        PageInfo<ButlerArticleOutVo> pageInfo = new PageInfo<>(butlerArticleOutVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据物品出户主键id查询出户详情
     * @param articleOutId 物品出户主键id
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer articleOutId,String roleId){
        return butlerArticleOutService.findById(articleOutId,roleId);
    }

    /**
     * 放行
     * @param articleOutRelease 管家app物品出户 放行model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/release")
    public Map<String,Object> release(@RequestBody ButlerArticleOutRelease articleOutRelease, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerArticleOutService.release(articleOutRelease,id,roleId);
    }

    /**
     * 不放行
     * @param articleOutNoRelease 管家app 物品出户 不放行model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/noRelease")
    public Map<String,Object> noRelease(@RequestBody ButlerArticleOutNoRelease articleOutNoRelease,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerArticleOutService.noRelease(articleOutNoRelease,id,roleId);
    }

    /**
     * 根据房产id查询业主名称和手机号（联系业主）
     * @param estateId 房产id
     * @return map
     */
    @GetMapping("/contactOwner")
    public Map<String,Object> contactOwner(Integer estateId){
        return butlerArticleOutService.contactOwner(estateId);
    }
}
