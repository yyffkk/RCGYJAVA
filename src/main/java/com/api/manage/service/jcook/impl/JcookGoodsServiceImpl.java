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
                manageJcookGoodsVo.setBrandName(jcookBrand.getBrandName());//??????????????????

                JcookShop jcookShop = jcookShopMapper.selectById(jcookGood.getShopId());
                manageJcookGoodsVo.setShopName(jcookShop.getShopName());//??????????????????

                JcookCategory jcookCategoryFirst = jcookCategoryMapper.selectById(jcookGood.getCategoryFirstId());
                manageJcookGoodsVo.setCategoryFirstName(jcookCategoryFirst.getName());//????????????????????????

                JcookCategory jcookCategorySecond = jcookCategoryMapper.selectById(jcookGood.getCategorySecondId());
                manageJcookGoodsVo.setCategorySecondName(jcookCategorySecond.getName());//????????????????????????

                JcookCategory jcookCategoryThird = jcookCategoryMapper.selectById(jcookGood.getCategoryThirdId());
                manageJcookGoodsVo.setCategoryThirdName(jcookCategoryThird.getName());//????????????????????????

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
                jcookGoods.setId(id);//????????????id
                jcookGoods.setShopStatus(1);//??????????????????????????????0.?????????1.????????????jcook?????????????????????????????????
                int update = jcookGoodsMapper.updateById(jcookGoods);
                if (update <= 0){
                    throw new RuntimeException("??????????????????");
                }
            }
        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","??????????????????");
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
                jcookGoods.setId(id);//????????????id
                jcookGoods.setShopStatus(0);//??????????????????????????????0.?????????1.????????????jcook?????????????????????????????????
                int update = jcookGoodsMapper.updateById(jcookGoods);
                if (update <= 0){
                    throw new RuntimeException("??????????????????");
                }
            }
        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","??????????????????");
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
        manageJcookGoodsVo.setBrandName(jcookBrand.getBrandName());//??????????????????

        JcookShop jcookShop = jcookShopMapper.selectById(jcookGood.getShopId());
        manageJcookGoodsVo.setShopName(jcookShop.getShopName());//??????????????????

        JcookCategory jcookCategoryFirst = jcookCategoryMapper.selectById(jcookGood.getCategoryFirstId());
        manageJcookGoodsVo.setCategoryFirstName(jcookCategoryFirst.getName());//????????????????????????

        JcookCategory jcookCategorySecond = jcookCategoryMapper.selectById(jcookGood.getCategorySecondId());
        manageJcookGoodsVo.setCategorySecondName(jcookCategorySecond.getName());//????????????????????????

        JcookCategory jcookCategoryThird = jcookCategoryMapper.selectById(jcookGood.getCategoryThirdId());
        manageJcookGoodsVo.setCategoryThirdName(jcookCategoryThird.getName());//????????????????????????



        map.put("message","????????????");
        map.put("data",manageJcookGoodsVo);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findGoodsDetailBigInfo(Integer jcookGoodsId) {
        //??????pc ???????????????[bigInfo ????????????](????????? ??????)
        QueryWrapper<JcookBigInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",jcookGoodsId);
        JcookBigInfo jcookBigInfo = jcookBigInfoMapper.selectOne(queryWrapper);

        Set<String> imgStr = getImgStr(jcookBigInfo.getPcWdis());


        map.put("message","????????????");
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
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }
        return map;
    }

    /** ???????????????????????????????????? */
    public Set<String> getImgStr(String htmlStr) {
        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //??????????????????
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";

        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // ??????<img />??????
            img = m_image.group();
            // ??????<img>??????src??????
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
            // ??????<img />??????
            img = m_image2.group();
            // ??????<img>??????src??????
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }

        return pics;
    }
}
