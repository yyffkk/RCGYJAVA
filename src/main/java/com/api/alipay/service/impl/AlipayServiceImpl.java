package com.api.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.api.alipay.config.AlipayConfig;
import com.api.alipay.dao.AlipayDao;
import com.api.alipay.service.AlipayService;
import com.api.model.alipay.AliPaymentOrder;
import com.api.model.alipay.OrderTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class AlipayServiceImpl implements AlipayService {
    @Resource
    AlipayDao alipayDao;

    /**
     * 获取支付宝加签后台的订单信息字符串
     * @param orderTest 测试订单
     * @return map
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String getAliPayOrderStr(OrderTest orderTest) {
        //最终返回加签之后的，app需要传给支付宝app的订单信息字符串
        String orderString = "";
        log.info("==================支付宝下单,商户订单号为："+orderTest.getOutTradeNo());

        //创建商户支付宝订单(因为需要记录每次支付宝支付的记录信息，单独存一个表跟商户订单表关联，以便以后查证)
        AliPaymentOrder aliPaymentOrder=new AliPaymentOrder();
        aliPaymentOrder.setClubOrderId(orderTest.getClubOrderId().toString());//商家订单主键
        aliPaymentOrder.setOutTradeNo(orderTest.getOutTradeNo());//商户订单号
        aliPaymentOrder.setTradeStatus((byte) 0);//交易状态
        aliPaymentOrder.setTotalAmount(BigDecimal.valueOf(Double.parseDouble(orderTest.getTotalAmount())));//订单金额
        aliPaymentOrder.setReceiptAmount(BigDecimal.ZERO);//实收金额
        aliPaymentOrder.setInvoiceAmount(BigDecimal.ZERO);//开票金额
        aliPaymentOrder.setBuyerPayAmount(BigDecimal.ZERO);//付款金额
        aliPaymentOrder.setRefundFee(BigDecimal.ZERO);	//总退款金额

        try{
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                    AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                    AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);

            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();

            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

            //业务参数传入,可以传很多，参考API
            //model.setPassbackParams(URLEncoder.encode(request.getBody().toString())); //公用参数（附加数据）
            model.setBody(orderTest.getBody());                       //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
            model.setSubject(orderTest.getSubject());                 //商品名称
            model.setOutTradeNo(orderTest.getOutTradeNo());           //商户订单号(自动生成)
            // model.setTimeoutExpress("30m");   			  //交易超时时间
            model.setTotalAmount(orderTest.getTotalAmount());         //支付金额
            model.setProductCode("QUICK_MSECURITY_PAY");        	  //销售产品码（固定值）
            ali_request.setBizModel(model);
//            log.info("====================异步通知的地址为："+alipayment.getNotifyUrl());
            ali_request.setNotifyUrl(AlipayConfig.notify_url);        //异步回调地址（后台）
            ali_request.setReturnUrl(AlipayConfig.return_url);	    //同步回调地址（APP）

            // 这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); //返回支付宝订单信息(预处理)
            orderString=alipayTradeAppPayResponse.getBody();//就是orderString 可以直接给APP请求，无需再做处理。
            this.createAlipayMentOrder(aliPaymentOrder);//创建新的商户支付宝订单

        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.info("与支付宝交互出错，未能生成订单，请检查代码！");
        }

        return orderString;
    }


    @Override
    public String notify(Map<String, String> conversionParams) {
        log.info("==================支付宝异步请求逻辑处理");

        //签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
        boolean signVerified = false;

        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(conversionParams, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);

        } catch (AlipayApiException e) {
            log.info("==================验签失败 ！");
            e.printStackTrace();
        }

        //对验签进行处理
        if (signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=conversionParams.get("app_id");//支付宝分配给开发者的应用Id
            String notifyTime=conversionParams.get("notify_time");//通知时间:yyyy-MM-dd HH:mm:ss
            String gmtCreate=conversionParams.get("gmt_create");//交易创建时间:yyyy-MM-dd HH:mm:ss
            String gmtPayment=conversionParams.get("gmt_payment");//交易付款时间
            String gmtRefund=conversionParams.get("gmt_refund");//交易退款时间
            String gmtClose=conversionParams.get("gmt_close");//交易结束时间
            String tradeNo=conversionParams.get("trade_no");//支付宝的交易号
            String outTradeNo = conversionParams.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String outBizNo=conversionParams.get("out_biz_no");//商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
            String buyerLogonId=conversionParams.get("buyer_logon_id");//买家支付宝账号
            String sellerId=conversionParams.get("seller_id");//卖家支付宝用户号
            String sellerEmail=conversionParams.get("seller_email");//卖家支付宝账号
            String totalAmount=conversionParams.get("total_amount");//订单金额:本次交易支付的订单金额，单位为人民币（元）
            String receiptAmount=conversionParams.get("receipt_amount");//实收金额:商家在交易中实际收到的款项，单位为元
            String invoiceAmount=conversionParams.get("invoice_amount");//开票金额:用户在交易中支付的可开发票的金额
            String buyerPayAmount=conversionParams.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = conversionParams.get("trade_status");// 获取交易状态

            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AliPaymentOrder aliPaymentOrder=this.selectByOutTradeNo(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(aliPaymentOrder!=null && totalAmount.equals(aliPaymentOrder.getTotalAmount().toString()) && AlipayConfig.APPID.equals(appId)){
                //执行业务操作
                //修改数据库支付宝订单表(因为要保存每次支付宝返回的信息到数据库里，以便以后查证)
                aliPaymentOrder.setNotifyTime(dateFormat(notifyTime));
                aliPaymentOrder.setGmtCreate(dateFormat(gmtCreate));
                aliPaymentOrder.setGmtPayment(dateFormat(gmtPayment));
                aliPaymentOrder.setGmtRefund(dateFormat(gmtRefund));
                aliPaymentOrder.setGmtClose(dateFormat(gmtClose));
                aliPaymentOrder.setTradeNo(tradeNo);
                aliPaymentOrder.setOutBizNo(outBizNo);
                aliPaymentOrder.setBuyerLogonId(buyerLogonId);
                aliPaymentOrder.setSellerId(sellerId);
                aliPaymentOrder.setSellerEmail(sellerEmail);
                aliPaymentOrder.setTotalAmount(BigDecimal.valueOf(Double.parseDouble(totalAmount)));
                aliPaymentOrder.setReceiptAmount(BigDecimal.valueOf(Double.parseDouble(receiptAmount)));
                aliPaymentOrder.setInvoiceAmount(BigDecimal.valueOf(Double.parseDouble(invoiceAmount)));
                aliPaymentOrder.setBuyerPayAmount(BigDecimal.valueOf(Double.parseDouble(buyerPayAmount)));
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        aliPaymentOrder.setTradeStatus((byte) 3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        aliPaymentOrder.setTradeStatus((byte) 2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        aliPaymentOrder.setTradeStatus((byte) 1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        aliPaymentOrder.setTradeStatus((byte) 0);
                        break;
                    default:
                        break;
                }
                int returnResult=this.updateByPrimaryKey(aliPaymentOrder);    //更新交易表中状态

                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        return "success";
                    }else{
                        return "fail";
                    }
                }else{
                    return "fail";
                }

            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }

        } else {  //验签不通过
            log.info("==================验签不通过 ！");
            return "fail";
        }

    }

    @Override
    public Byte checkAlipay(String outTradeNo) {
        log.info("==================向支付宝发起查询，查询商户订单号为："+outTradeNo);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                    AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                    AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+outTradeNo+"\"" +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询订单信息
                AliPaymentOrder alipaymentOrder=this.selectByOutTradeNo(outTradeNo);
                //修改数据库支付宝订单表
                alipaymentOrder.setTradeNo(alipayTradeQueryResponse.getTradeNo());//支付宝的交易号
                alipaymentOrder.setBuyerLogonId(alipayTradeQueryResponse.getBuyerLogonId());//买家支付宝账号
                alipaymentOrder.setTotalAmount(BigDecimal.valueOf(Double.parseDouble(alipayTradeQueryResponse.getTotalAmount())) );//订单金额
                alipaymentOrder.setReceiptAmount(BigDecimal.valueOf(Double.parseDouble(alipayTradeQueryResponse.getReceiptAmount())));//实收金额
                alipaymentOrder.setInvoiceAmount(BigDecimal.valueOf(Double.parseDouble(alipayTradeQueryResponse.getInvoiceAmount())));//开票金额
                alipaymentOrder.setBuyerPayAmount(BigDecimal.valueOf(Double.parseDouble(alipayTradeQueryResponse.getBuyerPayAmount())));//付款金额
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        alipaymentOrder.setTradeStatus((byte) 3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        alipaymentOrder.setTradeStatus((byte) 2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        alipaymentOrder.setTradeStatus((byte) 1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        alipaymentOrder.setTradeStatus((byte) 0);
                        break;
                    default:
                        break;
                }
                this.updateByPrimaryKey(alipaymentOrder); //更新表记录
                return alipaymentOrder.getTradeStatus(); //交易状态
            } else {
                log.info("==================调用支付宝查询接口失败！");
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    /**
     * 转换时间格式
     * @param notifyTime 字符串格式的时间
     * @return date格式的时间
     */
    private Date dateFormat(String notifyTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = null;
        try {
            parse = dateFormat.parse(notifyTime);
        } catch (ParseException e) {
            log.info("==================时间转换代码有误 ！");
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
     * @param outTradeNo 商户系统的唯一订单号
     * @return 支付宝订单信息
     */
    private AliPaymentOrder selectByOutTradeNo(String outTradeNo) {
        return alipayDao.selectByOutTradeNo(outTradeNo);
    }

    /**
     * 创建 数据库支付宝信息
     * @param aliPaymentOrder 支付宝订单
     */
    private void createAlipayMentOrder(AliPaymentOrder aliPaymentOrder) {
        alipayDao.createAlipayMentOrder(aliPaymentOrder);
    }

    /**
     * 根据主键修改 数据库支付宝信息
     * @param aliPaymentOrder 支付宝订单
     * @return 影响行数
     */
    private int updateByPrimaryKey(AliPaymentOrder aliPaymentOrder) {
        return alipayDao.updateByPrimaryKey(aliPaymentOrder);
    }

}
