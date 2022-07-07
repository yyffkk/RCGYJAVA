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
            if (orderById.getStatus() != 8){//8.申请退换货
                throw new RuntimeException("该状态不可审核");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            order.setReviewer(sysUser.getId());//填入审核人id
            order.setAuditDate(new Date());//填入审核时间

            if (order.getStatus() == 9){//9.申请通过(当前状态不存在，属于解释状态，当期望为【退货】时，为【-3.已退款】；当期望为【换货】时，为【11.换货中】)

                 if (orderById.getBackType() == 1){//1.退货
                    order.setStatus(-3);//已退款
                 }else if (orderById.getBackType() == 2){//2.换货
                    order.setStatus(11);//11.换货中
                 }else {
                     throw new RuntimeException("用户期望数据有误");
                 }
            }else if (order.getStatus() == 10){
                order.setStatus(10);//10.申请驳回
            } else {
                throw new RuntimeException("审核状态数据有误");
            }

            int update = refundDao.examine(order);
            if (update <= 0){
                throw new RuntimeException("审核失败");
            }

            if (order.getStatus() == -3){
                //退款
                String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//随机数  不是全额退款，部分退款必须使用该参数

                AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
                request.setBizContent("{" +
                        "\"out_trade_no\":\"" + orderById.getCode() + "\"," +
                        "\"trade_no\":" + null + "," +
                        "\"refund_amount\":\"" + orderById.getPayPrice() + "\"," +

                        "\"out_request_no\":\"" + out_request_no+ "\"," +
                        "\"refund_reason\":\"正常退款\"" +
                        " }");
                AlipayTradeRefundResponse response;
                response = alipayClient.execute(request);
                if (response.isSuccess()) {
                    log.info("支付宝退款成功");
                } else {
                    throw new RuntimeException(response.getSubMsg());//失败会返回错误信息
                }
            }
        } catch (Exception e) {
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
        map.put("message","审核成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> exchangeGoods(Integer id) {
        map = new HashMap<>();
        Order orderById = orderDao.findById(id);
        if (orderById.getStatus() != 11){//11.换货中
            map.put("message","该状态不可进行此操作");
            map.put("status",false);
            return map;
        }
        AppGoodsAppointment appGoodsAppointment = new AppGoodsAppointment();
        appGoodsAppointment.setCode(orderById.getCode());
        appGoodsAppointment.setStatus(12);//12.已换货


        //根据code【商品预约编号】修改商品预约状态
        int update = shoppingDao.updateSGAStatusByCode(appGoodsAppointment);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }

        return map;
    }
}
