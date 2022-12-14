package com.api.manage.service.shoppingCenter.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.dao.shoppingCenter.RefundDao;
import com.api.manage.service.shoppingCenter.RefundService;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.OrderVo;
import com.api.vo.shoppingCenter.RefundVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
public class RefundServiceImpl implements RefundService {
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
    RefundDao refundDao;
    @Resource
    OrderDao orderDao;
    @Resource
    ShoppingDao shoppingDao;

    @Override
    public List<RefundVo> list(RefundSearch refundSearch) {
        List<RefundVo> list = refundDao.list(refundSearch);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (RefundVo refundVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", refundVo.getGoodsId(), "goodsImg");
                refundVo.setGoodsImgList(imgByDate);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> examine(Order order) {
        map = new HashMap<>();
        try {
            Order orderById = orderDao.findById(order.getId());
            if (orderById.getStatus() != 8){//8.???????????????
                throw new RuntimeException("?????????????????????");
            }

            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            order.setReviewer(sysUser.getId());//???????????????id
            order.setAuditDate(new Date());//??????????????????

            if (order.getStatus() == 9){//9.????????????(?????????????????????????????????????????????????????????????????????????????????-3.???????????????????????????????????????????????????11.????????????)

                 if (orderById.getBackType() == 1){//1.??????
                    order.setStatus(-3);//?????????
                 }else if (orderById.getBackType() == 2){//2.??????
                    order.setStatus(11);//11.?????????
                 }else {
                     throw new RuntimeException("????????????????????????");
                 }
            }else if (order.getStatus() == 10){
                order.setStatus(10);//10.????????????
            } else {
                throw new RuntimeException("????????????????????????");
            }

            int update = refundDao.examine(order);
            if (update <= 0){
                throw new RuntimeException("????????????");
            }

            if (order.getStatus() == -3){
                //??????
                String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//?????????  ??????????????????????????????????????????????????????

                AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
                request.setBizContent("{" +
                        "\"out_trade_no\":\"" + orderById.getCode() + "\"," +
                        "\"trade_no\":" + null + "," +
                        "\"refund_amount\":\"" + orderById.getPayPrice() + "\"," +

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
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> exchangeGoods(Integer id) {
        map = new HashMap<>();
        Order orderById = orderDao.findById(id);
        if (orderById.getStatus() != 11){//11.?????????
            map.put("message","??????????????????????????????");
            map.put("status",false);
            return map;
        }
        AppGoodsAppointment appGoodsAppointment = new AppGoodsAppointment();
        appGoodsAppointment.setCode(orderById.getCode());
        appGoodsAppointment.setStatus(12);//12.?????????


        //??????code????????????????????????????????????????????????
        int update = shoppingDao.updateSGAStatusByCode(appGoodsAppointment);
        if (update >0){
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }

        return map;
    }
}
