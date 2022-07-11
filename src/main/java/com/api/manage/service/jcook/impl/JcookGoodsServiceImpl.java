package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookGoodsService;
import com.api.mapper.jcook.*;
import com.api.model.jcook.entity.*;
import com.api.model.jcook.manageDto.ManageJcookGoodsSearch;
import com.api.model.jcook.manageDto.ManageJcookUpdatePriceDTO;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JcookGoodsServiceImpl implements JcookGoodsService {
    private static Map<String,Object> map = new HashMap<>();
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookShopMapper jcookShopMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;
    @Resource
    JcookBigInfoMapper jcookBigInfoMapper;

    @Override
    public List<ManageJcookGoodsVo> list(ManageJcookGoodsSearch manageJcookGoodsSearch) {
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(manageJcookGoodsSearch.getSkuId() != null,"sku_id",manageJcookGoodsSearch.getSkuId());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookGoodsSearch.getSkuName()),"sku_name",manageJcookGoodsSearch.getSkuName());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookGoodsSearch.getVendorName()),"vendor_name",manageJcookGoodsSearch.getVendorName());
        queryWrapper.eq(manageJcookGoodsSearch.getStatus() != null,"status",manageJcookGoodsSearch.getStatus());
        queryWrapper.eq(manageJcookGoodsSearch.getShopStatus()!= null,"shop_status",manageJcookGoodsSearch.getShopStatus());

        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<ManageJcookGoodsVo> manageJcookGoodsVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                ManageJcookGoodsVo manageJcookGoodsVo = new ManageJcookGoodsVo();
                PropertyUtils.copyProperties(jcookGood,manageJcookGoodsVo);

                JcookBrand jcookBrand = jcookBrandMapper.selectById(jcookGood.getBrandId());
                manageJcookGoodsVo.setBrandName(jcookBrand.getBrandName());//填入品牌名称

                JcookShop jcookShop = jcookShopMapper.selectById(jcookGood.getShopId());
                manageJcookGoodsVo.setShopName(jcookShop.getShopName());//填入商铺名称

                JcookCategory jcookCategoryFirst = jcookCategoryMapper.selectById(jcookGood.getCategoryFirstId());
                manageJcookGoodsVo.setCategoryFirstName(jcookCategoryFirst.getName());//填入一级分类名称

                JcookCategory jcookCategorySecond = jcookCategoryMapper.selectById(jcookGood.getCategorySecondId());
                manageJcookGoodsVo.setCategorySecondName(jcookCategorySecond.getName());//填入二级分类名称

                JcookCategory jcookCategoryThird = jcookCategoryMapper.selectById(jcookGood.getCategoryThirdId());
                manageJcookGoodsVo.setCategoryThirdName(jcookCategoryThird.getName());//填入三级分类名称

                manageJcookGoodsVoList.add(manageJcookGoodsVo);
            }
        }
        return manageJcookGoodsVoList;
    }

    @Override
    @Transactional
    public Map<String, Object> onShelf(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                JcookGoods jcookGoods = new JcookGoods();
                jcookGoods.setId(id);//商品主键id
                jcookGoods.setShopStatus(1);//小蜜蜂商品上架状态，0.下架，1.上架（当jcook商品状态为上架才生效）
                int update = jcookGoodsMapper.updateById(jcookGoods);
                if (update <= 0){
                    throw new RuntimeException("一键上架失败");
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","一键上架成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> offShelf(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                JcookGoods jcookGoods = new JcookGoods();
                jcookGoods.setId(id);//商品主键id
                jcookGoods.setShopStatus(0);//小蜜蜂商品上架状态，0.下架，1.上架（当jcook商品状态为上架才生效）
                int update = jcookGoodsMapper.updateById(jcookGoods);
                if (update <= 0){
                    throw new RuntimeException("一键下架失败");
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","一键下架成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findDetailById(Integer jcookGoodsId) {
        map = new HashMap<>();

        JcookGoods jcookGood = jcookGoodsMapper.selectById(jcookGoodsId);
        ManageJcookGoodsVo manageJcookGoodsVo = new ManageJcookGoodsVo();
        PropertyUtils.copyProperties(jcookGood,manageJcookGoodsVo);

        JcookBrand jcookBrand = jcookBrandMapper.selectById(jcookGood.getBrandId());
        manageJcookGoodsVo.setBrandName(jcookBrand.getBrandName());//填入品牌名称

        JcookShop jcookShop = jcookShopMapper.selectById(jcookGood.getShopId());
        manageJcookGoodsVo.setShopName(jcookShop.getShopName());//填入商铺名称

        JcookCategory jcookCategoryFirst = jcookCategoryMapper.selectById(jcookGood.getCategoryFirstId());
        manageJcookGoodsVo.setCategoryFirstName(jcookCategoryFirst.getName());//填入一级分类名称

        JcookCategory jcookCategorySecond = jcookCategoryMapper.selectById(jcookGood.getCategorySecondId());
        manageJcookGoodsVo.setCategorySecondName(jcookCategorySecond.getName());//填入二级分类名称

        JcookCategory jcookCategoryThird = jcookCategoryMapper.selectById(jcookGood.getCategoryThirdId());
        manageJcookGoodsVo.setCategoryThirdName(jcookCategoryThird.getName());//填入三级分类名称



        map.put("message","请求成功");
        map.put("data",manageJcookGoodsVo);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findGoodsDetailBigInfo(Integer jcookGoodsId) {
        //查询pc 端商品介绍[bigInfo 大图信息](使用该 字段)
        QueryWrapper<JcookBigInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",jcookGoodsId);
        JcookBigInfo jcookBigInfo = jcookBigInfoMapper.selectOne(queryWrapper);

        Set<String> imgStr = getImgStr(jcookBigInfo.getPcWdis());


        map.put("message","请求成功");
//        map.put("data",jcookBigInfo.getPcWdis());
        map.put("data",imgStr);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> updatePrice(ManageJcookUpdatePriceDTO manageJcookUpdatePriceDTO) {
        map = new HashMap<>();

        JcookGoods jcookGoods = new JcookGoods();
        PropertyUtils.copyProperties(manageJcookUpdatePriceDTO,jcookGoods);
        int update = jcookGoodsMapper.updateById(jcookGoods);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }

    /** 获取图片字符串中所有链接 */
    public Set<String> getImgStr(String htmlStr) {
        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";

        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }

        Pattern p_image2;
        Matcher m_image2;
        String regEx_img2 = "background-image:url\\((?s:(.*?))\\)|src=\"(?s:(.*?))\"";
        p_image2 = Pattern.compile(regEx_img2, Pattern.CASE_INSENSITIVE);
        m_image2 = p_image2.matcher(htmlStr);
        while (m_image2.find()) {
            // 得到<img />数据
            img = m_image2.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }

        return pics;
    }
}
