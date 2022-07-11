package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.OrderService;
import com.api.model.shoppingCenter.GoodsSearch;
import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理
 */
@RestController
@RequestMapping("manage/shop/order")
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 查询所有的订单信息
     * @param orderSearch 订单管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501"},logical = Logical.AND)
    public Map<String,Object> list(OrderSearch orderSearch){
        PageHelper.startPage(orderSearch.getPageNum(),orderSearch.getSize());
        List<OrderVo> orderVoList = orderService.list(orderSearch);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 发货
     * @param order 商品预约model（订单）
     * @return map
     */
    @PostMapping("/deliverGoods")
    public Map<String,Object> deliverGoods(@RequestBody Order order){
        return orderService.deliverGoods(order);
    }


    /**
     * 商品到货
     * @param order 商品预约model（订单）
     * @return map
     */
    @PostMapping("/arrivalGoods")
    public Map<String,Object> arrivalGoods(@RequestBody Order order){
        return orderService.arrivalGoods(order);
    }




}
