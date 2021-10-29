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
import com.api.alipay.dao.AlipayDao;
import com.api.alipay.service.AlipayService;
import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.app.dao.butler.AppMeterReadingShareDetailsDao;
import com.api.app.dao.butler.AppReportRepairDao;
import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.common.GetOverdueFine;
import com.api.manage.dao.basicArchives.AuditManagementDao;
import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.manage.dao.butlerService.LeaseContractDao;
import com.api.manage.dao.butlerService.LeaseDao;
import com.api.manage.dao.butlerService.SysProcessRecordDao;
import com.api.model.alipay.*;
import com.api.model.app.*;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.basicArchives.CpmResidentEstate;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.SysLease;
import com.api.model.chargeManagement.DailyPaymentOrderList;
import com.api.model.chargeManagement.SysMeterReadingShareBillDetails;
import com.api.util.IdWorker;
import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLeaseContract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class AlipayServiceImpl implements AlipayService {
    // 获取配置文件中支付宝相关信息(可以使用自己的方式获取)
    @Value("${alipay.aliPayAppId}")
    private String ALIPAY_APP_ID;
    @Value("${alipay.rsaPrivatKey}")
    private String RSA_PRIVAT_KEY;
    @Value("${alipay.rsaAlipayPublicKey}")
    private String RSA_ALIPAY_PUBLIC_KEY;
    @Value("${alipay.notifyUrl}")
    private String NOTIFY_URL;
    @Value("${alipay.dailyPaymentNotifyUrl}")
    private String DAILY_PAYMENT_NOTIFY_URL;
    @Value("${alipay.reportRepairNotifyUrl}")
    private String REPORT_REPAIR_NOTIFY_URL;
    @Value("${alipay.shoppingNotifyUrl}")
    private String SHOPPING_NOTIFY_URL;
    @Value("${alipay.leaseNotifyUrl}")
    private String LEASE_NOTIFY_URL;
    @Value("${alipay.leaseRentOrderNotifyUrl}")
    private String LEASE_RENT_ORDER_NOTIFY_URL;
    @Value("${alipay.leaseRentBillOrderNotifyUrl}")
    private String LEASE_RENT_BILL_ORDER_NOTIFY_URL;
    @Value("${alipay.advancePaymentOrderNotifyUrl}")
    private String ADVANCE_PAYMENT_ORDER_NOTIFY_URL;
    @Value("${alipay.housekeepingServiceOrderNotifyUrl}")
    private String HOUSEKEEPING_SERVICE_ORDER_NOTIFY_URL;
    @Value("${alipay.meterReadingShareDetailsOrderNotifyUrl}")
    private String METER_READING_SHARE_DETAILS_ORDER_NOTIFY_URL;
    @Value("${alipay.returnUrl}")
    private String RETURN_URL;
    @Value("${alipay.aliPayGateway}")
    private String ALIPAY_GATEWAY;
    @Value("${alipay.signType}")
    private String SIGN_TYPE;
    @Value("${alipay.alipayFormat}")
    private String ALIPAY_FORMAT;
    @Value("${alipay.alipayCharset}")
    private String ALIPAY_CHARSET;
    @Resource
    AlipayDao alipayDao;
    @Resource
    AppDailyPaymentDao appDailyPaymentDao;
    @Resource
    AppReportRepairDao appReportRepairDao;
    @Resource
    SysProcessRecordDao sysProcessRecordDao;
    @Resource
    LeaseDao leaseDao;
    @Resource
    ShoppingDao shoppingDao;
    @Resource
    AuditManagementDao auditManagementDao;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;
    @Resource
    AppMeterReadingShareDetailsDao appMeterReadingShareDetailsDao;
    private static Map<String,Object> map = null;

//    /**
//     * 获取支付宝加签后台的订单信息字符串
//     * @param orderTest 测试订单
//     * @return map
//     */
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public String getAliPayOrderStr(OrderTest orderTest) {
//        //最终返回加签之后的，app需要传给支付宝app的订单信息字符串
//        String orderString = "";
//        log.info("==================支付宝下单,商户订单号为："+orderTest.getOutTradeNo());
//
//        //创建商户支付宝订单(因为需要记录每次支付宝支付的记录信息，单独存一个表跟商户订单表关联，以便以后查证)
//        AliPaymentOrder aliPaymentOrder=new AliPaymentOrder();
//        aliPaymentOrder.setClubOrderId(orderTest.getClubOrderId().toString());//商家订单主键
//        aliPaymentOrder.setOutTradeNo(orderTest.getOutTradeNo());//商户订单号
//        aliPaymentOrder.setTradeStatus((byte) 0);//交易状态
//        aliPaymentOrder.setTotalAmount(BigDecimal.valueOf(Double.parseDouble(orderTest.getTotalAmount())));//订单金额
//        aliPaymentOrder.setReceiptAmount(BigDecimal.ZERO);//实收金额
//        aliPaymentOrder.setInvoiceAmount(BigDecimal.ZERO);//开票金额
//        aliPaymentOrder.setBuyerPayAmount(BigDecimal.ZERO);//付款金额
//        aliPaymentOrder.setRefundFee(BigDecimal.ZERO);	//总退款金额
//
//        try{
//            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
//            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
//                    AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
//                    AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
//
//            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//            AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
//
//            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
//            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//
//            //业务参数传入,可以传很多，参考API
//            //model.setPassbackParams(URLEncoder.encode(request.getBody().toString())); //公用参数（附加数据）
//            model.setBody(orderTest.getBody());                       //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
//            model.setSubject(orderTest.getSubject());                 //商品名称
//            model.setOutTradeNo(orderTest.getOutTradeNo());           //商户订单号(自动生成)
//            // model.setTimeoutExpress("30m");   			  //交易超时时间
//            model.setTotalAmount(orderTest.getTotalAmount());         //支付金额
//            model.setProductCode("QUICK_MSECURITY_PAY");        	  //销售产品码（固定值）
//            ali_request.setBizModel(model);
////            log.info("====================异步通知的地址为："+alipayment.getNotifyUrl());
//            ali_request.setNotifyUrl(AlipayConfig.notify_url);        //异步回调地址（后台）
//            ali_request.setReturnUrl(AlipayConfig.return_url);	    //同步回调地址（APP）
//
//            // 这里和普通的接口调用不同，使用的是sdkExecute
//            AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); //返回支付宝订单信息(预处理)
//            orderString=alipayTradeAppPayResponse.getBody();//就是orderString 可以直接给APP请求，无需再做处理。
//            this.createAlipayMentOrder(aliPaymentOrder);//创建新的商户支付宝订单
//
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//            log.info("与支付宝交互出错，未能生成订单，请检查代码！");
//        }
//
//        return orderString;
//    }
//
//
//    @Override
//    public String notify(Map<String, String> conversionParams) {
//        log.info("==================支付宝异步请求逻辑处理");
//
//        //签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
//        boolean signVerified = false;
//
//        try {
//            //调用SDK验证签名
//            signVerified = AlipaySignature.rsaCheckV1(conversionParams, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
//
//        } catch (AlipayApiException e) {
//            log.info("==================验签失败 ！");
//            e.printStackTrace();
//        }
//
//        //对验签进行处理
//        if (signVerified) {
//            //验签通过
//            //获取需要保存的数据
//            String appId=conversionParams.get("app_id");//支付宝分配给开发者的应用Id
//            String notifyTime=conversionParams.get("notify_time");//通知时间:yyyy-MM-dd HH:mm:ss
//            String gmtCreate=conversionParams.get("gmt_create");//交易创建时间:yyyy-MM-dd HH:mm:ss
//            String gmtPayment=conversionParams.get("gmt_payment");//交易付款时间
//            String gmtRefund=conversionParams.get("gmt_refund");//交易退款时间
//            String gmtClose=conversionParams.get("gmt_close");//交易结束时间
//            String tradeNo=conversionParams.get("trade_no");//支付宝的交易号
//            String outTradeNo = conversionParams.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
//            String outBizNo=conversionParams.get("out_biz_no");//商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
//            String buyerLogonId=conversionParams.get("buyer_logon_id");//买家支付宝账号
//            String sellerId=conversionParams.get("seller_id");//卖家支付宝用户号
//            String sellerEmail=conversionParams.get("seller_email");//卖家支付宝账号
//            String totalAmount=conversionParams.get("total_amount");//订单金额:本次交易支付的订单金额，单位为人民币（元）
//            String receiptAmount=conversionParams.get("receipt_amount");//实收金额:商家在交易中实际收到的款项，单位为元
//            String invoiceAmount=conversionParams.get("invoice_amount");//开票金额:用户在交易中支付的可开发票的金额
//            String buyerPayAmount=conversionParams.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
//            String tradeStatus = conversionParams.get("trade_status");// 获取交易状态
//
//            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
//            AliPaymentOrder aliPaymentOrder=this.selectByOutTradeNo(outTradeNo);
//            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
//            if(aliPaymentOrder!=null && totalAmount.equals(aliPaymentOrder.getTotalAmount().toString()) && AlipayConfig.APPID.equals(appId)){
//                //执行业务操作
//                //修改数据库支付宝订单表(因为要保存每次支付宝返回的信息到数据库里，以便以后查证)
//                aliPaymentOrder.setNotifyTime(dateFormat(notifyTime));
//                aliPaymentOrder.setGmtCreate(dateFormat(gmtCreate));
//                aliPaymentOrder.setGmtPayment(dateFormat(gmtPayment));
//                aliPaymentOrder.setGmtRefund(dateFormat(gmtRefund));
//                aliPaymentOrder.setGmtClose(dateFormat(gmtClose));
//                aliPaymentOrder.setTradeNo(tradeNo);
//                aliPaymentOrder.setOutBizNo(outBizNo);
//                aliPaymentOrder.setBuyerLogonId(buyerLogonId);
//                aliPaymentOrder.setSellerId(sellerId);
//                aliPaymentOrder.setSellerEmail(sellerEmail);
//                aliPaymentOrder.setTotalAmount(BigDecimal.valueOf(Double.parseDouble(totalAmount)));
//                aliPaymentOrder.setReceiptAmount(BigDecimal.valueOf(Double.parseDouble(receiptAmount)));
//                aliPaymentOrder.setInvoiceAmount(BigDecimal.valueOf(Double.parseDouble(invoiceAmount)));
//                aliPaymentOrder.setBuyerPayAmount(BigDecimal.valueOf(Double.parseDouble(buyerPayAmount)));
//                switch (tradeStatus) // 判断交易结果
//                {
//                    case "TRADE_FINISHED": // 交易结束并不可退款
//                        aliPaymentOrder.setTradeStatus((byte) 3);
//                        break;
//                    case "TRADE_SUCCESS": // 交易支付成功
//                        aliPaymentOrder.setTradeStatus((byte) 2);
//                        break;
//                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
//                        aliPaymentOrder.setTradeStatus((byte) 1);
//                        break;
//                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
//                        aliPaymentOrder.setTradeStatus((byte) 0);
//                        break;
//                    default:
//                        break;
//                }
//                int returnResult=this.updateByPrimaryKey(aliPaymentOrder);    //更新交易表中状态
//
//                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
//                    if(returnResult>0){
//                        return "success";
//                    }else{
//                        return "fail";
//                    }
//                }else{
//                    return "fail";
//                }
//
//            }else{
//                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
//                return"fail";
//            }
//
//        } else {  //验签不通过
//            log.info("==================验签不通过 ！");
//            return "fail";
//        }
//
//    }


//    @Override
//    @Transactional
//    public Map<String,Object> alipay(AppDailyPaymentOrder appDailyPaymentOrder) {
//        map = new HashMap<>();
//        String body = "";
//        //模拟填写姓名
//        appDailyPaymentOrder.setName("张三");
//        //模拟填写手机号
//        appDailyPaymentOrder.setTel("1231241");
//
//
//        // 获取项目中实际的订单的信息
//        // 此处是相关业务代码
//        try {
//            //填写付款金额
//            appDailyPaymentOrder.setPayPrice(BigDecimal.valueOf(0.01));
//
//            //填写支付单号(自动生成订单号)
//            appDailyPaymentOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
//            //填写创建人 app为-1
//            appDailyPaymentOrder.setCreateId(-1);
//            //填入创建时间
//            appDailyPaymentOrder.setCreateDate(new Date());
//            //填入付款状态，0.交易创建并等待买家付款
//            appDailyPaymentOrder.setStatus(0);
//            //添加缴费订单信息
//            int i = appDailyPaymentDao.insertOrder(appDailyPaymentOrder);
//            if (i<=0){
//                throw new RuntimeException("添加缴费订单信息失败");
//            }
//
//            // 开始使用支付宝SDK中提供的API
//            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
//            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
//            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
//            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//            model.setBody("日常缴费测试支付");
//            model.setSubject("日常缴费");
//            // 唯一订单号 根据项目中实际需要获取相应的
//            model.setOutTradeNo(appDailyPaymentOrder.getCode());
//            // 支付超时时间（根据项目需要填写）
//            model.setTimeoutExpress("30m");
//            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
//            model.setTotalAmount(String.valueOf(appDailyPaymentOrder.getPayPrice()));
//            //app支付 固定值 填写QUICK_MSECURITY_PAY
//            model.setProductCode("QUICK_MSECURITY_PAY");
//            alipayRequest.setBizModel(model);
//            // 支付成功后支付宝异步通知的接收地址url
//            alipayRequest.setNotifyUrl(NOTIFY_URL);
//            //支付成功后支付宝同步通知的接收地址url（回跳地址）
////            alipayRequest.setReturnUrl(RETURN_URL);
//
//            // 注意：每个请求的相应对象不同，与请求对象是对应。
//            AlipayTradeAppPayResponse alipayResponse = null;
//            try {
//                alipayResponse = alipayClient.sdkExecute(alipayRequest);
//            } catch (AlipayApiException e) {
//                e.printStackTrace();
//                log.info("获取签名失败");
//                throw new RuntimeException("获取签名失败");
//            }
//            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
//            body = alipayResponse.getBody();
//
//        } catch (RuntimeException e) {
//            //获取抛出的信息
//            String message = e.getMessage();
//            e.printStackTrace();
//            //设置手动回滚
//            TransactionAspectSupport.currentTransactionStatus()
//                    .setRollbackOnly();
//            map.put("message",message);
//            map.put("status",false);
//            return map;
//        }
//        log.info("body:"+body);
//        map.put("message",body);
//        map.put("status",true);
//        return map;
//    }
//
//    @Override
//    public String getAlipayNotifyInfoOfCombinedPayment(HttpServletRequest request) {
//        //获取支付宝POST过来反馈信息
//        Map<String,String> params = new HashMap<>();
//        Map<String,String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//
//            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
//            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
//
//            params.put(name, valueStr);
//        }
//        boolean signVerified = false;
//        try {
//            //调用SDK验证签名
//            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
//            log.info("异步调用失败");
//
//            return "fail";
//        }
//        if(signVerified) {
//            //验签通过
//            //获取需要保存的数据
//            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
//            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
//            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
//            String tradeStatus = params.get("trade_status");// 获取交易状态
//            String tradeNo=params.get("trade_no");//支付宝的交易号
//            // 验证通知后执行自己项目需要的业务操作
//            // 一般需要判断支付状态是否为TRADE_SUCCESS
//            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
//            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
//            AppDailyPaymentOrder aliPaymentOrder = appDailyPaymentDao.findDailPaymentOrderByCode(outTradeNo);
//            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
//            if(aliPaymentOrder!=null && buyerPayAmount.equals(aliPaymentOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
//                aliPaymentOrder.setTradeNo(tradeNo);//填入支付宝的交易号
//                switch (tradeStatus) // 判断交易结果
//                {
//                    case "TRADE_FINISHED": // 交易结束并不可退款
//                        aliPaymentOrder.setStatus(3);
//                        break;
//                    case "TRADE_SUCCESS": // 交易支付成功
//                        aliPaymentOrder.setStatus(2);
//                        break;
//                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
//                        aliPaymentOrder.setStatus(1);
//                        break;
//                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
//                        aliPaymentOrder.setStatus(0);
//                        break;
//                    default:
//                        break;
//                }
//                //更新表的状态
//                int returnResult = appDailyPaymentDao.updateDPOrderStatusByCode(aliPaymentOrder);
//                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
//                    if(returnResult>0){
//                        log.info("异步调用成功");
//                        // 成功要返回success，不然支付宝会不断发送通知。
//                        return "success";
//                    }else{
//                        return "fail";
//                    }
//                }else{
//                    return "fail";
//                }
//            }else{
//                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
//                return"fail";
//            }
//        }else {
//            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
//            log.info("=========验签不通过！");
//
//            // 失败要返回fail，不然支付宝会不断发送通知。
//            return "fail";
//        }
//    }
//
//
//
//    @Override
//    public Integer checkAlipay(String outTradeNo) {
//        log.info("==================向支付宝发起查询，查询商户订单号为："+outTradeNo);
//
//        try {
//            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
//            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
//            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
//            alipayTradeQueryRequest.setBizContent("{" +
//                    "\"out_trade_no\":\""+outTradeNo+"\"" +
//                    "}");
//            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
//            if(alipayTradeQueryResponse.isSuccess()){
//                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
//                AppDailyPaymentOrder aliPaymentOrder = appDailyPaymentDao.findDailPaymentOrderByCode(outTradeNo);
//                //修改数据库支付宝订单表
//                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
//                {
//                    case "TRADE_FINISHED": // 交易结束并不可退款
//                        aliPaymentOrder.setStatus(3);
//                        break;
//                    case "TRADE_SUCCESS": // 交易支付成功
//                        aliPaymentOrder.setStatus(2);
//                        break;
//                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
//                        aliPaymentOrder.setStatus(1);
//                        break;
//                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
//                        aliPaymentOrder.setStatus(0);
//                        break;
//                    default:
//                        break;
//                }
//                //更新表的状态
//                appDailyPaymentDao.updateDPOrderStatusByCode(aliPaymentOrder);
//                return aliPaymentOrder.getStatus(); //交易状态
//            } else {
//                log.info("==================调用支付宝查询接口失败！");
//            }
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        return 0;
//
//    }

    @Override
    @Transactional
    public Map<String, Object> dailyPaymentAlipay(AppDailyPaymentOrder appDailyPaymentOrder) {
        map = new HashMap<>();
        String body = "";
        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            if (appDailyPaymentOrder.getIds() == null || appDailyPaymentOrder.getIds().length <= 0){
                throw new RuntimeException("未选择支付项");
            }

            //计算出所需支付总金额(总待缴金额+总滞纳金)
            BigDecimal paymentPrice = BigDecimal.ZERO;//初始支付总金额

            List<AppDailyPaymentDetailsVo> appDailyPaymentDetailsVos = appDailyPaymentDao.findDailyPaymentByIds(appDailyPaymentOrder);
            if (appDailyPaymentDetailsVos != null && appDailyPaymentDetailsVos.size()>0){
                for (AppDailyPaymentDetailsVo appDailyPaymentDetailsVo : appDailyPaymentDetailsVos) {

                    //计算滞纳金
                    appDailyPaymentDetailsVo = GetOverdueFine.getAppOverdueFine(appDailyPaymentDetailsVo);

                    paymentPrice = paymentPrice.add(appDailyPaymentDetailsVo.getPaymentPrice());//增加待缴金额
                    paymentPrice = paymentPrice.add(appDailyPaymentDetailsVo.getOverdueFine());//增加滞纳金

                }
            }

            log.info("需支付金额为："+paymentPrice+"，实际支付金额为:"+appDailyPaymentOrder.getPayPrice());

            if (paymentPrice.compareTo(appDailyPaymentOrder.getPayPrice()) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }
            if (paymentPrice.compareTo(BigDecimal.ZERO) == 0){
                throw new RuntimeException("支付金额不可为0");
            }
            //填写付款金额
            appDailyPaymentOrder.setPayPrice(paymentPrice);

            //填写支付单号(自动生成订单号)
            appDailyPaymentOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人 app为-1
            appDailyPaymentOrder.setCreateId(-1);
            //填入创建时间
            appDailyPaymentOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            appDailyPaymentOrder.setStatus(0);
            //添加缴费订单信息
            int i = appDailyPaymentDao.insertOrder(appDailyPaymentOrder);
            if (i<=0){
                throw new RuntimeException("添加缴费订单信息失败");
            }
            //获取所有的缴费主键id
            int[] ids = appDailyPaymentOrder.getIds();
            for (int id : ids) {
                //添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
                DailyPaymentOrderList dailyPaymentOrderList = new DailyPaymentOrderList();
                dailyPaymentOrderList.setDailyPaymentId(id);
                dailyPaymentOrderList.setDailyPaymentOrderId(appDailyPaymentOrder.getId());
                //根据缴费主键id查询当前缴费信息的缴费金额
                BigDecimal dailyPaymentPrice = appDailyPaymentDao.findDailPaymentPriceById(id);
                dailyPaymentOrderList.setDailyPaymentPrice(dailyPaymentPrice);
                int orderList = appDailyPaymentDao.insertOrderList(dailyPaymentOrderList);
                if (orderList <= 0){
                    throw new RuntimeException("添加缴费订单清单信息失败");
                }
            }

            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("日常缴费app支付");
            model.setSubject("日常缴费");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(appDailyPaymentOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(appDailyPaymentOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(DAILY_PAYMENT_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    public String dailyPaymentNotifyInfo(HttpServletRequest request) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            log.info("验签通过");
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            log.info("获取数据：app_id="+appId+",out_trade_no="+outTradeNo+",buyer_pay_amount="+buyerPayAmount+",trade_status="+tradeStatus);
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppDailyPaymentOrder aliPaymentOrder = appDailyPaymentDao.findDailPaymentOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(aliPaymentOrder!=null && buyerPayAmount.equals(aliPaymentOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        aliPaymentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        aliPaymentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        aliPaymentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        aliPaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = appDailyPaymentDao.updateDPOrderStatusByCode(aliPaymentOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据缴费订单支付单号查询缴费信息主键id
                        List<AppDailyPaymentDetailsVo> appDailyPaymentDetailsVos = appDailyPaymentDao.findDailyPaymentIdsByOrderCode(outTradeNo);
                        if (appDailyPaymentDetailsVos != null && appDailyPaymentDetailsVos.size()>0){
                            for (AppDailyPaymentDetailsVo appDailyPaymentDetailsVo : appDailyPaymentDetailsVos) {

                                //计算滞纳金
                                appDailyPaymentDetailsVo = GetOverdueFine.getAppOverdueFine(appDailyPaymentDetailsVo);

                                //添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额和滞纳金，并修改状态
                                int update = appDailyPaymentDao.updatePaidPAndPaymentPAndOverdueFine(appDailyPaymentDetailsVo);
                                if (update <= 0){
                                    log.info("===========更新缴费信息的状态失败");
                                    log.info("data:"+appDailyPaymentDetailsVo.toString());
                                    return "fail";
                                }
                            }
                        }
                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String,Object> dailyPaymentCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================日常缴费向支付宝发起查询，查询商户订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                AppDailyPaymentOrder aliPaymentOrder = appDailyPaymentDao.findDailPaymentOrderByCode(code);
                if (aliPaymentOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        aliPaymentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        aliPaymentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        aliPaymentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        aliPaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                appDailyPaymentDao.updateDPOrderStatusByCode(aliPaymentOrder);
                map.put("status",aliPaymentOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> reportRepairAlipay(AppRepairOrder appRepairOrder) {
        map = new HashMap<>();
        String body = "";
        try {
            //创建报事报修初始订单信息
            createRepairOrder(appRepairOrder);

            //执行支付宝操作
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("报事报修支付");
            model.setSubject("报事报修");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(appRepairOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(appRepairOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(REPORT_REPAIR_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容[就是orderString]直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();
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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    public String reportRepairNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppRepairOrder appRepairOrder = appReportRepairDao.findRepairOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(appRepairOrder!=null && buyerPayAmount.equals(appRepairOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        appRepairOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        appRepairOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        appRepairOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        appRepairOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = appReportRepairDao.updateDPOrderStatusByCode(appRepairOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");

                        UserIdAndRepairId userIdAndRepairId = new UserIdAndRepairId();
                        userIdAndRepairId.setId(userId);
                        userIdAndRepairId.setRepairId(appRepairOrder.getReportRepairId());
                        //异步检测成功，添加成功后对应的数据
                        //用户确认完成订单，改变报修单状态为 5.已确认已完成
                        int update = appReportRepairDao.completeOrder(userIdAndRepairId);
                        if (update <= 0){
                            log.info("===========用户确认完成订单失败");
                            return "fail";
                        }
                        //根据用户id和报事报修主键id 查询派工单id
                        int dispatchListId = appReportRepairDao.findDispatchListIdByIds(userIdAndRepairId);
                        //添加处理进程记录
                        ProcessRecord processRecord = new ProcessRecord();
                        //填入派工单id
                        processRecord.setDispatchListId(dispatchListId);
                        //填入操作时间（数据创建时间）
                        processRecord.setOperationDate(new Date());
                        //填入操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
                        processRecord.setOperationType(5);
                        //填入操作人（取自住户表或物业表）
                        processRecord.setOperator(userIdAndRepairId.getId());
                        //填入操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
                        processRecord.setOperatorType(1);
                        //填入操作内容
                        processRecord.setOperatorContent(userName+"确认了订单");
                        int insert3 = sysProcessRecordDao.insert(processRecord);
                        if (insert3 <= 0){
                            log.info("===========添加处理进程记录失败");
                            return "fail";
                        }
                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> reportRepairCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================报事报修向支付宝发起查询，查询商户订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                AppRepairOrder appRepairOrder = appReportRepairDao.findRepairOrderByCode(code);
                if (appRepairOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        appRepairOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        appRepairOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        appRepairOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        appRepairOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                appReportRepairDao.updateDPOrderStatusByCode(appRepairOrder);
                map.put("status",appRepairOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> shoppingAlipay(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id) {
        map = new HashMap<>();
        String body = "";
        try {
            if (type == 4){//4.游客
                throw new RuntimeException("您的身份为游客，不可进行此操作");
            }
            //查询该用户是否有报名该商品
//            AppGoodsIdAndUserId goodsIdAndUserId = new AppGoodsIdAndUserId();
//            goodsIdAndUserId.setUserId(id);
//            goodsIdAndUserId.setGoodsId(appGoodsAppointment.getGoodsId());
//            int count = shoppingDao.countAppointmentByGIdAndUId(goodsIdAndUserId);
//            if (count >0){
//                throw new RuntimeException("您已预约成功，不可进行再次进行该操作");
//            }

            //创建报事报修初始订单信息
            createShoppingOrder(appGoodsAppointment,id);

            //执行支付宝操作
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("商城购物支付");
            model.setSubject("商城购物");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(appGoodsAppointment.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(appGoodsAppointment.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(SHOPPING_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容[就是orderString]直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();
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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }


    @Override
    public String shoppingNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppGoodsAppointment appGoodsAppointment = shoppingDao.findGoodsOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(appGoodsAppointment!=null && buyerPayAmount.equals(appGoodsAppointment.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        appGoodsAppointment.setStatus(15);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        appGoodsAppointment.setStatus(1);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        appGoodsAppointment.setStatus(-1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        appGoodsAppointment.setStatus(-2);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult =  shoppingDao.updateSGAStatusByCode(appGoodsAppointment);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> shoppingCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================商城向支付宝发起查询，查询商户订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                AppGoodsAppointment goodsOrderByCode = shoppingDao.findGoodsOrderByCode(code);
                if (goodsOrderByCode == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        goodsOrderByCode.setStatus(15);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        goodsOrderByCode.setStatus(1);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        goodsOrderByCode.setStatus(-1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        goodsOrderByCode.setStatus(-2);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                shoppingDao.updateSGAStatusByCode(goodsOrderByCode);
                switch (goodsOrderByCode.getStatus()){
                    case 15:
                        map.put("status",3);
                        break;
                    case 1:
                        map.put("status",2);
                        break;
                    case -1:
                        map.put("status",1);
                        break;
                    case -2:
                        map.put("status",0);
                        break;
                }
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> leaseAlipay(SysLeaseOrder sysLeaseOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            //根据租赁管理主键id查询租赁信息
            VoFBILease byId = leaseDao.findById(sysLeaseOrder.getSysLeaseId());
            BigDecimal paymentPrice = byId.getMargin();
            if (paymentPrice.compareTo(sysLeaseOrder.getPayPrice()) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }
            if (paymentPrice.equals(BigDecimal.ZERO)){
                throw new RuntimeException("支付金额不可为0");
            }
            log.info("开始填写支付宝订单信息");
            //填写付款金额
            sysLeaseOrder.setPayPrice(paymentPrice);

            //填写支付单号(自动生成订单号)
            sysLeaseOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人 app为-1
            sysLeaseOrder.setCreateId(-1);
            //填入创建时间
            sysLeaseOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            sysLeaseOrder.setStatus(0);
            //添加缴费订单信息
            int i = leaseDao.insertOrder(sysLeaseOrder);
            if (i<=0){
                throw new RuntimeException("添加缴费订单信息失败");
            }
            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("房屋租赁app支付");
            model.setSubject("房屋租赁");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(sysLeaseOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(sysLeaseOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(LEASE_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public String leaseNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseOrder sysLeaseOrder = leaseDao.findSysLeaseOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysLeaseOrder!=null && buyerPayAmount.equals(sysLeaseOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseOrderStatusByCode(sysLeaseOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据租赁主键id更新租赁信息状态
                        SysLease sysLease = new SysLease();
                        sysLease.setId(sysLeaseOrder.getSysLeaseId());
                        sysLease.setStatus(6);//6.已完成
                        //修改状态
                        int update = leaseDao.updateStatusById(sysLease);
                        if (update <= 0){
                            log.info("===========更新租赁信息的状态失败");
                            return "fail";
                        }
                        //修改保证金缴纳时间
                        sysLease.setMarginPayDate(new Date());
                        int update4 = leaseDao.updateMarginPayDateById(sysLease);
                        if (update4 <= 0){
                            log.info("===========更新租赁信息的保证金缴纳时间失败");
                            return "fail";
                        }

                        try {
                            //根据租赁管理主键id查询租赁信息
                            VoFBILease byId = leaseDao.findById(sysLeaseOrder.getSysLeaseId());

                            //更新上一份租赁信息的状态
                            if (byId.getLeaseParentId() > 0){//正整数：续签
                                SysLease sysLease2 = new SysLease();
                                sysLease2.setId(byId.getLeaseParentId());
                                sysLease2.setStatus(21);//21.已续签
                                //修改状态
                                int update2 = leaseDao.updateStatusById(sysLease2);
                                if (update2 <= 0){
                                    log.info("===========更新上一份租赁信息的状态失败");
                                    return "fail";
                                }
                            }else if (byId.getLeaseParentId() < 0){//负正数：变更
                                SysLease sysLease3 = new SysLease();
                                sysLease3.setId(Math.abs(byId.getLeaseParentId()));
                                sysLease3.setStatus(31);//31.已变更
                                //修改状态
                                int update3 = leaseDao.updateStatusById(sysLease3);
                                if (update3 <= 0){
                                    log.info("===========更新上一份租赁信息的状态失败");
                                    return "fail";
                                }
                            }//0：新合同


                            //关联房屋信息
                            //添加住户房产关联表 TODO 住户房产关联表增加一个字段，【type用户类型】
                            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                            cpmResidentEstate.setBuildingUnitEstateId(byId.getEstateId()); //填入房产id
                            //根据用户手机号查询用户主键id
                            UserResident userResidentByTel = userResidentDao.findByTel(byId.getTel());
                            cpmResidentEstate.setResidentId(userResidentByTel.getId()); //填入住户id
                            cpmResidentEstate.setEffectiveTimeStart(byId.getLeaseDateStart()); //填入有效时间开始（只限租客）
                            cpmResidentEstate.setEffectiveTimeEnd(byId.getLeaseDateEnd()); //填入有效时间结束（只限租客）
                            cpmResidentEstate.setSysLeaseId(byId.getId());//填入租赁主键id（只限租客）
                            int insert = auditManagementDao.insertResidentEstate(cpmResidentEstate);
                            if (insert <=0){
                                throw new RuntimeException("===========添加住户房产关联失败");
                            }

                            //更新房产的状态信息
                            CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();
                            cpmBuildingUnitEstate.setId(byId.getEstateId()); //填入房产id
                            //租客，5.已租
                            cpmBuildingUnitEstate.setStatus(5);
                            int update2 = auditManagementDao.updateEstateStatus(cpmBuildingUnitEstate);
                            if (update2 <= 0){
                                throw new RuntimeException("===========房产状态更新失败");
                            }

                            //修改住户类型信息 TODO 用户表减少一个字段，【type用户类型】
                            UserResident userResident = new UserResident();
                            userResident.setId(userResidentByTel.getId());//填入用户主键id
                            userResident.setType(3); //填入住户类型,3.租户
                            int update3 = auditManagementDao.updateResidentTypeById(userResident);
                            if (update3 <=0){
                                throw new RuntimeException("===========住户信息修改失败");
                            }
                        } catch (Exception e) {
                            //获取抛出的信息
                            String message = e.getMessage();
                            e.printStackTrace();
                            //设置手动回滚
                            TransactionAspectSupport.currentTransactionStatus()
                                    .setRollbackOnly();
                            log.info(message);
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> leaseCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================房屋租赁向支付宝发起查询，查询商户保证金订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                SysLeaseOrder sysLeaseOrder = leaseDao.findSysLeaseOrderByCode(code);
                if (sysLeaseOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                leaseDao.updateLeaseOrderStatusByCode(sysLeaseOrder);
                map.put("status",sysLeaseOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> leaseRentOrderAlipay(SysLeaseRentOrder sysLeaseRentOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            //根据租赁管理主键id查询租赁信息
            VoFBILease byId = leaseDao.findById(sysLeaseRentOrder.getSysLeaseId());
            BigDecimal paymentPrice = byId.getRequiredRent();
            if (paymentPrice.compareTo(sysLeaseRentOrder.getPayPrice()) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }
            if (paymentPrice.equals(BigDecimal.ZERO)){
                throw new RuntimeException("支付金额不可为0");
            }
            log.info("开始填写支付宝订单信息");
            //填写付款金额
            sysLeaseRentOrder.setPayPrice(paymentPrice);

            //填写支付单号(自动生成订单号)
            sysLeaseRentOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人 app为-1
            sysLeaseRentOrder.setCreateId(-1);
            //填入创建时间
            sysLeaseRentOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            sysLeaseRentOrder.setStatus(0);
            //添加缴费订单信息
            int i = leaseDao.insertRentOrder(sysLeaseRentOrder);
            if (i<=0){
                throw new RuntimeException("添加缴费订单信息失败");
            }
            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("房屋租赁剩余需结清租金app支付");
            model.setSubject("房屋剩余需结清租金");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(sysLeaseRentOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(sysLeaseRentOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(LEASE_RENT_ORDER_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public String leaseRentOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseRentOrder sysLeaseRentOrder = leaseDao.findSysLeaseRentOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysLeaseRentOrder!=null && buyerPayAmount.equals(sysLeaseRentOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseRentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseRentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseRentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseRentOrderStatusByCode(sysLeaseRentOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据租赁主键id更新租赁信息状态
                        SysLease sysLease = new SysLease();
                        sysLease.setId(sysLeaseRentOrder.getSysLeaseId());
                        sysLease.setStatus(14);//14.已支付剩余租金
                        int update = leaseDao.updateStatusById(sysLease);
                        if (update <= 0){
                            log.info("===========更新租赁信息的状态失败");
                            return "fail";
                        }

                        //将当前租赁租金账单所有的未缴纳的租金改为已结算状态
                        int update2 = leaseDao.updateSLRStatusUnPayToSettledBySLId(sysLeaseRentOrder.getSysLeaseId());
                        if (update2 <= 0){
                            log.info("===========将当前租赁租金账单所有的未缴纳的租金改为已结算状态失败");
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> leaseRentOrderCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================房屋租赁向支付宝发起查询，查询商户剩余需结清租金订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                SysLeaseRentOrder sysLeaseRentOrder = leaseDao.findSysLeaseRentOrderByCode(code);
                if (sysLeaseRentOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseRentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseRentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseRentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                leaseDao.updateLeaseRentOrderStatusByCode(sysLeaseRentOrder);
                map.put("status",sysLeaseRentOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> leaseRentBillOrderAlipay(SysLeaseRentBillOrder sysLeaseRentBillOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            //根据租赁账单管理主键id查询租赁账单信息
            AppLeaseRent byId = leaseDao.findLeaseRentById(sysLeaseRentBillOrder.getSysLeaseRentId());
            BigDecimal paymentPrice = byId.getPrice();
            if (paymentPrice.compareTo(sysLeaseRentBillOrder.getPayPrice()) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }
            if (paymentPrice.equals(BigDecimal.ZERO)){
                throw new RuntimeException("支付金额不可为0");
            }
            log.info("开始填写支付宝订单信息");
            //填写付款金额
            sysLeaseRentBillOrder.setPayPrice(paymentPrice);

            //填写支付单号(自动生成订单号)
            sysLeaseRentBillOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人 app为-1
            sysLeaseRentBillOrder.setCreateId(-1);
            //填入创建时间
            sysLeaseRentBillOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            sysLeaseRentBillOrder.setStatus(0);
            //添加租赁租金账单订单信息
            int i = leaseDao.insertRentBillOrder(sysLeaseRentBillOrder);
            if (i<=0){
                throw new RuntimeException("添加租赁租金账单订单信息失败");
            }
            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("房屋租赁租金账单app支付");
            model.setSubject("房屋租赁租金账单");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(sysLeaseRentBillOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(sysLeaseRentBillOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(LEASE_RENT_BILL_ORDER_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public String leaseRentBillOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseRentBillOrder sysLeaseRentBillOrder = leaseDao.findSysLeaseRentBillOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysLeaseRentBillOrder!=null && buyerPayAmount.equals(sysLeaseRentBillOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseRentBillOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseRentBillOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentBillOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseRentBillOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseRentBillOrderStatusByCode(sysLeaseRentBillOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据租赁账单主键id更新租赁账单信息状态
                        AppLeaseRent appLeaseRent = new AppLeaseRent();
                        appLeaseRent.setId(sysLeaseRentBillOrder.getSysLeaseRentId());
                        appLeaseRent.setStatus(1);//1.已缴纳
                        int update = leaseDao.updateLeaseRentStatusById(appLeaseRent);
                        if (update <= 0){
                            log.info("===========更新租赁账单信息的状态失败");
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> leaseRentBillOrderCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================房屋租赁向支付宝发起查询，查询商户租金账单订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
                SysLeaseRentBillOrder sysLeaseRentBillOrder = leaseDao.findSysLeaseRentBillOrderByCode(code);
                if (sysLeaseRentBillOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysLeaseRentBillOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysLeaseRentBillOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentBillOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysLeaseRentBillOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                leaseDao.updateLeaseRentBillOrderStatusByCode(sysLeaseRentBillOrder);
                map.put("status",sysLeaseRentBillOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> advancePaymentOrderAlipay(SysAdvancePaymentOrder sysAdvancePaymentOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            BigDecimal paymentPrice = sysAdvancePaymentOrder.getPayPrice();

            if (paymentPrice.compareTo(BigDecimal.ZERO) <= 0){
                throw new RuntimeException("支付金额小于或等于0");
            }
            log.info("开始填写支付宝订单信息");

            //填写支付单号(自动生成订单号)
            sysAdvancePaymentOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人
            sysAdvancePaymentOrder.setCreateId(id);
            //填入创建时间
            sysAdvancePaymentOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            sysAdvancePaymentOrder.setStatus(0);
            //添加生活缴费-预充值支付订单信息
            int i = alipayDao.insertAdvancePaymentOrder(sysAdvancePaymentOrder);
            if (i<=0){
                throw new RuntimeException("添加生活缴费-预充值支付订单信息失败");
            }
            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("生活缴费-预充值支付");
            model.setSubject("生活缴费-预充值账单");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(sysAdvancePaymentOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(sysAdvancePaymentOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(ADVANCE_PAYMENT_ORDER_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public String advancePaymentOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
            SysAdvancePaymentOrder sysAdvancePaymentOrder = alipayDao.findSysAdvancePaymentOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysAdvancePaymentOrder!=null && buyerPayAmount.equals(sysAdvancePaymentOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysAdvancePaymentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysAdvancePaymentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysAdvancePaymentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysAdvancePaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateAdvancePaymentOrderStatusByCode(sysAdvancePaymentOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据充值房产主键id查询预付款充值金额
                        BigDecimal advancePaymentPrice = alipayDao.findAPPByEstateId(sysAdvancePaymentOrder.getEstateId());

                        EstateIdAndAdvancePaymentPrice estateIdAndAPPrice = new EstateIdAndAdvancePaymentPrice();

                        //根据房产主键id修改预付款充值金额
                        if (advancePaymentPrice != null){
                            advancePaymentPrice = advancePaymentPrice.add(sysAdvancePaymentOrder.getPayPrice());
                        }else {
                            advancePaymentPrice = sysAdvancePaymentOrder.getPayPrice();
                        }

                        estateIdAndAPPrice.setAdvancePaymentPrice(advancePaymentPrice);
                        estateIdAndAPPrice.setEstateId(sysAdvancePaymentOrder.getEstateId());

                        //根据充值房产主键id修改预付款充值金额
                        int update = alipayDao.updateAdvancePaymentPriceByEstateId(estateIdAndAPPrice);
                        if (update <= 0){
                            log.info("===========更新房产的预付款充值金额失败");
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> advancePaymentOrderCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================生活缴费-预充值支付向支付宝发起查询，查询预充值支付订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
                SysAdvancePaymentOrder sysAdvancePaymentOrder = alipayDao.findSysAdvancePaymentOrderByCode(code);
                if (sysAdvancePaymentOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysAdvancePaymentOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysAdvancePaymentOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysAdvancePaymentOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysAdvancePaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                alipayDao.updateAdvancePaymentOrderStatusByCode(sysAdvancePaymentOrder);
                map.put("status",sysAdvancePaymentOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> housekeepingServiceOrderAlipay(SysHousekeepingServiceOrder sysHousekeepingServiceOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            BigDecimal paymentPrice = sysHousekeepingServiceOrder.getPayPrice();

            if (paymentPrice.compareTo(BigDecimal.ZERO) <= 0){
                throw new RuntimeException("支付金额小于或等于0");
            }

            AppHousekeepingService byId = appHousekeepingServiceDao.findHousekeepingServiceById(sysHousekeepingServiceOrder.getHousekeepingServiceId());
            if (byId.getPayFee().compareTo(sysHousekeepingServiceOrder.getPayPrice()) != 0){
                throw new RuntimeException("输入金额与需支付金额不一致");
            }


            log.info("开始填写支付宝订单信息");

            //填写支付单号(自动生成订单号)
            sysHousekeepingServiceOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人
            sysHousekeepingServiceOrder.setCreateId(id);
            //填入创建时间
            sysHousekeepingServiceOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            sysHousekeepingServiceOrder.setStatus(0);
            //添加家政服务-服务费用支付订单信息
            int i = alipayDao.insertHousekeepingServiceOrder(sysHousekeepingServiceOrder);
            if (i<=0){
                throw new RuntimeException("添加家政服务-服务费用支付订单信息失败");
            }
            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("家政服务-服务费用支付");
            model.setSubject("家政服务-服务费用账单");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(sysHousekeepingServiceOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(sysHousekeepingServiceOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(HOUSEKEEPING_SERVICE_ORDER_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public String housekeepingServiceOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
            SysHousekeepingServiceOrder sysHousekeepingServiceOrder = alipayDao.findSysHousekeepingServiceOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysHousekeepingServiceOrder!=null && buyerPayAmount.equals(sysHousekeepingServiceOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        sysHousekeepingServiceOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        sysHousekeepingServiceOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysHousekeepingServiceOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        sysHousekeepingServiceOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateHousekeepingServiceOrderStatusByCode(sysHousekeepingServiceOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        AppHousekeepingService appHousekeepingService = new AppHousekeepingService();
                        appHousekeepingService.setId(sysHousekeepingServiceOrder.getHousekeepingServiceId());
                        appHousekeepingService.setStatus(5);//填入5.待评价

                        int update = appHousekeepingServiceDao.updateStatusById(appHousekeepingService);
                        if (update <= 0){
                            log.info("===========更新家新版政服务的状态失败");
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> housekeepingServiceOrderCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================家政服务-服务费用支付向支付宝发起查询，查询家政服务-服务费用支付订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
                SysHousekeepingServiceOrder housekeepingServiceOrder = alipayDao.findSysHousekeepingServiceOrderByCode(code);
                if (housekeepingServiceOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        housekeepingServiceOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        housekeepingServiceOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        housekeepingServiceOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        housekeepingServiceOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                alipayDao.updateHousekeepingServiceOrderStatusByCode(housekeepingServiceOrder);
                map.put("status",housekeepingServiceOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> meterReadingShareDetailsOrderAlipay(SysMeterReadingShareDetailsOrder shareDetailsOrder, Integer id) {
        log.info("开始生成支付宝订单");
        map = new HashMap<>();
        String body = "";

        // 获取项目中实际的订单的信息
        // 此处是相关业务代码
        try {
            BigDecimal paymentPrice = shareDetailsOrder.getPayPrice();

            if (paymentPrice.compareTo(BigDecimal.ZERO) <= 0){
                throw new RuntimeException("支付金额小于或等于0");
            }

            //计算出所需支付总金额(总待缴金额+总滞纳金)
            BigDecimal paymentPriceTotal = BigDecimal.ZERO;//初始支付总金额


            List<SysMeterReadingShareBillDetails> shareBillDetailsList = appMeterReadingShareDetailsDao.findShareDetailsByIds(shareDetailsOrder);
            if (shareBillDetailsList != null && shareBillDetailsList.size()>0){
                for (SysMeterReadingShareBillDetails shareBillDetails : shareBillDetailsList) {
                    //获取滞纳金金额
                    BigDecimal lateFee = getLateFee(shareBillDetails);

                    paymentPriceTotal = paymentPriceTotal.add(shareBillDetails.getRemainingUnpaidAmount());//增加待缴金额
                    paymentPriceTotal = paymentPriceTotal.add(lateFee);//增加滞纳金

                }
            }
            log.info("需支付金额为："+paymentPriceTotal+"，实际支付金额为:"+paymentPrice);

            if (paymentPriceTotal.compareTo(paymentPrice) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }


            log.info("开始填写支付宝订单信息");

            //填写支付单号(自动生成订单号)
            shareDetailsOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            //填写创建人
            shareDetailsOrder.setCreateId(id);
            //填入创建时间
            shareDetailsOrder.setCreateDate(new Date());
            //填入付款状态，0.交易创建并等待买家付款
            shareDetailsOrder.setStatus(0);
            //添加抄表记录管理-抄表分摊详情费用支付订单信息
            int i = alipayDao.insertShareDetailsOrder(shareDetailsOrder);
            if (i<=0){
                throw new RuntimeException("添加抄表记录管理-抄表分摊详情费用支付订单信息失败");
            }
            //获取所有抄表公摊详情主键id
            int[] shareDetailsIds = shareDetailsOrder.getShareDetailsIds();
            for (int shareDetailsId : shareDetailsIds) {
                //添加抄表公摊订单清单信息（抄表公摊详情信息 与 抄表公摊订单信息 关联表）
                SysMeterReadingShareDetailsOrderList orderList = new SysMeterReadingShareDetailsOrderList();
                orderList.setMeterShareOrderId(shareDetailsOrder.getId());
                orderList.setMeterShareDetailsId(shareDetailsId);
                //根据抄表公摊详情主键id查询当抄表公摊详情信息的缴费金额
                SysMeterReadingShareBillDetails shareDetailsById = appMeterReadingShareDetailsDao.findShareDetailsById(shareDetailsId);
                BigDecimal lateFee2 = getLateFee(shareDetailsById);
                orderList.setPayPrice(shareDetailsById.getRemainingUnpaidAmount().add(lateFee2));
                int insert = appMeterReadingShareDetailsDao.insertOrderList(orderList);
                if (insert <= 0){
                    throw new RuntimeException("添加抄表分摊订单清单信息失败");
                }
            }


            log.info("开始调用支付宝接口");
            // 开始使用支付宝SDK中提供的API
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            // 注意：不同接口这里的请求对象是不同的，这个可以查看蚂蚁金服开放平台的API文档查看
            AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("抄表记录管理-抄表分摊详情费用支付");
            model.setSubject("抄表记录管理-抄表分摊详情费用账单");
            // 唯一订单号 根据项目中实际需要获取相应的
            model.setOutTradeNo(shareDetailsOrder.getCode());
            // 支付超时时间（根据项目需要填写）
            model.setTimeoutExpress("30m");
            // 支付金额（项目中实际订单的需要支付的金额，金额的获取与操作请放在服务端完成，相对安全）
            model.setTotalAmount(String.valueOf(shareDetailsOrder.getPayPrice()));
            //app支付 固定值 填写QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            alipayRequest.setBizModel(model);
            // 支付成功后支付宝异步通知的接收地址url
            alipayRequest.setNotifyUrl(METER_READING_SHARE_DETAILS_ORDER_NOTIFY_URL);
            //支付成功后支付宝同步通知的接收地址url（回跳地址）
//            alipayRequest.setReturnUrl(RETURN_URL);

            // 注意：每个请求的相应对象不同，与请求对象是对应。
            AlipayTradeAppPayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.sdkExecute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.info("获取签名失败");
                throw new RuntimeException("获取签名失败");
            }
            // 返回支付相关信息(此处可以直接将getBody中的内容直接返回，无需再做一些其他操作)
            body = alipayResponse.getBody();

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
        log.info("body:"+body);
        map.put("message",body);
        map.put("status",true);
        return map;
    }


    @Override
    @Transactional
    public String meterReadingShareDetailsOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId) {
        log.info("开始异步调用");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 官方demo中使用如下方式解决中文乱码，在此本人不推荐使用，可能会出现中文乱码解决无效的问题。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");

            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, RSA_ALIPAY_PUBLIC_KEY, ALIPAY_CHARSET, SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签异常  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("异步调用失败");
            return "fail";
        }
        if(signVerified) {
            //验签通过
            //获取需要保存的数据
            String appId=params.get("app_id");//支付宝分配给开发者的应用Id
            String outTradeNo = params.get("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=params.get("buyer_pay_amount");//付款金额:用户在交易中支付的金额
            String tradeStatus = params.get("trade_status");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
            SysMeterReadingShareDetailsOrder shareDetailsOrder = alipayDao.findShareDetailsOrderOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(shareDetailsOrder!=null && buyerPayAmount.equals(shareDetailsOrder.getPayPrice().toString()) && ALIPAY_APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        shareDetailsOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        shareDetailsOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        shareDetailsOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        shareDetailsOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateShareDetailsOrderStatusByCode(shareDetailsOrder);
                if(tradeStatus.equals("TRADE_SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据抄表分摊订单支付单号查询抄表分摊详情信息
                        List<SysMeterReadingShareBillDetails> meterReadingShareBillDetails = appMeterReadingShareDetailsDao.findShareBillDetailsByOrderCode(outTradeNo);
                        if (meterReadingShareBillDetails != null && meterReadingShareBillDetails.size()>0){
                            for (SysMeterReadingShareBillDetails meterReadingShareBillDetail : meterReadingShareBillDetails) {
                                SysMeterReadingShareBillDetails shareBillDetails = new SysMeterReadingShareBillDetails();
                                shareBillDetails.setId(meterReadingShareBillDetail.getId());
                                shareBillDetails.setStatus(3);//填入3.已缴纳
                                //根据主键id修改状态
                                int update = appMeterReadingShareDetailsDao.updateStatusById(shareBillDetails);
                                if (update <= 0){
                                    log.info("===========更新抄表记录管理-抄表分摊详情的状态失败");
                                    return "fail";
                                }
                            }
                        }



                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }

    @Override
    public Map<String, Object> meterReadingShareDetailsOrderCheckAlipay(String code) {
        map = new HashMap<>();
        log.info("================抄表记录管理-抄表分摊详情费用支付向支付宝发起查询，查询抄表记录管理-抄表分摊详情费用支付订单号为："+code);

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+code+"\"," +
                    "\"trade_no\":"+null +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if(alipayTradeQueryResponse.isSuccess()){
                //根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
                SysMeterReadingShareDetailsOrder shareDetailsOrderOrder = alipayDao.findShareDetailsOrderOrderByCode(code);
                if (shareDetailsOrderOrder == null){
                    map.put("status",-1);
                    map.put("message","订单不存在");
                    return map;
                }
                //修改数据库支付宝订单表
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        shareDetailsOrderOrder.setStatus(3);
                        break;
                    case "TRADE_SUCCESS": // 交易支付成功
                        shareDetailsOrderOrder.setStatus(2);
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        shareDetailsOrderOrder.setStatus(1);
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        shareDetailsOrderOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                alipayDao.updateShareDetailsOrderStatusByCode(shareDetailsOrderOrder);
                map.put("status",shareDetailsOrderOrder.getStatus());
                map.put("message",alipayTradeQueryResponse.getBody());
                return map; //交易状态
            } else {
                String body = alipayTradeQueryResponse.getBody();
                log.info("==================调用支付宝查询接口失败！");
                log.info("==================错误码:"+body);
                map.put("message",alipayTradeQueryResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("status",-1);
        return map;
    }

    private BigDecimal getLateFee(SysMeterReadingShareBillDetails shareBillDetails) {
        //逾期天数初始值0
        int expectedDays = 0;
        //滞纳金初始值0
        BigDecimal lateFee = BigDecimal.ZERO;

        if (shareBillDetails.getPaymentTime() != null){
            //已缴费，判断缴费时间是否大于缴费期限
            if (shareBillDetails.getPaymentTime().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                double d = (shareBillDetails.getPaymentTime().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                //如果缴费时间大于缴费期限，有滞纳金，有逾期天数
                expectedDays = (int) Math.round(d);
                //计算滞纳金
                //(计算公式【应缴金额*（1+费率/100），每日累乘】)
                BigDecimal totalPrice = shareBillDetails.getRemainingUnpaidAmount();
                for (int i = 0; i < expectedDays; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    double rate = shareBillDetails.getRate().doubleValue();
                    //计算出总缴费金额
                    totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                }
                //滞纳金 = 总缴费金额 - 应缴金额
                lateFee = totalPrice.subtract(shareBillDetails.getRemainingUnpaidAmount());
            }else {
                //缴费时间小于缴费期限，滞纳金为0，逾期天数为0
            }
        }else {
            //未缴费，产生滞纳金
            if (new Date().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                double d = (new Date().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                //当前时间大于缴费期限，有滞纳金，有逾期天数
                expectedDays = (int) Math.round(d);
                //计算滞纳金
                //(计算公式【应缴金额*（1+费率/100），每日累乘】)
                BigDecimal totalPrice = shareBillDetails.getRemainingUnpaidAmount();
                for (int i = 0; i < expectedDays; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    double rate = shareBillDetails.getRate().doubleValue();
                    //计算出总缴费金额
                    totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                }
                //滞纳金 = 总缴费金额 - 应缴金额
                lateFee = totalPrice.subtract(shareBillDetails.getRemainingUnpaidAmount());
            }else {
                //当前时间小于缴费期限，滞纳金为0，逾期天数为0
            }
        }

        return lateFee;
    }


    private void createRepairOrder(AppRepairOrder appRepairOrder) {
        //查询付款金额
        BigDecimal payPrice = appReportRepairDao.findPayPriceById(appRepairOrder.getReportRepairId());
        if (payPrice.compareTo(appRepairOrder.getPayPrice()) != 0){
            throw new RuntimeException("支付金额有误，请重新支付");
        }
        if (payPrice.equals(BigDecimal.ZERO)){
            throw new RuntimeException("支付金额不可为0");
        }
        appRepairOrder.setPayPrice(payPrice); //填写付款金额
        appRepairOrder.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId())); //填写支付单号(自动生成订单号)
        appRepairOrder.setCreateId(-1); //填写创建人 app为-1
        appRepairOrder.setCreateDate(new Date()); //填入创建时间
        appRepairOrder.setStatus(0); //填入付款状态，0.交易创建并等待买家付款
        //添加报事报修订单信息
        int i = appReportRepairDao.insertOrder(appRepairOrder);
        if (i<=0){
            throw new RuntimeException("添加报事报修订单信息失败");
        }
    }

    private void createShoppingOrder(AppGoodsAppointment appGoodsAppointment, Integer id) {
        //根据商品主键id查询商品售卖金额单价
        BigDecimal sellingPrice = shoppingDao.findSellingPriceByGoodsId(appGoodsAppointment.getGoodsId());
        //计算出真实的付款金额
        BigDecimal realPrice = sellingPrice.multiply(BigDecimal.valueOf(appGoodsAppointment.getNum()));

        if (realPrice.compareTo(appGoodsAppointment.getPayPrice()) != 0){
            throw new RuntimeException("支付金额有误，请重新支付");
        }
        if (realPrice.equals(BigDecimal.ZERO)){
            throw new RuntimeException("支付金额不可为0");
        }

        appGoodsAppointment.setCreateId(id);
        appGoodsAppointment.setCreateDate(new Date());
        appGoodsAppointment.setStatus(-2);//-2.交易创建并等待买家付款
        appGoodsAppointment.setBackLibrary(0);//是否库存回库，默认0.未回库
        appGoodsAppointment.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));//填入预约编号
        appGoodsAppointment.setUnitPrice(sellingPrice);//填入商品售卖金额单价

        AppGoodsIdAndAppointmentNum appGoodsIdAndAppointmentNum = new AppGoodsIdAndAppointmentNum();
        appGoodsIdAndAppointmentNum.setGoodsId(appGoodsAppointment.getGoodsId());
        appGoodsIdAndAppointmentNum.setAppointmentNum(appGoodsAppointment.getNum());

        //累加商品预约量,累减商品库存量
        int update = shoppingDao.incGoodsAppointmentNum(appGoodsIdAndAppointmentNum);
        if (update <= 0){
            log.info("预约失败，库存已无,商品主键id："+appGoodsAppointment.getGoodsId());
            throw new RuntimeException("预约失败，库存已无");
        }

        //生成商品预约订单
        int insert = shoppingDao.insertGoodsOrder(appGoodsAppointment);
        if (insert <= 0){
            throw new RuntimeException("添加失败");
        }
        log.info("订单号："+appGoodsAppointment.getCode()+",创建成功!!!");
    }
}
