package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.RefundService;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.vo.shoppingCenter.OrderVo;
import com.api.vo.shoppingCenter.RefundVo;
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

}
