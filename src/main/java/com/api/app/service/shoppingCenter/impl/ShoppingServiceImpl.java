package com.api.app.service.shoppingCenter.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppGoodsIdAndAppointmentNum;
import com.api.model.app.AppGoodsIdAndUserId;
import com.api.model.app.UserIdAndGoodsAppointmentId;
import com.api.model.shoppingCenter.Evaluation;
import com.api.model.shoppingCenter.Order;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.app.AppCategoryVo;
import com.api.vo.app.AppGoodsDetailVo;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.app.AppMyOrderVo;
import com.api.vo.resources.VoResourcesImg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ShoppingServiceImpl implements ShoppingService {
    private static Map<String,Object> map = null;

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

    @Resource
    ShoppingDao shoppingDao;
    @Resource
    OrderDao orderDao;

    @Override
    public Map<String, Object> list(Integer parentId) {
        map = new HashMap<>();
        List<AppCategoryVo> appCategoryVos = shoppingDao.list(parentId);
        if (appCategoryVos != null && appCategoryVos.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppCategoryVo appCategoryVo : appCategoryVos) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopCategory", appCategoryVo.getId(), "categoryImg");
                appCategoryVo.setImgList(imgByDate);
            }
        }
        map.put("data",appCategoryVos);
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public List<AppGoodsVo> findTopGoods() {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findTopGoods();
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        return appGoodsVos;
    }

    @Override
    public List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findGoodsByCategoryId(categoryId);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        return appGoodsVos;
    }

    @Override
    public Map<String, Object> findDetailByGoodsId(Integer goodsId, Integer id) {
        map = new HashMap<>();
        AppGoodsDetailVo appGoodsDetailVo = shoppingDao.findDetailByGoodsId(goodsId);
        if (appGoodsDetailVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsDetailVo.getId(), "goodsImg");
            appGoodsDetailVo.setGoodsImgList(imgByDate);
            List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("shopSupplier", appGoodsDetailVo.getSupplierId(), "supplierImg");
            appGoodsDetailVo.setSupplierImgList(imgByDate1);

            //???????????????????????????????????????
            AppGoodsIdAndUserId goodsIdAndUserId = new AppGoodsIdAndUserId();
            goodsIdAndUserId.setUserId(id);
            goodsIdAndUserId.setGoodsId(goodsId);
            int count = shoppingDao.countAppointmentByGIdAndUId(goodsIdAndUserId);
            if (count >0){
                appGoodsDetailVo.setIsSubscribe(1); //1.??????
            }else {
                appGoodsDetailVo.setIsSubscribe(0); //0.?????????
            }
        }
        map.put("data",appGoodsDetailVo);
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findTopGoodsBySupplierId(Integer supplierId) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findTopGoodsBySupplierId(supplierId);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        map.put("data",appGoodsVos);
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> goodsAppointment(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id) {
        map = new HashMap<>();
        if (type == 4){//4.??????
            map.put("message","?????????????????????????????????????????????");
            map.put("status",false);
            return map;
        }
        //???????????????????????????????????????
        AppGoodsIdAndUserId goodsIdAndUserId = new AppGoodsIdAndUserId();
        goodsIdAndUserId.setUserId(id);
        goodsIdAndUserId.setGoodsId(appGoodsAppointment.getGoodsId());
        int count = shoppingDao.countAppointmentByGIdAndUId(goodsIdAndUserId);
        if (count >0){
            map.put("message","??????????????????????????????????????????????????????");
            map.put("status",false);
            return map;
        }

        appGoodsAppointment.setCreateId(id);
        appGoodsAppointment.setCreateDate(new Date());
        appGoodsAppointment.setStatus(1);//1.?????????
        appGoodsAppointment.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));//??????????????????

        AppGoodsIdAndAppointmentNum appGoodsIdAndAppointmentNum = new AppGoodsIdAndAppointmentNum();
        appGoodsIdAndAppointmentNum.setGoodsId(appGoodsAppointment.getGoodsId());
        appGoodsIdAndAppointmentNum.setAppointmentNum(appGoodsAppointment.getNum());

        //?????????????????????
        int update = shoppingDao.incGoodsAppointmentNum(appGoodsIdAndAppointmentNum);
        if (update <= 0){
            map.put("message","???????????????????????????");
            map.put("status",false);
            return map;
        }

        int insert = shoppingDao.goodsAppointment(appGoodsAppointment);
        if (insert >0){
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }


        return map;
    }

    @Override
    public List<AppGoodsVo> goodsSearch(String searchName) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.goodsSearch(searchName);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        return appGoodsVos;
    }

    @Override
    public List<AppMyOrderVo> myOrder(Integer id, Integer orderStart) {
        Order order = new Order();

        order.setStatus(orderStart);
        order.setCreateId(id);
        List<AppMyOrderVo> appMyOrderVos = shoppingDao.myOrder(order);

        if (appMyOrderVos != null && appMyOrderVos.size()>0){
            for (AppMyOrderVo appMyOrderVo : appMyOrderVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appMyOrderVo.getGoodsId(), "goodsImg");
                appMyOrderVo.setGoodsImgList(imgByDate);
            }
        }

        return appMyOrderVos;
    }

    @Override
    public Map<String, Object> findOrderDetailByOrderId(UserIdAndGoodsAppointmentId UserIdAndGoodsAppointmentId) {
        map = new HashMap<>();
        AppMyOrderVo appMyOrderVo = shoppingDao.findOrderDetailByOrderId(UserIdAndGoodsAppointmentId);
        if (appMyOrderVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appMyOrderVo.getGoodsId(), "goodsImg");
            appMyOrderVo.setGoodsImgList(imgByDate);
        }
        map.put("message","????????????");
        map.put("status",true);
        map.put("data",appMyOrderVo);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> cancel(Integer goodsAppointmentId) {
        map = new HashMap<>();
        try {
            //????????????????????????id??????????????????????????????
            AppGoodsAppointment appGoodsAppointment = shoppingDao.findGoodsOrderById(goodsAppointmentId);

            if (appGoodsAppointment.getStatus() == 15){//15.???????????????????????????
                throw new RuntimeException("?????????????????????????????????");
            }
            //??????????????????????????????
            AppGoodsAppointment appGoodsAppointment1 = new AppGoodsAppointment();
            appGoodsAppointment1.setCode(appGoodsAppointment.getCode());
            appGoodsAppointment1.setStatus(-3);//-3.???????????????????????????
            int update = shoppingDao.updateSGAStatusByCode(appGoodsAppointment1);
            if (update <= 0){
                throw new RuntimeException("??????????????????");
            }

            String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//?????????  ??????????????????????????????????????????????????????

            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            request.setBizContent("{" +
                    "\"out_trade_no\":\"" + appGoodsAppointment.getCode() + "\"," +
                    "\"trade_no\":" + null + "," +
                    "\"refund_amount\":\"" + appGoodsAppointment.getPayPrice() + "\"," +

                    "\"out_request_no\":\"" + out_request_no+ "\"," +
                    "\"refund_reason\":\"????????????\"" +
                    " }");
            AlipayTradeRefundResponse response;
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                log.info("?????????????????????");
            } else {
                throw new RuntimeException(response.getSubMsg());//???????????????????????????
            }

        } catch (Exception e) {
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
    public Map<String, Object> applicationRefund(Integer id, Integer goodsAppointmentId, Integer backType, String backReason) {
        map = new HashMap<>();

        int status = orderDao.findStatusById(goodsAppointmentId);
        if (status != 4){
            map.put("message","????????????????????????");
            map.put("status",false);
            return map;
        }

        Order order = new Order();
        order.setId(goodsAppointmentId);//????????????????????????Id
        order.setCreateId(id);//??????????????????id
        order.setBackType(backType);//?????????????????????1.?????????2.??????
        order.setBackDate(new Date());//????????????????????????
        order.setBackReason(backReason);//??????????????????
        order.setStatus(8);//8.????????????

        int update = shoppingDao.applicationRefund(order);
        if (update > 0){
            map.put("message","??????????????????");
            map.put("status",true);
        }else {
            map.put("message","??????????????????");
            map.put("status",false);
        }


        return map;
    }

    @Override
    public Map<String, Object> confirmReceipt(Integer id, Integer goodsAppointmentId) {
        map = new HashMap<>();

        int status = orderDao.findStatusById(goodsAppointmentId);
        if (status != 3){
            map.put("message","???????????????????????????");
            map.put("status",false);
            return map;
        }

        Order order = new Order();
        order.setId(goodsAppointmentId);//????????????????????????Id
        order.setCreateId(id);//??????????????????id
        order.setReceivingDate(new Date());//??????????????????
        order.setStatus(4);//4.?????????

        int update = shoppingDao.confirmReceipt(order);
        if (update > 0){
            map.put("message","??????????????????");
            map.put("status",true);
        }else {
            map.put("message","??????????????????");
            map.put("status",false);
        }


        return map;
    }

    @Override
    public Map<String, Object> evaluation(Evaluation evaluation) {
        map = new HashMap<>();

        int status = orderDao.findStatusById(evaluation.getGoodsAppointmentId());
        if (status < 4){
            map.put("message","?????????????????????");
            map.put("status",false);
            return map;
        }


        evaluation.setEvaluationDate(new Date());//??????????????????

        int update = shoppingDao.evaluation(evaluation);
        if (update > 0){
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }


        return map;
    }

}
