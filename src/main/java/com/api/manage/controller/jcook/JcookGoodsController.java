package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookGoodsService;
import com.api.model.jcook.manageDto.ManageJcookGoodsSearch;
import com.api.model.jcook.manageDto.ManageJcookUpdatePriceDTO;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 京库克商城（后台端）商品管理
 */
@RestController
@RequestMapping("manage/jcookGoods")
public class JcookGoodsController {
    @Resource
    JcookGoodsService jcookGoodsService;

    /**
     * 查询所有的商品信息
     * @param manageJcookGoodsSearch manage jcook商品搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ManageJcookGoodsSearch manageJcookGoodsSearch){
        PageHelper.startPage(manageJcookGoodsSearch.getPageNum(),manageJcookGoodsSearch.getSize());
        List<ManageJcookGoodsVo> manageJcookGoodsVoList = jcookGoodsService.list(manageJcookGoodsSearch);
        PageInfo<ManageJcookGoodsVo> pageInfo = new PageInfo<>(manageJcookGoodsVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 一键上架
     * @param ids 商品主键id数组
     * @return map
     */
    @PostMapping("/onShelf")
    public Map<String,Object> onShelf(@RequestBody VoIds ids){
        return jcookGoodsService.onShelf(ids.getIds());
    }

    /**
     * 一键下架
     * @param ids 商品主键id数组
     * @return map
     */
    @PostMapping("/offShelf")
    public Map<String,Object> offShelf(@RequestBody VoIds ids){
        return jcookGoodsService.offShelf(ids.getIds());
    }

    /**
     * 根据商品主键id查询商品详情
     * @param jcookGoodsId 商品主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer jcookGoodsId){
        return jcookGoodsService.findDetailById(jcookGoodsId);
    }

    /**
     * 查询商品详情 bigInfo大图信息【加载太慢了所以异步查询该接口】
     * @param jcookGoodsId 商品主键id
     * @return map
     */
    @GetMapping("/findGoodsDetailBigInfo")
    public Map<String,Object> findGoodsDetailBigInfo(Integer jcookGoodsId){
        return jcookGoodsService.findGoodsDetailBigInfo(jcookGoodsId);
    }


    /**
     * 修改商品价格
     * @return map
     */
    @PostMapping("/updatePrice")
    public Map<String,Object> updatePrice(@RequestBody ManageJcookUpdatePriceDTO manageJcookUpdatePriceDTO){
        return jcookGoodsService.updatePrice(manageJcookUpdatePriceDTO);
    }
}
