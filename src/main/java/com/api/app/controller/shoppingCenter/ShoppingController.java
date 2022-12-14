package com.api.app.controller.shoppingCenter;

import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.UserIdAndGoodsAppointmentId;
import com.api.model.shoppingCenter.Evaluation;
import com.api.model.shoppingCenter.Order;
import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.app.AppMyOrderVo;
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
     * 查询订阅量最高的商品（按订阅量从高到低排序）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findTopGoods")
    public Map<String,Object> findTopGoods(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppGoodsVo> appGoodsVos = shoppingService.findTopGoods();
        PageInfo<AppGoodsVo> pageInfo = new PageInfo<>(appGoodsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
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
     * 商品预约（已废弃，转到支付宝支付流程）
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

    /**
     * 商品搜索
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param searchName 搜索内容
     * @return map
     */
    @GetMapping("/goodsSearch")
    public Map<String,Object> goodsSearch(int pageNum,int size,String searchName){
        PageHelper.startPage(pageNum,size);
        List<AppGoodsVo> appGoodsVos = shoppingService.goodsSearch(searchName);
        PageInfo<AppGoodsVo> pageInfo = new PageInfo<>(appGoodsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 我的订单
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @param orderStart 订单状态：1.待发货，2.已发货，3.已到货，4.已收货，6.已评价[当状态>=已收货并评价]，8.退换货申请（8-9）
     * @return map
     */
    @GetMapping("/myOrder")
    public Map<String,Object> myOrder(int pageNum,int size,Integer id,Integer orderStart){
        PageHelper.startPage(pageNum,size);
        List<AppMyOrderVo> appMyOrderVoList = shoppingService.myOrder(id,orderStart);
        PageInfo<AppMyOrderVo> pageInfo = new PageInfo<>(appMyOrderVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据订单主键id查询订单详情
     * @param UserIdAndGoodsAppointmentId 用户主键id 和 商品预约主键id
     * @return map
     */
    @GetMapping("/findOrderDetailByOrderId")
    public Map<String,Object> findOrderDetailByOrderId(UserIdAndGoodsAppointmentId UserIdAndGoodsAppointmentId){
        return shoppingService.findOrderDetailByOrderId(UserIdAndGoodsAppointmentId);
    }


    /**
     * 取消预约
     * @param goodsAppointmentId 商品预约主键id
     * @return map
     */
    @GetMapping("/cancel")
    public Map<String,Object> cancel(Integer goodsAppointmentId){
        return shoppingService.cancel(goodsAppointmentId);
    }

    /**
     * 申请退换
     * @param id 用户主键id
     * @param goodsAppointmentId 商品预约主键id
     * @param backType 客户期望：1.退货，2.换货
     * @param backReason 退换货原因
     * @return map
     */
    @GetMapping("/applicationRefund")
    public Map<String,Object> applicationRefund(Integer id,Integer goodsAppointmentId,Integer backType,String backReason){
        return shoppingService.applicationRefund(id,goodsAppointmentId,backType,backReason);
    }

    /**
     * 确认收货
     * @param id 用户主键id
     * @param goodsAppointmentId 商品预约主键id
     * @return map
     */
    @GetMapping("/confirmReceipt")
    public Map<String,Object> confirmReceipt(Integer id,Integer goodsAppointmentId){
        return shoppingService.confirmReceipt(id,goodsAppointmentId);
    }

    /**
     * 评价
     * @param evaluation 评价model
     * @return map
     */
    @GetMapping("/evaluation")
    public Map<String,Object> evaluation(Evaluation evaluation){
        return shoppingService.evaluation(evaluation);
    }

}
