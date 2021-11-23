package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookOrderService;
import com.api.model.jcook.manageDto.ManageJcookCancelOrderDTO;
import com.api.model.jcook.manageDto.ManageJcookOrderSearch;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.api.vo.jcook.manageOrder.ManageJcookOrderVo;
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
 * 京库克商城（后台端）商品订单管理
 */
@RestController
@RequestMapping("manage/jcookOrder")
public class JcookOrderController {
    @Resource
    JcookOrderService jcookOrderService;


    /**
     * 查询所有的商品订单信息
     * @param manageJcookOrderSearch manage jcook商品订单搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ManageJcookOrderSearch manageJcookOrderSearch){
        PageHelper.startPage(manageJcookOrderSearch.getPageNum(),manageJcookOrderSearch.getSize());
        List<ManageJcookOrderVo> manageJcookOrderVoList = jcookOrderService.list(manageJcookOrderSearch);
        PageInfo<ManageJcookOrderVo> pageInfo = new PageInfo<>(manageJcookOrderVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 取消订单
     * @param manageJcookCancelOrderDTO 取消订单 DTO
     * @return map
     */
    @GetMapping("/cancel")
    public Map<String,Object> cancel(ManageJcookCancelOrderDTO manageJcookCancelOrderDTO){
        return jcookOrderService.cancel(manageJcookCancelOrderDTO);
    }

}
