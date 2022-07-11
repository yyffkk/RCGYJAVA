package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookCategoryService;
import com.api.model.jcook.appDto.UpdateCategoryImgDTO;
import com.api.model.jcook.manageDto.ManageJcookCategorySearch;
import com.api.vo.jcook.manageCategory.ManageJcookCategoryVo;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 京库克商城（后台端）分类管理
 */
@RestController
@RequestMapping("manage/jcookCategory")
public class JcookCategoryController {
    @Resource
    JcookCategoryService jcookCategoryService;

    /**
     * 根据分类父类主键id查询分类信息
     * @param manageJcookCategorySearch manage jcook商品分类搜索条件
     * @return map
     */
    @GetMapping("/listByParentId")
    public Map<String,Object> listByParentId(ManageJcookCategorySearch manageJcookCategorySearch){
        PageHelper.startPage(manageJcookCategorySearch.getPageNum(),manageJcookCategorySearch.getSize());
        List<ManageJcookCategoryVo> manageJcookCategoryVoList = jcookCategoryService.listByParentId(manageJcookCategorySearch);
        PageInfo<ManageJcookCategoryVo> pageInfo = new PageInfo<>(manageJcookCategoryVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的分类信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/listAll")
    public Map<String,Object> listAll(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<ManageJcookCategoryVo> manageJcookCategoryVoList = jcookCategoryService.listAll();
        PageInfo<ManageJcookCategoryVo> pageInfo = new PageInfo<>(manageJcookCategoryVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 显示当前分类
     * @param jcookCategoryId 分类主键id
     * @return map
     */
    @GetMapping("/show")
    public Map<String,Object> show(Integer jcookCategoryId){
        return jcookCategoryService.show(jcookCategoryId);
    }

    /**
     * 隐藏当前分类
     * @param jcookCategoryId 分类主键id
     * @return map
     */
    @GetMapping("/hide")
    public Map<String,Object> hide(Integer jcookCategoryId){
        return jcookCategoryService.hide(jcookCategoryId);
    }


    /**
     * 修改商品分类照片
     * @param updateCategoryImgDTO 修改商品分类照片DTO
     * @return map
     */
    @PostMapping("/updateCategoryImg")
    public Map<String,Object> updateCategoryImg(@RequestBody UpdateCategoryImgDTO updateCategoryImgDTO){
        return jcookCategoryService.updateCategoryImg(updateCategoryImgDTO);
    }
}
