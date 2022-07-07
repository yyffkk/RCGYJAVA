package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerBorrowService;
import com.api.model.butlerApp.*;
import com.api.model.butlerService.BorrowRemind;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerApp.ButlerArticleDetailVo;
import com.api.vo.butlerApp.ButlerArticleVo;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 借还管理
 */
@RestController
@RequestMapping("butlerApp/user/borrow")
public class ButlerBorrowController {
    @Resource
    ButlerBorrowService butlerBorrowService;

    /**
     * 查询所有的借还信息（包含条件搜索）
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerBorrowSearch butlerBorrowSearch){
        PageHelper.startPage(butlerBorrowSearch.getPageNum(),butlerBorrowSearch.getSize());
        ButlerTypeAndBorrowListVo typeAndBorrowListVo =butlerBorrowService.list(butlerBorrowSearch);
        PageInfo<ButlerBorrowVo> pageInfo = new PageInfo<>(typeAndBorrowListVo.getButlerBorrowVos());
        Map<String,Object> map = new HashMap<>();
        map.put("type",typeAndBorrowListVo.getType());
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 检查信息
     * @param articleBorrowId 物品借还管理主键id
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/checkItems")
    public Map<String,Object> checkItems(Integer articleBorrowId,String roleId){
        return butlerBorrowService.checkItems(articleBorrowId,roleId);
    }

    /**
     * 提交检查结果
     * @param butlerSubmitCheck 管家app 提交检查信息model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/submitCheck")
    public Map<String,Object> submitCheck(@RequestBody ButlerSubmitCheck butlerSubmitCheck, HttpServletRequest request){
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.submitCheck(butlerSubmitCheck,roleId);
    }

    /**
     * 查询全部物品
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/articleList")
    public Map<String,Object> articleList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<ButlerArticleVo> butlerArticleVos =butlerBorrowService.articleList();
        PageInfo<ButlerArticleVo> pageInfo = new PageInfo<>(butlerArticleVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 新增总类
     * @param butlerArticle  管家app 物品管理model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/insertArticle")
    public Map<String,Object> insertArticle(@RequestBody ButlerArticle butlerArticle,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerArticle.setCreateId(id);
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.insertArticle(butlerArticle,roleId);
    }

    /**
     * 根据物品主键id查询所有的物品明细信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param articleId 物品主键id
     * @return map
     */
    @GetMapping("/articleDetailList")
    public Map<String,Object> articleDetailList(int pageNum,int size,Integer articleId){
        PageHelper.startPage(pageNum,size);
        List<ButlerArticleDetailVo> butlerArticleDetailVos =butlerBorrowService.articleDetailList(articleId);
        PageInfo<ButlerArticleDetailVo> pageInfo = new PageInfo<>(butlerArticleDetailVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 新增物品明细
     * @param butlerArticleDetail  管家app 物品明细 model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/insertArticleDetail")
    public Map<String,Object> insertArticleDetail(@RequestBody ButlerArticleDetail butlerArticleDetail,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerArticleDetail.setCreateId(id);
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.insertArticleDetail(butlerArticleDetail,roleId);
    }


    /**
     * 根据物品明细id 查询物品信息
     * @param articleDetailId 物品明细主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer articleDetailId){
        return butlerBorrowService.findById(articleDetailId);
    }

    /**
     * 修改物品明细信息
     * @param butlerArticleDetail 管家app 物品明细 model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/updateArticleDetail")
    public Map<String,Object> updateArticleDetail(@RequestBody ButlerArticleDetail butlerArticleDetail,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerArticleDetail.setModifyId(id);
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.updateArticleDetail(butlerArticleDetail,roleId);
    }

    /**
     * 删除物品明细信息
     * @param voIds 批量删除id
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds voIds,HttpServletRequest request){
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.delete(voIds.getIds(),roleId);
    }



    /**
     * 提醒归还(管理员发送)
     * @param butlerBorrowRemind 管家app 借还提醒信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/remind")
    public Map<String,Object> remind(@RequestBody ButlerBorrowRemind butlerBorrowRemind,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        return butlerBorrowService.remind(butlerBorrowRemind,id,roleId);
    }



}
