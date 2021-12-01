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
        queryWrapper.eq("status",1);//1.jcook商品上架
        queryWrapper.eq("shop_status",1);//1.小蜜蜂商品上架
        Integer skuTotal = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",skuTotal);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> settledBrandsNum() {
        map = new HashMap<>();

        QueryWrapper<JcookBrand> queryWrapper = new QueryWrapper<>();
        Integer settledBrandsNum = jcookBrandMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",settledBrandsNum);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> newProductsTodayNum() {
        map = new HashMap<>();
        //获取当天起始时间和结束时间
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//当天零点
        Date dateStart = Date.from(today_start.atZone(ZoneId.systemDefault()).toInstant());//转Date
        Date dateEnd = Date.from(today_end.atZone(ZoneId.systemDefault()).toInstant());//转Date


        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("updated_at",dateStart);
        queryWrapper.le("updated_at",dateEnd);
        Integer newProductsTodayNum = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",newProductsTodayNum);
        map.put("status",true);
        return map;
    }

    @Override
    public List<OneCategoryVo> findAllCategoryByParentId(Integer parentId) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("parent_id",parentId);//填入商品分类父类主键id，0为顶级分类
        map1.put("is_show",1);//1.显示
        List<JcookCategory> jcookCategories = jcookCategoryMapper.selectByMap(map1);
        ArrayList<OneCategoryVo> oneCategoryVoList = new ArrayList<>();
        if (jcookCategories != null && jcookCategories.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookCategory jcookCategory : jcookCategories) {
                OneCategoryVo oneCategoryVo = new OneCategoryVo();
                PropertyUtils.copyProperties(jcookCategory,oneCategoryVo);
                //获取照片信息
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
        queryWrapper.eq("status",1);//1.jcook商品上架
        queryWrapper.eq("shop_status",1);//1.小蜜蜂商品上架
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<MaxPopularityVo> maxPopularityVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                MaxPopularityVo maxPopularityVo = new MaxPopularityVo();
                PropertyUtils.copyProperties(jcookGood,maxPopularityVo);
                maxPopularityVoList.add(maxPopularityVo);
            }
        }

        map.put("message","请求成功");
        map.put("data",maxPopularityVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public List<RecommendGoodsListVo> findRecommendGoodsList(RecommendGoodsSearch recommendGoodsSearch) {
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        //搜索条件
        queryWrapper.eq("status",1);//1.jcook商品上架
        queryWrapper.eq("shop_status",1);//1.小蜜蜂商品上架
        //价格排序(1.desc[降序]，2.asc[升序])
        if (recommendGoodsSearch.getOrderByPrice() != null){
            if (recommendGoodsSearch.getOrderByPrice() == 1){//1.降序
                queryWrapper.orderByDesc("sell_price");
            }else if (recommendGoodsSearch.getOrderByPrice() == 2){//2.升序
                queryWrapper.orderByAsc("sell_price");
            }
        }
        //品牌主键id
        queryWrapper.eq(recommendGoodsSearch.getBrandId() != null,"brand_id",recommendGoodsSearch.getBrandId());
        //三级分类主键id
        queryWrapper.eq(recommendGoodsSearch.getCategoryThirdId() != null,"category_third_id",recommendGoodsSearch.getCategoryThirdId());
        //最小价格～最大价格，闭区间
        queryWrapper.ge(recommendGoodsSearch.getMaxPrice() != null,"sell_price",recommendGoodsSearch.getMinPrice());
        queryWrapper.le(recommendGoodsSearch.getMinPrice() != null,"sell_price",recommendGoodsSearch.getMaxPrice());
        //关键字搜索
        queryWrapper.like(StringUtils.isNotBlank(recommendGoodsSearch.getKeyword()),"sku_name",recommendGoodsSearch.getKeyword());
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<RecommendGoodsListVo> recommendGoodsListVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                RecommendGoodsListVo recommendGoodsListVo = new RecommendGoodsListVo();
                PropertyUtils.copyProperties(jcookGood,recommendGoodsListVo);

                //查询商品是否收藏
                QueryWrapper<JcookCollection> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("jcook_goods_id",jcookGood.getId());
                queryWrapper2.eq("resident_id",recommendGoodsSearch.getId());
                JcookCollection jcookCollection2 = jcookCollectionMapper.selectOne(queryWrapper2);
                if (jcookCollection2 != null){
                    recommendGoodsListVo.setIsCollection(1);//1.收藏,是否收藏(0.不收藏,1.收藏)
                }else {
                    recommendGoodsListVo.setIsCollection(0);//0.不收藏,是否收藏(0.不收藏,1.收藏)
                }

                recommendGoodsListVoList.add(recommendGoodsListVo);
            }
        }




        return recommendGoodsListVoList;
    }

    @Override
    public Map<String, Object> findGoodsDetail(Integer shopId, Integer id) {
        map = new HashMap<>();
        //查询商品基础信息
        JcookGoods jcookGoods = jcookGoodsMapper.selectById(shopId);
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        PropertyUtils.copyProperties(jcookGoods,goodsDetailVo);//填入商品基础信息

        //查询商品image列表
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
        goodsDetailVo.setGoodsDetailImageVos(goodsDetailImageVoList);//填入商品image列表

        //查询参数（品牌、规格）
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("jcook_goods_id",shopId);
        List<JcookSpecification> jcookSpecificationList = jcookSpecificationMapper.selectByMap(map2);
        ArrayList<GoodsDetailSpecificationVo> goodsDetailSpecificationVoList = new ArrayList<>();
        if (jcookSpecificationList != null && jcookSpecificationList.size()>0){
            for (JcookSpecification jcookSpecification : jcookSpecificationList) {
                //商品详情-specification规格参数 DTO 转 VO
                GoodsDetailSpecificationVo goodsDetailSpecificationVo = new GoodsDetailSpecificationVo();
                PropertyUtils.copyProperties(jcookSpecification,goodsDetailSpecificationVo);
                //查询商品详情-specification规格参数-attribute列表
                HashMap<String, Object> map3 = new HashMap<>();
                map3.put("jcook_specification_id",jcookSpecification.getId());
                ArrayList<GoodsDetailSpecificationAttributeVo> goodsDetailSpecificationAttributeVoList = new ArrayList<>();
                List<JcookSpecificationAttribute> jcookSpecificationAttributeList = jcookSpecificationAttributeMapper.selectByMap(map3);
                if (jcookSpecificationAttributeList != null && jcookSpecificationAttributeList.size()>0){
                    for (JcookSpecificationAttribute jcookSpecificationAttribute : jcookSpecificationAttributeList) {
                        //商品详情-specification规格参数-attribute列表 DTO 转 VO
                        GoodsDetailSpecificationAttributeVo goodsDetailSpecificationAttributeVo = new GoodsDetailSpecificationAttributeVo();
                        PropertyUtils.copyProperties(jcookSpecificationAttribute,goodsDetailSpecificationAttributeVo);
                        goodsDetailSpecificationAttributeVoList.add(goodsDetailSpecificationAttributeVo);//添加 商品详情-specification规格参数-attribute列表
                    }
                }
                goodsDetailSpecificationVo.setAttribute(goodsDetailSpecificationAttributeVoList);//填入 商品详情-specification规格参数-attribute列表
                goodsDetailSpecificationVoList.add(goodsDetailSpecificationVo);//添加 参数（品牌、规格）
            }
        }
        goodsDetailVo.setGoodsDetailSpecificationVoList(goodsDetailSpecificationVoList);//填入 参数（品牌、规格）集合

        //查询默认地址
        if (id != null){
            QueryWrapper<JcookAddress> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("resident_id",id);
            queryWrapper2.eq("is_default",1);//1.默认地址
            JcookAddress jcookAddress = jcookAddressMapper.selectOne(queryWrapper2);
            if (jcookAddress != null){//如果存在默认地址
                StringBuilder location = findCityAddressDetails(true, jcookAddress.getLocation());
                goodsDetailVo.setDefaultLocation(location.toString());//填入默认所在地区
                goodsDetailVo.setDefaultAddressDetail(jcookAddress.getAddressDetail());//填入默认详细地址

                //如果存在默认地址 查询库存状态(1.有货，0.无货)
                JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
                StockDetailSkuQuantityRequest stockDetailSkuQuantityRequest = new StockDetailSkuQuantityRequest();
                stockDetailSkuQuantityRequest.setSkuId(jcookGoods.getSkuId());//填入商品编码
                stockDetailSkuQuantityRequest.setQuantity(1);//填入商品数量
                ArrayList<StockDetailSkuQuantityRequest> stockDetailSkuQuantityRequestList = new ArrayList<>();
                stockDetailSkuQuantityRequestList.add(stockDetailSkuQuantityRequest);

                StockDetailRequest stockDetailRequest = new StockDetailRequest();
                stockDetailRequest.setAddress(location.toString()+" "+jcookAddress.getAddressDetail());//填入地址
                stockDetailRequest.setSkuList(stockDetailSkuQuantityRequestList);//填入list内容
                Result<List<StockDetailResponse>> stockDetail = jcookSDK.stockDetail(stockDetailRequest);
                Integer stockState = stockDetail.getData().get(0).getStockState();
                goodsDetailVo.setStockStatus(stockState);//填入库存状态,0.无货，1.有货
            }else {
                //如果默认地址为null,则为无货
                goodsDetailVo.setStockStatus(0);//0.无货
            }
        }else {
            //如果用户为null，则默认地址为null,则为无货
            goodsDetailVo.setStockStatus(0);//0.无货
        }


        //查询商品是否收藏
        QueryWrapper<JcookCollection> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("jcook_goods_id",shopId);
        queryWrapper3.eq("resident_id",id);
        JcookCollection jcookCollection2 = jcookCollectionMapper.selectOne(queryWrapper3);
        if (jcookCollection2 != null){
            goodsDetailVo.setIsCollection(1);//1.收藏,是否收藏(0.不收藏,1.收藏)
        }else {
            goodsDetailVo.setIsCollection(0);//0.不收藏,是否收藏(0.不收藏,1.收藏)
        }

        //TODO 售卖量需要计算出来


        map.put("message","请求成功");
        map.put("data",goodsDetailVo);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findGoodsDetailBigInfo(Integer shopId) {
        map = new HashMap<>();
        //查询pc 端商品介绍[bigInfo 大图信息](使用该 字段)
        QueryWrapper<JcookBigInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",shopId);
        JcookBigInfo jcookBigInfo = jcookBigInfoMapper.selectOne(queryWrapper);

        Set<String> imgStr = getImgStr(jcookBigInfo.getPcWdis());

        map.put("message","请求成功");
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

        map.put("message","请求成功");
        map.put("data",jcookCategoryAllShows);
        map.put("status",true);
        return map;
    }

    /**
     * 递归查询全部的可显示的商品分类信息
     * @param parentId 商品分类父类主键id
     * @return 城市信息
     */
    private List<JcookCategoryAllShow> findAllCategoryRe(int parentId) {
        ArrayList<JcookCategoryAllShow> jcookCategoryAllShows = new ArrayList<>();
        QueryWrapper<JcookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);//填入父类主键id
        queryWrapper.eq("is_show",1);//填入是否显示，0.隐藏，1.显示，隐藏上级会使下级分类一起隐藏
        List<JcookCategory> jcookCategoryList = jcookCategoryMapper.selectList(queryWrapper);
        if (jcookCategoryList != null && jcookCategoryList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookCategory jcookCategory : jcookCategoryList) {
                JcookCategoryAllShow jcookCategoryAllShow = new JcookCategoryAllShow();
                jcookCategoryAllShow.setId(jcookCategory.getId());//填入主键id
                jcookCategoryAllShow.setName(jcookCategory.getName());//填入名称
                List<JcookCategoryAllShow> allCategoryRe = findAllCategoryRe(jcookCategoryAllShow.getId());
                jcookCategoryAllShow.setCategoryList(allCategoryRe);//填入子城市集合
                //获取照片信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("jcookCategory", jcookCategoryAllShow.getId(), "jcookCategoryImg");
                jcookCategoryAllShow.setImgUrls(imgByDate);

                jcookCategoryAllShows.add(jcookCategoryAllShow);
            }
        }
        return jcookCategoryAllShows;
    }

    /**
     * 查询城市地址
     * @param isCreate 是否需要创建了StringBuild对象
     * @param cityAddress 城市地址主键Id
     * @return 城市地址StringBuild对象
     */
    private StringBuilder findCityAddressDetails(boolean isCreate,Integer cityAddress) {
        if (isCreate){
            //创建StringBuild对象
            stringBuilder = new StringBuilder();
        }
        JcookCity jcookCity = jcookCityMapper.selectById(cityAddress);
        if (jcookCity.getParentId() != 0){
            findCityAddressDetails(false,jcookCity.getParentId());//后续循环不需要创建StringBuild对象
            stringBuilder.append(jcookCity.getName()).append(" ");//拼接公司省县市地址
        }

        return stringBuilder;
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
