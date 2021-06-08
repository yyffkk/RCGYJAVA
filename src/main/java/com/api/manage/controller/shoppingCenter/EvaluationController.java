package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.EvaluationService;
import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.model.shoppingCenter.GoodsReply;
import com.api.vo.shoppingCenter.EvaluationVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评价管理
 */
@RestController
@RequestMapping("manage/shop/evaluation")
public class EvaluationController {
    @Resource
    EvaluationService evaluationService;

    /**
     * 查询所有的商品评价信息
     * @param evaluationSearch 评价搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(EvaluationSearch evaluationSearch){
        PageHelper.startPage(evaluationSearch.getPageNum(),evaluationSearch.getSize());
        List<EvaluationVo> evaluationVoList = evaluationService.list(evaluationSearch);
        PageInfo<EvaluationVo> pageInfo = new PageInfo<>(evaluationVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 客服回复
     * @param goodsReply 商品客服回复
     * @return map
     */
    @PostMapping("/reply")
    public Map<String,Object> reply(@RequestBody GoodsReply goodsReply){
        return evaluationService.reply(goodsReply);
    }

}
