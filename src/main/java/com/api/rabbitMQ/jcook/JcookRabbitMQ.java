package com.api.rabbitMQ.jcook;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.api.mapper.jcook.*;
import com.api.model.jcook.entity.*;
import com.api.model.jcook.mq.*;
import com.api.rabbitMQ.config.JcookQueuesConfig;
import com.api.util.IdWorker;
import com.api.util.PropertyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.example.api.JcookSDK;
import org.example.api.model.*;
import org.example.api.utils.result.Result;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class JcookRabbitMQ {
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;
    @Resource
    JcookImageMapper jcookImageMapper;
    @Resource
    JcookBigInfoMapper jcookBigInfoMapper;
    @Resource
    JcookSpecificationMapper jcookSpecificationMapper;
    @Resource
    JcookSpecificationAttributeMapper jcookSpecificationAttributeMapper;
    @Resource
    JcookExtAttrMapper jcookExtAttrMapper;
    @Resource
    JcookShopMapper jcookShopMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    JcookOrderListMapper jcookOrderListMapper;
    // 获取配置文件中支付宝相关信息(可以使用自己的方式获取)
    @Value("${alipay.aliPayAppId}")
    private String ALIPAY_APP_ID;
    @Value("${alipay.rsaPrivatKey}")
    private String RSA_PRIVAT_KEY;
    @Value("${alipay.rsaAlipayPublicKey}")
    private String RSA_ALIPAY_PUBLIC_KEY;
    @Value("${alipay.aliPayGateway}")
    private String ALIPAY_GATEWAY;
    @Value("${alipay.signType}")
    private String SIGN_TYPE;
    @Value("${alipay.alipayFormat}")
    private String ALIPAY_FORMAT;
    @Value("${alipay.alipayCharset}")
    private String ALIPAY_CHARSET;

    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId

    //监听商品信息修改
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.skuChange)
    public void updateSkuInfo(Channel channel, String json, Message message, @Headers Map<String,Object> map){
        log.info("-----------接收到商品信息修改的消息体："+json);


        SkuChange skuChange = null;
        try {
            skuChange = JSON.parseObject(json, SkuChange.class);
            log.info(skuChange.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:"+e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        //根据商品编码反查商品详情
        JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
        ArrayList<BigInteger> ids = new ArrayList<>();
        ids.add(skuChange.getSkuId());
        SkuDetailRequest skuDetailRequest = new SkuDetailRequest();
        skuDetailRequest.setSkuIdSet(ids);
        Result<List<SkuDetailResponse>> skuDetailResponseList = jcookSDK.skuDetail(skuDetailRequest);
        List<SkuDetailResponse> data = skuDetailResponseList.getData();
        if (data != null && data.size()>0) {
//            System.out.println(skuChange.getSkuId()+"--------------"+ data.size());
            //取数据进数据库
            for (SkuDetailResponse datum : data) {
//                System.out.println(skuChange.getSkuId()+"--------------i-start");
                try {
                    //获取skuBase 基础信息
                    SkuDetailBaseResponse skuDetailBase = datum.getSkuDetailBase();
//                    System.out.println("当前修改的sku_id为：-------  " + skuDetailBase.getSkuId() + " -------");

                    //根据sku_id查询商品主键id
                    QueryWrapper<JcookGoods> queryWrapper4 = new QueryWrapper<>();
                    queryWrapper4.eq("sku_id", skuDetailBase.getSkuId());
                    JcookGoods jcookGoodsFBI = jcookGoodsMapper.selectOne(queryWrapper4);
                    if (jcookGoodsFBI == null){
                        try {
                            //否认消息,拒接该消息重回队列
                            channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        log.info("未找到对应需要修改的商品，跳过该记录");
                        continue;
                    }

//                    //先判断数据库内是否有一级分类，如果没有就添加，有就略过
//                    QueryWrapper<JcookCategory> queryWrapper1 = new QueryWrapper<>();
//                    queryWrapper1.eq("name", skuDetailBase.getCategoryFirstName());
//                    queryWrapper1.eq("parent_id", 0);
//                    JcookCategory jcookCategory = jcookCategoryMapper.selectOne(queryWrapper1);
//                    if (jcookCategory == null) {
//                        //添加一级分类
//                        jcookCategory = new JcookCategory();
//                        jcookCategory.setName(skuDetailBase.getCategoryFirstName());
//                        jcookCategory.setParentId(0);//默认为0顶层
//                        jcookCategory.setIsShow(1);//默认1.显示
//                        jcookCategoryMapper.insert(jcookCategory);
//                    }
//
//                    //再判断数据库内是否有二级分类，如果没有就添加，有就略过
//                    QueryWrapper<JcookCategory> queryWrapper2 = new QueryWrapper<>();
//                    queryWrapper2.eq("name", skuDetailBase.getCategorySecondName());
//                    queryWrapper2.eq("parent_id", jcookCategory.getId());
//                    JcookCategory jcookCategory2 = jcookCategoryMapper.selectOne(queryWrapper2);
//                    if (jcookCategory2 == null) {
//                        //添加一级分类
//                        jcookCategory2 = new JcookCategory();
//                        jcookCategory2.setName(skuDetailBase.getCategorySecondName());
//                        jcookCategory2.setParentId(jcookCategory.getId());//默认为0顶层
//                        jcookCategory2.setIsShow(1);//默认1.显示
//                        jcookCategoryMapper.insert(jcookCategory2);
//                    }
//
//                    //然后判断数据库内是否有三级分类，如果没有就添加，有就略过
//                    QueryWrapper<JcookCategory> queryWrapper3 = new QueryWrapper<>();
//                    queryWrapper3.eq("name", skuDetailBase.getCategoryThirdName());
//                    queryWrapper3.eq("parent_id", jcookCategory2.getId());
//                    JcookCategory jcookCategory3 = jcookCategoryMapper.selectOne(queryWrapper3);
//                    if (jcookCategory3 == null) {
//                        //添加一级分类
//                        jcookCategory3 = new JcookCategory();
//                        jcookCategory3.setName(skuDetailBase.getCategoryThirdName());
//                        jcookCategory3.setParentId(jcookCategory2.getId());//默认为0顶层
//                        jcookCategory3.setIsShow(1);//默认1.显示
//                        jcookCategoryMapper.insert(jcookCategory3);
//                    }

//                    //判断数据库内是否有该店铺，如果没有就添加，有就略过
//                    QueryWrapper<JcookShop> queryWrapper5 = new QueryWrapper<>();
//                    queryWrapper5.eq("shop_name",skuDetailBase.getShopName());
//                    JcookShop jcookShop = jcookShopMapper.selectOne(queryWrapper5);
//                    if (jcookShop == null){
//                        //添加店铺
//                        jcookShop = new JcookShop();
//                        jcookShop.setShopName(skuDetailBase.getShopName());//填入店铺名称
//                        jcookShopMapper.insert(jcookShop);
//                    }
//
//                    //判断数据库内是否有该品牌，如果没有就添加，有就略过
//                    QueryWrapper<JcookBrand> queryWrapper6 = new QueryWrapper<>();
//                    queryWrapper6.eq("brand_name",skuDetailBase.getBrandName());
//                    JcookBrand jcookBrand = jcookBrandMapper.selectOne(queryWrapper6);
//                    if (jcookBrand == null){
//                        //添加品牌
//                        jcookBrand = new JcookBrand();
//                        jcookBrand.setJcookShopId(jcookShop.getId());//填入店铺主键id
//                        jcookBrand.setBrandName(skuDetailBase.getBrandName());//填入品牌名称
//                        jcookBrandMapper.insert(jcookBrand);
//                    }


                    //最后修改商品
                    JcookGoods jcookGoods = new JcookGoods();
                    //修改商品信息
                    jcookGoods.setId(jcookGoodsFBI.getId());//填入sku编码
                    jcookGoods.setSkuName(skuDetailBase.getSkuName());//填入商品名称
//                    jcookGoods.setShopId(jcookShop.getId());//填入店铺主键id
                    jcookGoods.setVendorName(skuDetailBase.getVendorName());//填入供应商名称
//                    jcookGoods.setBrandId(jcookBrand.getId());//填入品牌主键id
//                    jcookGoods.setCategoryFirstId(jcookCategory.getId());//填入一级分类主键id
//                    jcookGoods.setCategorySecondId(jcookCategory2.getId());//填入二级分类主键id
//                    jcookGoods.setCategoryThirdId(jcookCategory3.getId());//填入三级分类主键id
                    jcookGoods.setMainPhoto(skuDetailBase.getMainPhoto());//填入主图url
                    if (skuDetailBase.getStatus()) {
                        jcookGoods.setStatus(1);//1.上架-jcook商品状态
                    } else {
                        jcookGoods.setStatus(0);//0.下架-jcook商品状态
                    }
//                    jcookGoods.setShopStatus(0);//0.下架-小蜜蜂商品状态
                    jcookGoods.setSupplyPrice(new BigDecimal(skuDetailBase.getSupplyPrice()));//填入供货价
                    jcookGoods.setGuidePrice(new BigDecimal(skuDetailBase.getGuidePrice()));//填入指导价
                    jcookGoods.setModel(skuDetailBase.getModel());//填入型号
                    jcookGoods.setTax(skuDetailBase.getTax());//填入税率
                    if (skuDetailBase.getYn()) {
                        jcookGoods.setYn(1);//填入1.有效
                    } else {
                        jcookGoods.setYn(0);//填入0.无效
                    }
                    jcookGoods.setUnit(skuDetailBase.getUnit());//填入商品单位
                    jcookGoods.setUpdatedAt(skuDetailBase.getUpdatedAt());//填入更新时间
                    jcookGoods.setColor(skuDetailBase.getColor());//填入颜色
                    jcookGoods.setWarranty(skuDetailBase.getWarranty());//填入质保
                    jcookGoods.setShelfLife(skuDetailBase.getShelfLife());//填入质保天数
                    jcookGoods.setDelivery(skuDetailBase.getDelivery());//填入发货地址
                    jcookGoods.setPlaceOfProduction(skuDetailBase.getPlaceOfProduction());//填入产地
                    jcookGoods.setKind(skuDetailBase.getKind());//填入商品类别，0=未知 1=自营 2=其他
                    jcookGoods.setLength(skuDetailBase.getLength());//填入长（毫米）
                    jcookGoods.setWidth(skuDetailBase.getWidth());//填入宽（毫米）
                    jcookGoods.setHeight(skuDetailBase.getHeight());//填入高（毫米）
                    jcookGoods.setWeight(skuDetailBase.getWeight());//填入重量（千克）
                    jcookGoodsMapper.updateById(jcookGoods);

//                    //先删除image列表
//                    HashMap<String, Object> map2 = new HashMap<>();
//                    map2.put("jcook_goods_id", jcookGoodsFBI.getId());
//                    jcookImageMapper.deleteByMap(map2);
//                    //再添加image列表
//                    List<SkuDetailsImagesResponse> images = datum.getImages();
//                    if (images != null && images.size() > 0) {
//                        for (SkuDetailsImagesResponse image : images) {
//                            JcookImage jcookImage = new JcookImage();
//                            jcookImage.setJcookGoodsId(jcookGoodsFBI.getId());//填入jcook商品主键id
//                            jcookImage.setUrl(image.getUrl());//填入图片路由地址
//                            if (image.getIsPrimer()) {
//                                jcookImage.setIsPrimer(1);//1.是主图
//                            } else {
//                                jcookImage.setIsPrimer(0);//0.不是主图
//                            }
//                            jcookImage.setOrderSort(image.getOrderSort());//填入图片排序
//                            jcookImageMapper.insert(jcookImage);
//                        }
//                    }
//
//                    //先删除bigInfo大图信息
//                    HashMap<String, Object> map3 = new HashMap<>();
//                    map3.put("jcook_goods_id", jcookGoodsFBI.getId());
//                    jcookBigInfoMapper.deleteByMap(map3);
//                    //再添加bigInfo大图信息
//                    SkuDetailBigInfoResponse bigInfo = datum.getBigInfo();
//                    if (bigInfo != null) {
//                        JcookBigInfo jcookBigInfo = new JcookBigInfo();
//                        jcookBigInfo.setJcookGoodsId(jcookGoodsFBI.getId());//填入jcook商品主键id
//                        jcookBigInfo.setPcWdis(bigInfo.getPcWdis());//填入pc端商品介绍（使用该字段）
//                        jcookBigInfo.setPcJsContent(bigInfo.getPcJsContent());//填入pc js 内容（可能为空）
//                        jcookBigInfo.setPcCssContent(bigInfo.getPcCssContent());//填入pc css 样式（可能为空）
//                        jcookBigInfo.setPcHtmlContent(bigInfo.getPcHtmlContent());//填入pc html 内容（可能为空）
//                        jcookBigInfoMapper.insert(jcookBigInfo);
//                    }

//                    //先查询specification
//                    HashMap<String, Object> map4 = new HashMap<>();
//                    map4.put("jcook_goods_id", jcookGoodsFBI.getId());
//                    List<JcookSpecification> jcookSpecifications = jcookSpecificationMapper.selectByMap(map4);
//                    if (jcookSpecifications != null && jcookSpecifications.size() > 0) {
//                        for (JcookSpecification jcookSpecification : jcookSpecifications) {
//                            //先删除specification 规格参数 和 jcook主体规格参数组
//                            jcookSpecificationMapper.deleteById(jcookSpecification.getId());
//                            HashMap<String, Object> map5 = new HashMap<>();
//                            map5.put("jcook_specification_id", jcookSpecification.getId());
//                            jcookSpecificationAttributeMapper.deleteByMap(map5);
//                            //再添加specification 规格参数
//                            List<SkuDetailSpecificationResponse> specification = datum.getSpecification();
//                            if (specification != null && specification.size() > 0) {
//                                for (SkuDetailSpecificationResponse skuDetailSpecificationResponse : specification) {
//                                    JcookSpecification jcookSpecification2 = new JcookSpecification();
//                                    jcookSpecification2.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
//                                    jcookSpecification2.setGroupName(skuDetailSpecificationResponse.getGroupName());//填入组名
//                                    //添加jcook主体规格参数组
//                                    jcookSpecificationMapper.insert(jcookSpecification2);
//
//                                    List<SkuDetailSpecificationAttributeResponse> attribute = skuDetailSpecificationResponse.getAttribute();
//                                    if (attribute != null && attribute.size() > 0) {
//                                        for (SkuDetailSpecificationAttributeResponse skuDetailSpecificationAttributeResponse : attribute) {
//                                            JcookSpecificationAttribute jcookSpecificationAttribute = new JcookSpecificationAttribute();
//                                            jcookSpecificationAttribute.setJcookSpecificationId(jcookSpecification2.getId());//填入规格参数主体主键id
//                                            jcookSpecificationAttribute.setName(skuDetailSpecificationAttributeResponse.getName());//填入键
//                                            jcookSpecificationAttribute.setValue(skuDetailSpecificationAttributeResponse.getValue());//填入值
//                                            //添加jcook主体规格参数详情
//                                            jcookSpecificationAttributeMapper.insert(jcookSpecificationAttribute);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }


//                    //先删除attribute 列表
//                    HashMap<String, Object> map6 = new HashMap<>();
//                    map6.put("jcook_goods_id",jcookGoodsFBI.getId());
//                    jcookExtAttrMapper.deleteByMap(map6);
//                    //再添加attribute 列表
//                    List<SkuDetailExtAttrResponse> extAttr = datum.getExtAttr();
//                    if (extAttr != null && extAttr.size() > 0) {
//                        for (SkuDetailExtAttrResponse skuDetailExtAttrResponse : extAttr) {
//                            JcookExtAttr jcookExtAttr = new JcookExtAttr();
//                            jcookExtAttr.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
//                            jcookExtAttr.setName(skuDetailExtAttrResponse.getName());//填入键
//                            jcookExtAttr.setValue(skuDetailExtAttrResponse.getValue());//填入值
//                            jcookExtAttrMapper.insert(jcookExtAttr);
//                        }
//                    }

//                    System.out.println(skuChange.getSkuId()+"--------------i-end");
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        //否认消息,拒接该消息重回队列
                        channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    log.info("发生异常，跳过修改该商品");
                    continue;
                }
            }
        }


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }

    }

    //监听商品价格修改
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.skuPrice)
    public void updateSkuPrice(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品价格修改的消息体：" + json);

        SkuPrice skuPrice = null;
        try {
            skuPrice = JSON.parseObject(json, SkuPrice.class);
            log.info(skuPrice.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        //根据商品编码反查商品详情
        JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
        ArrayList<BigInteger> ids = new ArrayList<>();
        SkuDetailRequest skuDetailRequest = new SkuDetailRequest();
        skuDetailRequest.setSkuIdSet(ids);
        Result<List<SkuDetailResponse>> skuDetailResponseList = jcookSDK.skuDetail(skuDetailRequest);
        List<SkuDetailResponse> data = skuDetailResponseList.getData();
        if (data != null && data.size()>0) {
            //取数据进数据库
            for (SkuDetailResponse datum : data) {
                //获取skuBase 基础信息
                SkuDetailBaseResponse skuDetailBase = datum.getSkuDetailBase();
//                System.out.println("当前修改价格的sku_id为：-------  " + skuDetailBase.getSkuId() + " -------");

                //根据sku_id查询商品主键id
                QueryWrapper<JcookGoods> queryWrapper4 = new QueryWrapper<>();
                queryWrapper4.eq("sku_id", skuDetailBase.getSkuId());
                JcookGoods jcookGoodsFBI = jcookGoodsMapper.selectOne(queryWrapper4);
                if (jcookGoodsFBI == null){
                    try {
                        //否认消息,拒接该消息重回队列
                        channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    log.info("未找到对应需要修改价格的商品，跳过该记录");
                    continue;
                }

                //修改商品价格
                JcookGoods jcookGoods = new JcookGoods();
                jcookGoods.setId(jcookGoodsFBI.getId());//填入商品主键id
                jcookGoods.setSupplyPrice(new BigDecimal(skuDetailBase.getSupplyPrice()));//填写供货价
                jcookGoods.setGuidePrice(new BigDecimal(skuDetailBase.getGuidePrice()));//添加指导价
                jcookGoodsMapper.updateById(jcookGoods);
            }
        }

        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听商品订单创建
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.orderCreate)
    public void orderCreate(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品订单创建的消息体：" + json);

        OrderCreate orderCreate = null;
        try {
            orderCreate = JSON.parseObject(json, OrderCreate.class);
            log.info(orderCreate.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //判断是否是售后换新
        if (new BigDecimal(orderCreate.getTotalFee()).compareTo(BigDecimal.ZERO) == 0){
            log.info("售后换新---------------start");
            //售后换新流程
            //查询是否有对应的parentOrderId，如果没有则跳过，
            QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("jcook_code",orderCreate.getParentOrderId());
            JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);
            if (jcookOrder == null){
                try {
                    //否认消息,使消息重回队列
                    channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
                    return;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    return;
                }
            }
            //创建新订单，并将父订单状态置为售后换新
            //--将父订单状态置为售后换新
            jcookOrder.setTradeStatus(11);//11.售后换新
            jcookOrderMapper.updateById(jcookOrder);
            //--创建新订单
            JcookOrder jcookOrderNew = new JcookOrder();
            PropertyUtils.copyProperties(jcookOrder,jcookOrderNew);
            jcookOrderNew.setTradeStatus(2);//2.交易支付成功（待发货）
            jcookOrderNew.setPayPrice(new BigDecimal(orderCreate.getTotalFee()));//填入包含运费的金额【指供货价】
            jcookOrderNew.setFreightFee(new BigDecimal(orderCreate.getFreightFee()));//填入运费
            jcookOrderMapper.insert(jcookOrderNew);
            //售卖价总金额
            BigDecimal sellPriceTotal = BigDecimal.ZERO;
            //查询旧订单详情
            List<OrderCreateSkuInfo> skuList = orderCreate.getSkuList();
            if (skuList != null && skuList.size()>0){
                for (OrderCreateSkuInfo orderCreateSkuInfo : skuList) {
                    //根据sku编码和旧订单号，查询商品价格
                    QueryWrapper<JcookOrderList> queryWrapper3 = new QueryWrapper<>();
                    queryWrapper3.eq("sku_id",orderCreateSkuInfo.getSkuId());
                    queryWrapper3.eq("jcook_order_id",orderCreate.getParentOrderId());
                    JcookOrderList jcookOrderList = jcookOrderListMapper.selectOne(queryWrapper3);
                    //添加新订单详情
                    jcookOrderList.setJcookOrderId(jcookOrderNew.getId());//填入jcook订单主键id
                    jcookOrderList.setNum(orderCreateSkuInfo.getQuantity());//填入购买数量
                    jcookOrderList.setPayPrice(jcookOrderList.getSellPrice().multiply(new BigDecimal(jcookOrderList.getNum())));//填入付款金额
                    jcookOrderList.setSkuName(orderCreateSkuInfo.getSkuName());//填入商品名称
                    jcookOrderList.setMainPhoto(orderCreateSkuInfo.getUrl());//填入主图url
                    jcookOrderListMapper.insert(jcookOrderList);

                    sellPriceTotal = sellPriceTotal.add(jcookOrderList.getSellPrice().multiply(new BigDecimal(jcookOrderList.getNum())));//对售卖价总金额进行累加
                }
            }
            //修改对应的包含运费的金额，使之变为售卖价
            jcookOrderNew.setPayPrice(sellPriceTotal.add(new BigDecimal(orderCreate.getFreightFee())));//填入包含运费的售卖价金额【指售卖价】
            jcookOrderMapper.updateById(jcookOrderNew);
            log.info("售后换新---------------end");
        }

        //判断是否拆单
        if (orderCreate.getParentOrderId().compareTo(BigInteger.ZERO) != 0){
            log.info("发生拆单---------------start");
            //发生拆单
            //拆单流程
            //查询是否有对应的parentOrderId，如果没有则跳过，
            QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("jcook_code",orderCreate.getParentOrderId());
            JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);
            if (jcookOrder == null){
                log.info("未查询到对应的父订单，使该拆单流程重回mq队列");
                try {
                    //否认消息,使消息重回队列
                    channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
                    return;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    return;
                }
            }
            //创建新订单，并将父订单状态置为发生拆单
            //--将父订单状态置为发生拆单
            jcookOrder.setTradeStatus(10);//10.发生拆单
            jcookOrderMapper.updateById(jcookOrder);
            //--创建新订单
            JcookOrder jcookOrderNew = new JcookOrder();
            PropertyUtils.copyProperties(jcookOrder,jcookOrderNew);
            jcookOrderNew.setTradeStatus(2);//2.交易支付成功（待发货）
            jcookOrderNew.setPayPrice(new BigDecimal(orderCreate.getTotalFee()));//填入包含运费的金额【指供货价】
            jcookOrderNew.setFreightFee(new BigDecimal(orderCreate.getFreightFee()));//填入运费
            jcookOrderMapper.insert(jcookOrderNew);
            //售卖价总金额
            BigDecimal sellPriceTotal = BigDecimal.ZERO;
            //查询旧订单详情
            List<OrderCreateSkuInfo> skuList = orderCreate.getSkuList();
            if (skuList != null && skuList.size()>0){
                for (OrderCreateSkuInfo orderCreateSkuInfo : skuList) {
                    //根据sku编码和旧订单号，查询商品价格
                    QueryWrapper<JcookOrderList> queryWrapper3 = new QueryWrapper<>();
                    queryWrapper3.eq("sku_id",orderCreateSkuInfo.getSkuId());
                    queryWrapper3.eq("jcook_order_id",orderCreate.getParentOrderId());
                    JcookOrderList jcookOrderList = jcookOrderListMapper.selectOne(queryWrapper3);
                    //添加新订单详情
                    jcookOrderList.setJcookOrderId(jcookOrderNew.getId());//填入jcook订单主键id
                    jcookOrderList.setNum(orderCreateSkuInfo.getQuantity());//填入购买数量
                    jcookOrderList.setPayPrice(jcookOrderList.getSellPrice().multiply(new BigDecimal(jcookOrderList.getNum())));//填入付款金额
                    jcookOrderList.setSkuName(orderCreateSkuInfo.getSkuName());//填入商品名称
                    jcookOrderList.setMainPhoto(orderCreateSkuInfo.getUrl());//填入主图url
                    jcookOrderListMapper.insert(jcookOrderList);

                    sellPriceTotal = sellPriceTotal.add(jcookOrderList.getSellPrice().multiply(new BigDecimal(jcookOrderList.getNum())));//对售卖价总金额进行累加
                }
            }
            //修改对应的包含运费的金额，使之变为售卖价
            jcookOrderNew.setPayPrice(sellPriceTotal.add(new BigDecimal(orderCreate.getFreightFee())));//填入包含运费的售卖价金额【指售卖价】
            jcookOrderMapper.updateById(jcookOrderNew);
            log.info("发生拆单---------------end");
        }

        //parentOrderId等于0则未发生拆单,不做任何处理，直接消费


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听订单支付成功
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.orderPay)
    public void orderPay(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品订单支付成功的消息体：" + json);

        OrderPay orderPay = null;
        try {
            orderPay = JSON.parseObject(json, OrderPay.class);
            log.info(orderPay.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //查询用户支付宝是否支付成功
        //查询是否有对应的parentOrderId，如果没有则跳过，
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_code",orderPay.getOrderId());
        JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);
        if (jcookOrder == null){
            //订单号异常,直接抛弃mq
            log.info("订单号异常,未查询到对应的订单，order_id:"+orderPay.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }else if (jcookOrder.getTradeStatus() == 0){
            //交易创建并等待买家付款，重回mq
            log.info("该订单尚未支付成功，使该订单推送流程重回mq队列,order_id"+orderPay.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        } else if (jcookOrder.getTradeStatus() != 2){
            //交易未支付成功，直接抛弃mq
            log.info("交易未支付成功，order_id:"+orderPay.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        log.info("------------------jcook推送-----------start");
        //当用户支付成功则push订单到生产环境
        OrderPushRequest orderPushRequest = new OrderPushRequest();
        orderPushRequest.setOrderId(new BigInteger(jcookOrder.getJcookCode()));//填入jcook返回的订单
        JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
        Result<String> stringResult = jcookSDK.orderPush(orderPushRequest);

        //如果推送jcook失败，则取消订单并退款
        if (stringResult.getCode() != 200){
            log.info(stringResult.getMsg());
            //退款
            log.info("------------------jcook推送失败->支付宝退款-----------start");
            String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//随机数  不是全额退款，部分退款必须使用该参数
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeRefundRequest request2 = new AlipayTradeRefundRequest();
            request2.setBizContent("{" +
                    "\"out_trade_no\":\"" + jcookOrder.getCode() + "\"," +
                    "\"trade_no\":" + null + "," +
                    "\"refund_amount\":\"" + jcookOrder.getPayPrice() + "\"," +
                    "\"out_request_no\":\"" + out_request_no+ "\"," +
                    "\"refund_reason\":\"正常退款\"" +
                    " }");
            AlipayTradeRefundResponse response2;
            try {
                response2 = alipayClient.execute(request2);
                if (response2.isSuccess()) {
                    //修改订单状态
                    jcookOrder.setTradeStatus(1);//1.未付款交易超时关闭或支付完成后全额退款
                    jcookOrderMapper.updateById(jcookOrder);
                    log.info("-------支付宝退款成功-------");
                } else {
                    log.info("-------msg:"+response2.getSubMsg());//失败会返回错误信息
                }
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            log.info("------------------jcook推送失败->支付宝退款-----------end");
        }
        log.info("------------------jcook推送-----------end");


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听订单出库
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.orderStockOut)
    public void orderStockOut(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品订单出库的消息体：" + json);

        OrderStockOut orderStockOut = null;
        try {
            orderStockOut = JSON.parseObject(json, OrderStockOut.class);
            log.info(orderStockOut.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //根据jcook订单号查询订单
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_code",orderStockOut.getOrderId());
        JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);

        if (jcookOrder == null){
            //订单号异常,直接抛弃mq
            log.info("订单号异常,未查询到对应的订单，order_id:"+orderStockOut.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }
        //修改对应的状态为4.出库（待收货）
        jcookOrder.setTradeStatus(4);//4.出库（待收货）
        jcookOrderMapper.updateById(jcookOrder);


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听订单完成
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.orderFinished)
    public void orderFinished(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品订单完成的消息体：" + json);

        OrderFinished orderFinished = null;
        try {
            orderFinished = JSON.parseObject(json, OrderFinished.class);
            log.info(orderFinished.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //根据jcook订单号查询订单
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_code",orderFinished.getOrderId());
        JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);

        if (jcookOrder == null){
            //订单号异常,直接抛弃mq
            log.info("订单号异常,未查询到对应的订单，order_id:"+orderFinished.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }
        //修改对应的状态为5.订单完成
        jcookOrder.setTradeStatus(5);//5.订单完成
        jcookOrderMapper.updateById(jcookOrder);


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听订单取消
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.orderCancel)
    public void orderCancel(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品订单取消的消息体：" + json);

        OrderCancel orderCancel = null;
        try {
            orderCancel = JSON.parseObject(json, OrderCancel.class);
            log.info(orderCancel.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //根据jcook订单号查询订单
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_code",orderCancel.getOrderId());
        JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);

        if (jcookOrder == null){
            //订单号异常,直接抛弃mq
            log.info("订单号异常,未查询到对应的订单，order_id:"+orderCancel.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }
        switch (orderCancel.getCancelStatus()){
            case 1://1.取消订单成功
                jcookOrder.setTradeStatus(9);//9.取消订单成功
                break;
            case 2://2.取消订单失败
                jcookOrder.setTradeStatus(8);//8.取消订单失败
                break;
            case 3://3.申请取消
                jcookOrder.setTradeStatus(6);//6.申请取消
                break;
            case 4://4.申请拒收
                jcookOrder.setTradeStatus(7);//7.申请拒收
                break;
            default:
                log.info("出现未知取消订单状态");
                break;
        }
        //修改对应的订单取消状态
        jcookOrderMapper.updateById(jcookOrder);


        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }

    //监听退款成功
    @RabbitHandler
    @RabbitListener(queues = JcookQueuesConfig.anyRefund)
    public void anyRefund(Channel channel, String json, Message message, @Headers Map<String,Object> map) {
        log.info("-----------接收到商品退款成功的消息体：" + json);

        AnyRefund anyRefund = null;
        try {
            anyRefund = JSON.parseObject(json, AnyRefund.class);
            log.info(anyRefund.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析错误");
            log.info("msg:" + e.getMessage());
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }

        //业务部分
        //根据jcook订单号查询订单
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_code",anyRefund.getOrderId());
        JcookOrder jcookOrder = jcookOrderMapper.selectOne(queryWrapper);

        if (jcookOrder == null){
            //订单号异常,直接抛弃mq
            log.info("订单号异常,未查询到对应的订单，order_id:"+anyRefund.getOrderId());
            try {
                //否认消息,使消息重回队列
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return;
            }
        }
        //进入支付宝退款流程
        String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//随机数  不是全额退款，部分退款必须使用该参数

        AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + jcookOrder.getCode() + "\"," +
                "\"trade_no\":" + null + "," +
                "\"refund_amount\":\"" + jcookOrder.getPayPrice() + "\"," +

                "\"out_request_no\":\"" + out_request_no+ "\"," +
                "\"refund_reason\":\"正常退款\"" +
                " }");
        AlipayTradeRefundResponse response;
        try {
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                log.info("支付宝退款成功");
                //修改对应的订单取消状态
                jcookOrder.setTradeStatus(1);//1.未付款交易超时关闭或支付完成后全额退款
                jcookOrderMapper.updateById(jcookOrder);
            } else {
                log.info("支付宝退款失败");
                log.info(response.getSubMsg());//失败会返回错误信息
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //<P>代码为在消费者中开启消息接收确认的手动ack</p>
        //<H>配置完成</H>
        //<P>可以开启全局配置</p>
        if (map.get("error")!= null){
            log.info("错误的消息");
            try {
                //否认消息,拒接该消息重回队列
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //手动ACK
        //默认情况下如果一个消息被消费者所正确接收则会被从队列中移除
        //如果一个队列没被任何消费者订阅，那么这个队列中的消息会被 Cache（缓存），
        //当有消费者订阅时则会立即发送，当消息被消费者正确接收时，就会被从队列中移除
        try {
            //手动ack应答
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了
            // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息消费成功：id：{}",message.getMessageProperties().getDeliveryTag());
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                //最后一个参数是：是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                //拒绝消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //消息被丢失
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //消息被重新发送
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
                //多条消息被重新发送
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.info("消息消费失败：id：{}",message.getMessageProperties().getDeliveryTag());
        }
    }


}
