package com.api.app.controller.butler;

import com.api.app.service.butler.AppArticleBorrowService;
import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppArticleOutVo;
import com.api.vo.app.AppMyArticleBorrowVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
     * 报损
     * @param userIdAndArticleBorrowId 用户id 和 物品借还主键id
     * @return map
     */
    @GetMapping("/frmLoss")
    public Map<String,Object> frmLoss(UserIdAndArticleBorrowId userIdAndArticleBorrowId){
        return appArticleBorrowService.frmLoss(userIdAndArticleBorrowId);
    }

}
