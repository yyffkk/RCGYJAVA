package com.api.app.controller.butler;

import com.api.app.service.butler.AppArticleBorrowService;
import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppArticleOutVo;
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

/**
 * app 物品借还
 */
@RestController
@RequestMapping("app/user/articleBorrow")
public class AppArticleBorrowController {
    @Resource
    AppArticleBorrowService appArticleBorrowService;


    /**
     * 查询所有可借物品信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppArticleBorrowVo> appArticleBorrowVos =appArticleBorrowService.list();
        PageInfo<AppArticleBorrowVo> pageInfo = new PageInfo<>(appArticleBorrowVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询该用户的所有物品借还信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/myList")
    public Map<String,Object> myList(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppMyArticleBorrowVo> appMyArticleBorrowVos =appArticleBorrowService.myList(id);
        PageInfo<AppMyArticleBorrowVo> pageInfo = new PageInfo<>(appMyArticleBorrowVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据物品总类主键id查询未借出的物品明细（借取页面）
     * @param articleId 物品总类主键id
     * @return 未借出的物品明细
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer articleId){
        return appArticleBorrowService.findDetailById(articleId);
    }

    /**
     * 借取物品
     * @param ids 物品明细主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/borrow")
    public Map<String,Object> borrow(@RequestBody VoIds ids, HttpServletRequest request){
        //从request获取用户id
        Integer userId = Integer.valueOf(request.getParameter("id"));
        return appArticleBorrowService.borrow(ids.getIds(),userId);
    }

    /**
     * 根据用户主键id查询需要归还物品信息（归还界面）
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/findBorrowByUserId")
    public Map<String,Object> findBorrowByUserId(Integer id){
        return appArticleBorrowService.findBorrowByUserId(id);
    }

    /**
     * 归还物品
     * @param ids 借还主键id
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/articleReturn")
    public Map<String,Object> articleReturn(@RequestBody VoIds ids, HttpServletRequest request){
        //从request获取用户id
        Integer userId = Integer.valueOf(request.getParameter("id"));
        return appArticleBorrowService.articleReturn(ids.getIds(),userId);
    }

    /**
     * 报损
     * @param userIdAndArticleBorrowId 用户id 和 物品借还主键id
     * @return map
     */
    @GetMapping("/frmLoss")
    public Map<String,Object> frmLoss(UserIdAndArticleBorrowId userIdAndArticleBorrowId){
        return appArticleBorrowService.frmLoss(userIdAndArticleBorrowId);
    }



}
