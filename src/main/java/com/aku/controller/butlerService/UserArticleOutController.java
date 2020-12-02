package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.model.resources.ResourcesImg;
import com.aku.service.butlerService.UserArticleOutService;
import com.aku.service.resources.ResourcesImgService;
import com.aku.vo.butlerService.VoUserArticleOut;
import com.aku.vo.resources.VoResourcesImg;
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
 * 物品出门
 */
@RestController
@RequestMapping("userArticleOut")
public class UserArticleOutController {
    private static Map<String,Object> map = null;

    @Resource
    UserArticleOutService userArticleOutService;
    @Resource
    ResourcesImgService resourcesImgService;

    /**
     * 查询所有物品出门信息（包含条件搜索）
     * @param searchUserArticleOut 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String, Object> list(SearchUserArticleOut searchUserArticleOut){
        PageHelper.startPage(searchUserArticleOut.getPageNum(),searchUserArticleOut.getSize());
        List<VoUserArticleOut> voUserArticleOutList =userArticleOutService.list(searchUserArticleOut);
        PageInfo<VoUserArticleOut> pageInfo = new PageInfo<>(voUserArticleOutList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 查询物品照片
     * @param id 物品出门主键id
     * @return map
     */
    @GetMapping("/findGoodsImgById")
    public Map<String,Object> findGoodsImgById(Integer id){
        map = new HashMap<>();
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入所属表名称
        resourcesImg.setTableName("userArticleOut");
        //填入资源类型名称
        resourcesImg.setTypeName("goodsImg");
        List<VoResourcesImg> resourcesImgList = resourcesImgService.findGoodsImgByDateId(resourcesImg);
        map.put("resourcesImgList",resourcesImgList);
        return map;
    }


    /**
     * 查询出门照片
     * @param id 物品出门主键id
     * @return map
     */
    @GetMapping("/findGoOutImgById")
    public Map<String,Object> findGoOutImgById(Integer id){
        map = new HashMap<>();
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入所属表名称
        resourcesImg.setTableName("userArticleOut");
        //填入资源类型名称
        resourcesImg.setTypeName("goOutImg");
        List<VoResourcesImg> resourcesImgList = resourcesImgService.findGoodsImgByDateId(resourcesImg);
        map.put("resourcesImgList",resourcesImgList);
        return map;
    }

}