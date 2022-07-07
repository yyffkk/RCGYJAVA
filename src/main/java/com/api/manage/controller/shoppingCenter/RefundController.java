package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.RefundService;
import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.vo.shoppingCenter.OrderVo;
import com.api.vo.shoppingCenter.RefundVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 退换管理
 */
@RestController
@RequestMapping("manage/shop/refund")
public class RefundController {
    @Resource
    RefundService refundService;

    /**
     * 查询所有的退换货管理信息
     * @param refundSearch 退换货管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(RefundSearch refundSearch){
        PageHelper.startPage(refundSearch.getPageNum(),refundSearch.getSize());
        List<RefundVo> refundVoList = refundService.list(refundSearch);
        PageInfo<RefundVo> pageInfo = new PageInfo<>(refundVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 审核
     * @param order 商品预约model（订单）
     * @return map
     */
    @PostMapping("/examine")
    public Map<String,Object> examine(@RequestBody Order order){
        return refundService.examine(order);
    }


    /**
     * 已换货
     * @param id 商品预约订单主键id
     * @return map
     */
    @GetMapping("/exchangeGoods")
    public Map<String,Object> exchangeGoods(Integer id){
        return refundService.exchangeGoods(id);
    }

}
