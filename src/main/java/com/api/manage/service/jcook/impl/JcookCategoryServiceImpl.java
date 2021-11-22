package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookCategoryService;
import com.api.mapper.jcook.JcookCategoryMapper;
import com.api.model.jcook.appDto.JcookCityAll;
import com.api.model.jcook.entity.JcookCategory;
import com.api.model.jcook.entity.JcookCity;
import com.api.model.jcook.manageDto.ManageJcookCategorySearch;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.manageCategory.ManageJcookCategoryVo;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JcookCategoryServiceImpl implements JcookCategoryService {
    private static Map<String,Object> map = null;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;

    @Override
    public List<ManageJcookCategoryVo> listByParentId(ManageJcookCategorySearch manageJcookCategorySearch) {
        QueryWrapper<JcookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",manageJcookCategorySearch.getParentId());
        List<JcookCategory> jcookCategoryList = jcookCategoryMapper.selectList(queryWrapper);
        ArrayList<ManageJcookCategoryVo> manageJcookCategoryVoList = new ArrayList<>();
        if (jcookCategoryList != null && jcookCategoryList.size()>0){
            for (JcookCategory jcookCategory : jcookCategoryList) {
                ManageJcookCategoryVo manageJcookCategoryVo = new ManageJcookCategoryVo();
                //DO 转 VO
                PropertyUtils.copyProperties(jcookCategory,manageJcookCategoryVo);
                manageJcookCategoryVoList.add(manageJcookCategoryVo);
            }
        }
        return manageJcookCategoryVoList;
    }

    @Override
    public List<ManageJcookCategoryVo> listAll() {
        List<ManageJcookCategoryVo> manageJcookCategoryVoList = findAllCategoryRe(0);
        return manageJcookCategoryVoList;
    }

    /**
     * 递归查询全部的商品分类信息
     * @param parentId 商品分类父类主键id
     * @return 商品分类信息
     */
    private List<ManageJcookCategoryVo> findAllCategoryRe(int parentId) {
        ArrayList<ManageJcookCategoryVo> manageJcookCategoryVoList = new ArrayList<>();
        QueryWrapper<JcookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        List<JcookCategory> jcookCategoryList = jcookCategoryMapper.selectList(queryWrapper);
        if (jcookCategoryList != null && jcookCategoryList.size()>0){
            for (JcookCategory jcookCategory : jcookCategoryList) {
                ManageJcookCategoryVo manageJcookCategoryVo = new ManageJcookCategoryVo();
                manageJcookCategoryVo.setId(jcookCategory.getId());//填入主键id
                manageJcookCategoryVo.setName(jcookCategory.getName());//填入名称
                manageJcookCategoryVo.setIsShow(jcookCategory.getIsShow());//填入是否显示，1.显示，2.隐藏，隐藏上级会使下级分类一起隐藏
                List<ManageJcookCategoryVo> allCategoryRe = findAllCategoryRe(manageJcookCategoryVo.getId());
                manageJcookCategoryVo.setManageJcookCategoryVoList(allCategoryRe);//填入子商城分类集合
                manageJcookCategoryVoList.add(manageJcookCategoryVo);
            }
        }
        return manageJcookCategoryVoList;
    }
}
