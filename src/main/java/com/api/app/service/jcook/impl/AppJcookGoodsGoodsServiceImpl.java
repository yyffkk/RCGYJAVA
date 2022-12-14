package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookGoodsService;
import com.api.mapper.jcook.*;
import com.api.model.jcook.appDto.BrandSearch;
import com.api.model.jcook.appDto.JcookCategoryAllShow;
import com.api.model.jcook.appDto.RecommendGoodsSearch;
import com.api.model.jcook.entity.*;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.jcook.appBrand.GoodsBrandVo;
import com.api.vo.jcook.appGoods.*;
import com.api.vo.resources.VoResourcesImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.example.api.JcookSDK;
import org.example.api.model.StockDetailRequest;
import org.example.api.model.StockDetailResponse;
import org.example.api.model.StockDetailSkuQuantityRequest;
import org.example.api.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AppJcookGoodsGoodsServiceImpl implements AppJcookGoodsService {
    private static StringBuilder stringBuilder = null;
    private static Map<String,Object> map = null;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;
    @Resource
    JcookImageMapper jcookImageMapper;
    @Resource
    JcookSpecificationMapper jcookSpecificationMapper;
    @Resource
    JcookSpecificationAttributeMapper jcookSpecificationAttributeMapper;
    @Resource
    JcookBigInfoMapper jcookBigInfoMapper;
    @Resource
    JcookAddressMapper jcookAddressMapper;
    @Resource
    JcookCityMapper jcookCityMapper;
    @Resource
    JcookCollectionMapper jcookCollectionMapper;
    @Resource
    JcookRotationMapper jcookRotationMapper;


    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId

    @Override
    public Map<String, Object> skuTotal() {
        map = new HashMap<>();

        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);//1.jcook????????????
        queryWrapper.eq("shop_status",1);//1.?????????????????????
        Integer skuTotal = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","????????????");
        map.put("data",skuTotal);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> settledBrandsNum() {
        map = new HashMap<>();

        QueryWrapper<JcookBrand> queryWrapper = new QueryWrapper<>();
        Integer settledBrandsNum = jcookBrandMapper.selectCount(queryWrapper);

        map.put("message","????????????");
        map.put("data",settledBrandsNum);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> newProductsTodayNum() {
        map = new HashMap<>();
        //???????????????????????????????????????
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//????????????
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//????????????
        Date dateStart = Date.from(today_start.atZone(ZoneId.systemDefault()).toInstant());//???Date
        Date dateEnd = Date.from(today_end.atZone(ZoneId.systemDefault()).toInstant());//???Date


        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("updated_at",dateStart);
        queryWrapper.le("updated_at",dateEnd);
        Integer newProductsTodayNum = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","????????????");
        map.put("data",newProductsTodayNum);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findRotationList() {
        map = new HashMap<>();
        QueryWrapper<JcookRotation> queryWrapper = new QueryWrapper<>();
        List<JcookRotation> jcookRotations = jcookRotationMapper.selectList(queryWrapper);
        ArrayList<JcookRotationInfoVo> jcookRotationInfoVoList = new ArrayList<>();
        if (jcookRotations != null && jcookRotations.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookRotation jcookRotation : jcookRotations) {
                JcookRotationInfoVo jcookRotationInfoVo = new JcookRotationInfoVo();
                PropertyUtils.copyProperties(jcookRotation,jcookRotationInfoVo);

                //??????????????????id
                QueryWrapper<JcookGoods> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("sku_id",jcookRotationInfoVo.getSkuId());
                JcookGoods jcookGoods = jcookGoodsMapper.selectOne(queryWrapper2);
                if (jcookGoods != null){
                    jcookRotationInfoVo.setJcookGoodsId(jcookGoods.getId());
                }

                //???????????????????????????
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("jcookRotation", jcookRotationInfoVo.getId(), "jcookRotationImg");
                jcookRotationInfoVo.setImgList(imgByDate);

                jcookRotationInfoVoList.add(jcookRotationInfoVo);
            }
        }

        map.put("message","????????????");
        map.put("status",true);
        map.put("data",jcookRotationInfoVoList);
        return map;
    }

    @Override
    public List<OneCategoryVo> findAllCategoryByParentId(Integer parentId) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("parent_id",parentId);//??????????????????????????????id???0???????????????
        map1.put("is_show",1);//1.??????
        List<JcookCategory> jcookCategories = jcookCategoryMapper.selectByMap(map1);
        ArrayList<OneCategoryVo> oneCategoryVoList = new ArrayList<>();
        if (jcookCategories != null && jcookCategories.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookCategory jcookCategory : jcookCategories) {
                OneCategoryVo oneCategoryVo = new OneCategoryVo();
                PropertyUtils.copyProperties(jcookCategory,oneCategoryVo);
                //??????????????????
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("jcookCategory", oneCategoryVo.getId(), "jcookCategoryImg");
                oneCategoryVo.setImgUrls(imgByDate);

                oneCategoryVoList.add(oneCategoryVo);
            }
        }
        return oneCategoryVoList;
    }

    @Override
    public Map<String, Object> findMaxPopularity(int num) {
        map = new HashMap<>();
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("views_num");
        queryWrapper.last("limit "+num);
        queryWrapper.eq("status",1);//1.jcook????????????
        queryWrapper.eq("shop_status",1);//1.?????????????????????
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<MaxPopularityVo> maxPopularityVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                MaxPopularityVo maxPopularityVo = new MaxPopularityVo();
                PropertyUtils.copyProperties(jcookGood,maxPopularityVo);
                maxPopularityVoList.add(maxPopularityVo);
            }
        }

        map.put("message","????????????");
        map.put("data",maxPopularityVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public List<RecommendGoodsListVo> findRecommendGoodsList(RecommendGoodsSearch recommendGoodsSearch) {
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        //????????????
        queryWrapper.eq("status",1);//1.jcook????????????
        queryWrapper.eq("shop_status",1);//1.?????????????????????
        //????????????(1.desc[??????]???2.asc[??????])
        if (recommendGoodsSearch.getOrderByPrice() != null){
            if (recommendGoodsSearch.getOrderByPrice() == 1){//1.??????
                queryWrapper.orderByDesc("sell_price");
            }else if (recommendGoodsSearch.getOrderByPrice() == 2){//2.??????
                queryWrapper.orderByAsc("sell_price");
            }
        }
        //????????????id
        queryWrapper.eq(recommendGoodsSearch.getBrandId() != null,"brand_id",recommendGoodsSearch.getBrandId());
        //??????????????????id
        queryWrapper.eq(recommendGoodsSearch.getCategoryThirdId() != null,"category_third_id",recommendGoodsSearch.getCategoryThirdId());
        //???????????????????????????????????????
        queryWrapper.ge(recommendGoodsSearch.getMaxPrice() != null,"sell_price",recommendGoodsSearch.getMinPrice());
        queryWrapper.le(recommendGoodsSearch.getMinPrice() != null,"sell_price",recommendGoodsSearch.getMaxPrice());
        //???????????????
        queryWrapper.like(StringUtils.isNotBlank(recommendGoodsSearch.getKeyword()),"sku_name",recommendGoodsSearch.getKeyword());
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<RecommendGoodsListVo> recommendGoodsListVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                RecommendGoodsListVo recommendGoodsListVo = new RecommendGoodsListVo();
                PropertyUtils.copyProperties(jcookGood,recommendGoodsListVo);

                //????????????????????????
                QueryWrapper<JcookCollection> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("jcook_goods_id",jcookGood.getId());
                queryWrapper2.eq("resident_id",recommendGoodsSearch.getId());
                JcookCollection jcookCollection2 = jcookCollectionMapper.selectOne(queryWrapper2);
                if (jcookCollection2 != null){
                    recommendGoodsListVo.setIsCollection(1);//1.??????,????????????(0.?????????,1.??????)
                }else {
                    recommendGoodsListVo.setIsCollection(0);//0.?????????,????????????(0.?????????,1.??????)
                }

                recommendGoodsListVoList.add(recommendGoodsListVo);
            }
        }




        return recommendGoodsListVoList;
    }

    @Override
    public Map<String, Object> findGoodsDetail(Integer shopId, Integer id) {
        map = new HashMap<>();
        //????????????????????????
        JcookGoods jcookGoods = jcookGoodsMapper.selectById(shopId);
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        PropertyUtils.copyProperties(jcookGoods,goodsDetailVo);//????????????????????????

        //????????????image??????
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("jcook_goods_id",shopId);
        List<JcookImage> jcookImages = jcookImageMapper.selectByMap(map1);
        ArrayList<GoodsDetailImageVo> goodsDetailImageVoList = new ArrayList<>();
        if (jcookImages != null && jcookImages.size()>0){
            for (JcookImage jcookImage : jcookImages) {
                GoodsDetailImageVo goodsDetailImageVo = new GoodsDetailImageVo();
                PropertyUtils.copyProperties(jcookImage,goodsDetailImageVo);
                goodsDetailImageVoList.add(goodsDetailImageVo);
            }
        }
        goodsDetailVo.setGoodsDetailImageVos(goodsDetailImageVoList);//????????????image??????

        //?????????????????????????????????
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("jcook_goods_id",shopId);
        List<JcookSpecification> jcookSpecificationList = jcookSpecificationMapper.selectByMap(map2);
        ArrayList<GoodsDetailSpecificationVo> goodsDetailSpecificationVoList = new ArrayList<>();
        if (jcookSpecificationList != null && jcookSpecificationList.size()>0){
            for (JcookSpecification jcookSpecification : jcookSpecificationList) {
                //????????????-specification???????????? DTO ??? VO
                GoodsDetailSpecificationVo goodsDetailSpecificationVo = new GoodsDetailSpecificationVo();
                PropertyUtils.copyProperties(jcookSpecification,goodsDetailSpecificationVo);
                //??????????????????-specification????????????-attribute??????
                HashMap<String, Object> map3 = new HashMap<>();
                map3.put("jcook_specification_id",jcookSpecification.getId());
                ArrayList<GoodsDetailSpecificationAttributeVo> goodsDetailSpecificationAttributeVoList = new ArrayList<>();
                List<JcookSpecificationAttribute> jcookSpecificationAttributeList = jcookSpecificationAttributeMapper.selectByMap(map3);
                if (jcookSpecificationAttributeList != null && jcookSpecificationAttributeList.size()>0){
                    for (JcookSpecificationAttribute jcookSpecificationAttribute : jcookSpecificationAttributeList) {
                        //????????????-specification????????????-attribute?????? DTO ??? VO
                        GoodsDetailSpecificationAttributeVo goodsDetailSpecificationAttributeVo = new GoodsDetailSpecificationAttributeVo();
                        PropertyUtils.copyProperties(jcookSpecificationAttribute,goodsDetailSpecificationAttributeVo);
                        goodsDetailSpecificationAttributeVoList.add(goodsDetailSpecificationAttributeVo);//?????? ????????????-specification????????????-attribute??????
                    }
                }
                goodsDetailSpecificationVo.setAttribute(goodsDetailSpecificationAttributeVoList);//?????? ????????????-specification????????????-attribute??????
                goodsDetailSpecificationVoList.add(goodsDetailSpecificationVo);//?????? ???????????????????????????
            }
        }
        goodsDetailVo.setGoodsDetailSpecificationVoList(goodsDetailSpecificationVoList);//?????? ?????????????????????????????????

        //??????????????????
        if (id != null){
            QueryWrapper<JcookAddress> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("resident_id",id);
            queryWrapper2.eq("is_default",1);//1.????????????
            JcookAddress jcookAddress = jcookAddressMapper.selectOne(queryWrapper2);
            if (jcookAddress != null){//????????????????????????
                StringBuilder location = findCityAddressDetails(true, jcookAddress.getLocation());
                goodsDetailVo.setDefaultLocation(location.toString());//????????????????????????
                goodsDetailVo.setDefaultAddressDetail(jcookAddress.getAddressDetail());//????????????????????????

                //???????????????????????? ??????????????????(1.?????????0.??????)
                JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
                StockDetailSkuQuantityRequest stockDetailSkuQuantityRequest = new StockDetailSkuQuantityRequest();
                stockDetailSkuQuantityRequest.setSkuId(jcookGoods.getSkuId());//??????????????????
                stockDetailSkuQuantityRequest.setQuantity(1);//??????????????????
                ArrayList<StockDetailSkuQuantityRequest> stockDetailSkuQuantityRequestList = new ArrayList<>();
                stockDetailSkuQuantityRequestList.add(stockDetailSkuQuantityRequest);

                StockDetailRequest stockDetailRequest = new StockDetailRequest();
                stockDetailRequest.setAddress(location.toString()+" "+jcookAddress.getAddressDetail());//????????????
                stockDetailRequest.setSkuList(stockDetailSkuQuantityRequestList);//??????list??????
                Result<List<StockDetailResponse>> stockDetail = jcookSDK.stockDetail(stockDetailRequest);
                Integer stockState = stockDetail.getData().get(0).getStockState();
                goodsDetailVo.setStockStatus(stockState);//??????????????????,0.?????????1.??????
            }else {
                //?????????????????????null,????????????
                goodsDetailVo.setStockStatus(0);//0.??????
            }
        }else {
            //???????????????null?????????????????????null,????????????
            goodsDetailVo.setStockStatus(0);//0.??????
        }


        //????????????????????????
        QueryWrapper<JcookCollection> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("jcook_goods_id",shopId);
        queryWrapper3.eq("resident_id",id);
        JcookCollection jcookCollection2 = jcookCollectionMapper.selectOne(queryWrapper3);
        if (jcookCollection2 != null){
            goodsDetailVo.setIsCollection(1);//1.??????,????????????(0.?????????,1.??????)
        }else {
            goodsDetailVo.setIsCollection(0);//0.?????????,????????????(0.?????????,1.??????)
        }

        //TODO ???????????????????????????


        map.put("message","????????????");
        map.put("data",goodsDetailVo);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findGoodsDetailBigInfo(Integer shopId) {
        map = new HashMap<>();
        //??????pc ???????????????[bigInfo ????????????](????????? ??????)
        QueryWrapper<JcookBigInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",shopId);
        JcookBigInfo jcookBigInfo = jcookBigInfoMapper.selectOne(queryWrapper);

        Set<String> imgStr = getImgStr(jcookBigInfo.getPcWdis());

        map.put("message","????????????");
//        map.put("data",jcookBigInfo.getPcWdis());
        map.put("data",imgStr);
        map.put("status",true);
        return map;
    }

    @Override
    public List<GoodsBrandVo> findAllBrand(BrandSearch brandSearch) {
        QueryWrapper<JcookBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("brand_name",brandSearch.getKeyword());
        List<JcookBrand> jcookBrands = jcookBrandMapper.selectList(queryWrapper);
        ArrayList<GoodsBrandVo> goodsBrandVoList = new ArrayList<>();
        if (jcookBrands != null && jcookBrands.size()>0){
            for (JcookBrand jcookBrand : jcookBrands) {
                GoodsBrandVo goodsBrandVo = new GoodsBrandVo();
                PropertyUtils.copyProperties(jcookBrand,goodsBrandVo);
                goodsBrandVoList.add(goodsBrandVo);
            }
        }
        return goodsBrandVoList;
    }

    @Override
    public Map<String, Object> findAllCategoryInfo() {
        map = new HashMap<>();
        List<JcookCategoryAllShow> jcookCategoryAllShows = findAllCategoryRe(0);

        map.put("message","????????????");
        map.put("data",jcookCategoryAllShows);
        map.put("status",true);
        return map;
    }

    /**
     * ???????????????????????????????????????????????????
     * @param parentId ????????????????????????id
     * @return ????????????
     */
    private List<JcookCategoryAllShow> findAllCategoryRe(int parentId) {
        ArrayList<JcookCategoryAllShow> jcookCategoryAllShows = new ArrayList<>();
        QueryWrapper<JcookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);//??????????????????id
        queryWrapper.eq("is_show",1);//?????????????????????0.?????????1.???????????????????????????????????????????????????
        List<JcookCategory> jcookCategoryList = jcookCategoryMapper.selectList(queryWrapper);
        if (jcookCategoryList != null && jcookCategoryList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookCategory jcookCategory : jcookCategoryList) {
                JcookCategoryAllShow jcookCategoryAllShow = new JcookCategoryAllShow();
                jcookCategoryAllShow.setId(jcookCategory.getId());//????????????id
                jcookCategoryAllShow.setName(jcookCategory.getName());//????????????
                List<JcookCategoryAllShow> allCategoryRe = findAllCategoryRe(jcookCategoryAllShow.getId());
                jcookCategoryAllShow.setCategoryList(allCategoryRe);//?????????????????????
                //??????????????????
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("jcookCategory", jcookCategoryAllShow.getId(), "jcookCategoryImg");
                jcookCategoryAllShow.setImgUrls(imgByDate);

                jcookCategoryAllShows.add(jcookCategoryAllShow);
            }
        }
        return jcookCategoryAllShows;
    }

    /**
     * ??????????????????
     * @param isCreate ?????????????????????StringBuild??????
     * @param cityAddress ??????????????????Id
     * @return ????????????StringBuild??????
     */
    private StringBuilder findCityAddressDetails(boolean isCreate,Integer cityAddress) {
        if (isCreate){
            //??????StringBuild??????
            stringBuilder = new StringBuilder();
        }
        JcookCity jcookCity = jcookCityMapper.selectById(cityAddress);
        if (jcookCity.getParentId() != 0){
            findCityAddressDetails(false,jcookCity.getParentId());//???????????????????????????StringBuild??????
            stringBuilder.append(jcookCity.getName()).append(" ");//???????????????????????????
        }

        return stringBuilder;
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
