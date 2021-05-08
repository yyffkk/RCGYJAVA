package com.api.app.controller.shoppingCenter;

import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.model.app.AppGoodsAppointment;
import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppGoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app商场
 */
@RestController
@RequestMapping("app/user/shop")
public class ShoppingController {

    @Resource
    ShoppingService shoppingService;

    /**
     * 查询所有的分类
     * @param parentId 父类id，如果为一级则为0
     * @return map
     */
    @GetMapping("/findAllCategory")
    public Map<String,Object> findAllCategory(Integer parentId){
        return shoppingService.list(parentId);
    }

    /**
     * 查询订阅量最高的4件商品
     * @return map
     */
    @GetMapping("/findTopGoods")
    public Map<String,Object> findTopGoods(){
        return shoppingService.findTopGoods();
    }


    /**
     * 根据分类主键id查询商品信息列表
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param categoryId 分类主键id
     * @return map
     */
    @GetMapping("/findGoodsByCategoryId")
    public Map<String,Object> findGoodsByCategoryId(int pageNum,int size,Integer categoryId){
        PageHelper.startPage(pageNum,size);
        List<AppGoodsVo> appGoodsVos = shoppingService.findGoodsByCategoryId(categoryId);
        PageInfo<AppGoodsVo> pageInfo = new PageInfo<>(appGoodsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /***
     * 根据商品主键id查询商品详情
     * @param goodsId 商品主键id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/findDetailByGoodsId")
    public Map<String,Object> findDetailByGoodsId(Integer goodsId,Integer id){
        return shoppingService.findDetailByGoodsId(goodsId,id);
    }

    /**
     * 根据供应商主键id 查询预约量最高的4个商品信息(其他【4个】)
     * @param supplierId 供应商主键id
     * @return map
     */
    @GetMapping("/findTopGoodsBySupplierId")
    public Map<String,Object> findTopGoodsBySupplierId(Integer supplierId){
        return shoppingService.findTopGoodsBySupplierId(supplierId);
    }


    /**
     * 商品预约
     * @param appGoodsAppointment app 商品预约信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/goodsAppointment")
    public Map<String,Object> goodsAppointment(@RequestBody AppGoodsAppointment appGoodsAppointment, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户type
        Integer type = Integer.valueOf(request.getParameter("type"));
        return shoppingService.goodsAppointment(appGoodsAppointment,type,id);
    }


}
