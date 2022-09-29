package com.api.alipay.controller;

import com.alibaba.fastjson.JSONObject;
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
import com.api.manage.dao.butlerService.LeaseDao;
import com.api.manage.dao.butlerService.SysProcessRecordDao;
import com.api.model.alipay.*;
import com.api.model.app.*;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.basicArchives.CpmResidentEstate;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.SysLease;
import com.api.model.chargeManagement.SysMeterReadingShareBillDetails;
import com.api.model.jcook.appDto.CreateOrderDTO;
import com.api.util.GetIpUtil;
import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.butlerService.VoFBILease;
import com.api.wx2.WXPayNewService;
import com.api.wx3.PaidService;
import com.api.wx3.PayConstants;
import com.api.wx3.V3PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.api.wx3.PaidService.decryptToString;

/**
 * app支付宝支付
 */
@RestController
@RequestMapping("app/user/alipay")
@Slf4j
public class AlipayController {
    @Resource
    AlipayService alipayService;
    @Resource
    private WXPayNewService wxPayNewService;
    @Resource
    V3PayService v3PayService;
    @Resource
    PaidService paidService;
    @Resource
    LeaseDao leaseDao;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    AuditManagementDao auditManagementDao;
    @Resource
    AppDailyPaymentDao appDailyPaymentDao;
    @Resource
    ShoppingDao shoppingDao;
    @Resource
    AppReportRepairDao appReportRepairDao;
    @Resource
    SysProcessRecordDao sysProcessRecordDao;
    @Resource
    AlipayDao alipayDao;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;
    @Resource
    AppMeterReadingShareDetailsDao appMeterReadingShareDetailsDao;
//    /**
//     * 获取支付宝加签后台的订单信息字符串
//     * @return map
//     */
//    @PostMapping("/getAliPayOrderStr")
//    public String getAliPayOrderStr(@RequestBody OrderTest orderTest){
//        return alipayService.getAliPayOrderStr(orderTest);
//    }
//
//    /**
//     * 支付宝支付成功后.异步请求该接口（一直请求，直到返回success）
//     * @param request request
//     * @return 状态
//     * @throws IOException io异常
//     */
//    @RequestMapping(value="/notify_url",method=RequestMethod.POST)
//    @ResponseBody
//    public String notify(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        log.info("==================支付宝异步返回支付结果开始");
//        //1.从支付宝回调的request域中取值
//        //获取支付宝返回的参数集合
//        Map<String, String[]> aliParams = request.getParameterMap();
//        //用以存放转化后的参数集合
//        Map<String, String> conversionParams = new HashMap<String, String>();
//        for (Iterator<String> iter = aliParams.keySet().iterator(); iter.hasNext();) {
//            String key = iter.next();
//            String[] values = aliParams.get(key);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
//            }
//            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "uft-8");
//            conversionParams.put(key, valueStr);
//        }
//        log.info("==================返回参数集合："+conversionParams);
//        String status=alipayService.notify(conversionParams);
//        return status;
//    }


//    /**
//     * app测试支付(生成 APP 支付订单信息)
//     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
//     * @param response response
//     * @param request request
//     * @return map
//     */
//    @PostMapping(value = "/alipay")
//    public Map<String,Object> alipay(@RequestBody AppDailyPaymentOrder appDailyPaymentOrder, HttpServletResponse response, HttpServletRequest request) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        return alipayService.alipay(appDailyPaymentOrder);
//    }
//
//    /**
//     * 测试接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
//     * @param request request
//     * @param response response
//     * @return map
//     * @throws UnsupportedEncodingException 异常
//     */
//    @PostMapping(value = "/getAlipayNotifyInfo")
//    public String getAlipayNotifyInfoOfCombinedPayment(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
//        request.setCharacterEncoding("UTF-8");
//        return alipayService.getAlipayNotifyInfoOfCombinedPayment(request);
//    }
//
//    /**
//     * 测试向支付宝发起订单查询请求
//     * @param outTradeNo 商户订单号
//     * @return map
//     */
//    @PostMapping("/checkAlipay")
//    public Integer checkAlipay(@RequestBody String outTradeNo){
//        return alipayService.checkAlipay(outTradeNo);
//    }

    /**
     * app 日常缴费支付宝支付(生成 APP 支付订单信息)
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/dailyPaymentAlipay")
    public Map<String,Object> dailyPaymentAlipay(@RequestBody AppDailyPaymentOrder appDailyPaymentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        appDailyPaymentOrder.setName(name); //填写付款人姓名
        appDailyPaymentOrder.setTel(tel); //填写付款人手机号
        return alipayService.dailyPaymentAlipay(appDailyPaymentOrder);
    }


    /**
     * 日常缴费 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/dailyPaymentNotifyInfo")
    public String dailyPaymentNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        return alipayService.dailyPaymentNotifyInfo(request);
    }

    /**
     * 日常缴费 向支付宝发起订单查询请求
     * @param code  商户订单号
     * @return map
     */
    @GetMapping("/dailyPaymentCheckAlipay")
    public Map<String,Object> dailyPaymentCheckAlipay(String code){
        return alipayService.dailyPaymentCheckAlipay(code);
    }

    /**
     * app 报事报修完成订单支付宝支付(生成 APP 支付订单信息)
     * @param appRepairOrder app 报事报修订单
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/reportRepairAlipay")
    public Map<String,Object> reportRepairAlipay(@RequestBody AppRepairOrder appRepairOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        appRepairOrder.setName(name); //填写付款人姓名
        appRepairOrder.setTel(tel); //填写付款人手机号
        return alipayService.reportRepairAlipay(appRepairOrder);
    }


    /**
     * 报事报修 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/reportRepairNotifyInfo")
    public String reportRepairNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.reportRepairNotifyInfo(request,userName,userId);
    }


    /**
     * 报事报修 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/reportRepairCheckAlipay")
    public Map<String,Object> reportRepairCheckAlipay(String code){
        return alipayService.reportRepairCheckAlipay(code);
    }


    /**
     * app 商城购物完成订单支付宝支付(生成 APP 支付订单信息)
     * @param appGoodsAppointment app 商品预约信息
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/shoppingAlipay")
    public Map<String,Object> shoppingAlipay(@RequestBody AppGoodsAppointment appGoodsAppointment, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        Integer type = Integer.valueOf(request.getParameter("type"));//从request获取用户type
        appGoodsAppointment.setUserName(name); //填写付款人姓名
        appGoodsAppointment.setUserTel(tel); //填写付款人手机号
        return alipayService.shoppingAlipay(appGoodsAppointment,type,id);
    }


    /**
     * 商城购物 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/shoppingNotifyInfo")
    public String shoppingNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.shoppingNotifyInfo(request,userName,userId);
    }


    /**
     * 商城购物 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/shoppingCheckAlipay")
    public Map<String,Object> shoppingCheckAlipay(String code){
        return alipayService.shoppingCheckAlipay(code);
    }


    /**
     * app-保证金支付 房屋租赁完成订单支付宝支付(生成 APP 支付订单信息)
     * @param sysLeaseOrder app 房屋租赁保证金订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/leaseAlipay")
    public Map<String,Object> leaseAlipay(@RequestBody SysLeaseOrder sysLeaseOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysLeaseOrder.setName(name); //填写付款人姓名
        sysLeaseOrder.setTel(tel); //填写付款人手机号
        return alipayService.leaseAlipay(sysLeaseOrder,id);
    }


    /**
     * 房屋租赁-保证金支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/leaseNotifyInfo")
    public String leaseNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.leaseNotifyInfo(request,userName,userId);
    }


    /**
     * 房屋租赁-保证金支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/leaseCheckAlipay")
    public Map<String,Object> leaseCheckAlipay(String code){
        return alipayService.leaseCheckAlipay(code);
    }


    /**
     * app 房屋租赁-剩余需结清租金支付 完成订单支付宝支付(生成 APP 支付订单信息)
     * @param sysLeaseRentOrder app 房屋租赁剩余需结清租金订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/leaseRentOrderAlipay")
    public Map<String,Object> leaseRentOrderAlipay(@RequestBody SysLeaseRentOrder sysLeaseRentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysLeaseRentOrder.setName(name); //填写付款人姓名
        sysLeaseRentOrder.setTel(tel); //填写付款人手机号
        return alipayService.leaseRentOrderAlipay(sysLeaseRentOrder,id);
    }


    /**
     * 房屋租赁-剩余需结清租金支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/leaseRentOrderNotifyInfo")
    public String leaseRentOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.leaseRentOrderNotifyInfo(request,userName,userId);
    }


    /**
     * 房屋租赁-剩余需结清租金支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/leaseRentOrderCheckAlipay")
    public Map<String,Object> leaseRentOrderCheckAlipay(String code){
        return alipayService.leaseRentOrderCheckAlipay(code);
    }

    /**
     * app 房屋租赁-租金账单支付 完成订单支付宝支付(生成 APP 支付订单信息)
     * @param sysLeaseRentBillOrder app 房屋租赁租金账单订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/leaseRentBillOrderAlipay")
    public Map<String,Object> leaseRentBillOrderAlipay(@RequestBody SysLeaseRentBillOrder sysLeaseRentBillOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysLeaseRentBillOrder.setName(name); //填写付款人姓名
        sysLeaseRentBillOrder.setTel(tel); //填写付款人手机号
        return alipayService.leaseRentBillOrderAlipay(sysLeaseRentBillOrder,id);
    }


    /**
     * 房屋租赁-租金账单支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/leaseRentBillOrderNotifyInfo")
    public String leaseRentBillOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.leaseRentBillOrderNotifyInfo(request,userName,userId);
    }


    /**
     * 房屋租赁-租金账单支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/leaseRentBillOrderCheckAlipay")
    public Map<String,Object> leaseRentBillOrderCheckAlipay(String code){
        return alipayService.leaseRentBillOrderCheckAlipay(code);
    }


    /**
     * app 生活缴费-预充值支付 完成订单支付宝支付(生成 APP 支付订单信息)
     * @param sysAdvancePaymentOrder app 生活缴费-预充值支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/advancePaymentOrderAlipay")
    public Map<String,Object> advancePaymentOrderAlipay(@RequestBody SysAdvancePaymentOrder sysAdvancePaymentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysAdvancePaymentOrder.setName(name); //填写付款人姓名
        sysAdvancePaymentOrder.setTel(tel); //填写付款人手机号
        return alipayService.advancePaymentOrderAlipay(sysAdvancePaymentOrder,id);
    }


    /**
     * 生活缴费-预充值支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/advancePaymentOrderNotifyInfo")
    public String advancePaymentOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.advancePaymentOrderNotifyInfo(request,userName,userId);
    }


    /**
     * 生活缴费-预充值支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/advancePaymentOrderCheckAlipay")
    public Map<String,Object> advancePaymentOrderCheckAlipay(String code){
        return alipayService.advancePaymentOrderCheckAlipay(code);
    }

    /**
     * app 家政服务-服务费用支付 完成订单支付宝支付(生成 APP 支付订单信息)
     * @param sysHousekeepingServiceOrder app 家政服务-服务费用支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/housekeepingServiceOrderAlipay")
    public Map<String,Object> housekeepingServiceOrderAlipay(@RequestBody SysHousekeepingServiceOrder sysHousekeepingServiceOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysHousekeepingServiceOrder.setName(name); //填写付款人姓名
        sysHousekeepingServiceOrder.setTel(tel); //填写付款人手机号
        return alipayService.housekeepingServiceOrderAlipay(sysHousekeepingServiceOrder,id);
    }


    /**
     * 家政服务-服务费用支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/housekeepingServiceOrderNotifyInfo")
    public String housekeepingServiceOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.housekeepingServiceOrderNotifyInfo(request,userName,userId);
    }


    /**
     * 家政服务-服务费用支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/housekeepingServiceOrderCheckAlipay")
    public Map<String,Object> housekeepingServiceOrderCheckAlipay(String code){
        return alipayService.housekeepingServiceOrderCheckAlipay(code);
    }

    /**
     * app 抄表记录管理-抄表分摊详情费用支付 完成订单支付宝支付(生成 APP 支付订单信息)
     * @param shareDetailsOrder app 抄表记录管理-抄表分摊详情费用支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/meterReadingShareDetailsOrderAlipay")
    public Map<String,Object> meterReadingShareDetailsOrderAlipay(@RequestBody SysMeterReadingShareDetailsOrder shareDetailsOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        shareDetailsOrder.setName(name); //填写付款人姓名
        shareDetailsOrder.setTel(tel); //填写付款人手机号
        return alipayService.meterReadingShareDetailsOrderAlipay(shareDetailsOrder,id);
    }


    /**
     * 抄表记录管理-抄表分摊详情费用支付 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/meterReadingShareDetailsOrderNotifyInfo")
    public String meterReadingShareDetailsOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.meterReadingShareDetailsOrderNotifyInfo(request,userName,userId);
    }


    /**
     * 抄表记录管理-抄表分摊详情费用支付 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/meterReadingShareDetailsOrderCheckAlipay")
    public Map<String,Object> meterReadingShareDetailsOrderCheckAlipay(String code){
        return alipayService.meterReadingShareDetailsOrderCheckAlipay(code);
    }


    /**
     * jcook商品创建订单
     * @param createOrderDTO 创建订单DTO
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping("/jcookOrderCreateOrder")
    public Map<String,Object> jcookOrderCreateOrder(@RequestBody CreateOrderDTO createOrderDTO, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        Integer type = Integer.valueOf(request.getParameter("type"));//从request获取用户type
        String ip2 = GetIpUtil.getIp2(request);//获取用户ip
        createOrderDTO.setPayName(name);
        createOrderDTO.setPayTel(tel);
        createOrderDTO.setResidentId(id);
        return alipayService.jcookOrderCreateOrder(createOrderDTO,type,ip2);
    }

    /**
     * jcook商品 接收支付宝异步通知消息（支付宝支付成功后.异步请求该接口,一直请求，直到返回success）
     * @param request request
     * @param response response
     * @return map
     * @throws UnsupportedEncodingException 异常
     */
    @PostMapping(value = "/jcookOrderNotifyInfo")
    public String jcookOrderNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 解决POST请求中文乱码问题（推荐使用此种方式解决中文乱码，因为是支付宝发送异步通知使用的是POST请求）
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        return alipayService.jcookOrderNotifyInfo(request,userName,userId);
    }

    /**
     * jcook商品 向支付宝发起订单查询请求
     * @param code 商户订单号
     * @return map
     */
    @GetMapping("/jcookOrderCheckAlipay")
    public Map<String,Object> jcookOrderCheckAlipay(String code){
        return alipayService.jcookOrderCheckAlipay(code);
    }




    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotify", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String callBack2(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseOrder sysLeaseOrder = leaseDao.findSysLeaseOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            BigDecimal payPrice = sysLeaseOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);
            if(sysLeaseOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysLeaseOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysLeaseOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseOrderStatusByCode(sysLeaseOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }








    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfDailyPayment", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfDailyPayment(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppDailyPaymentOrder aliPaymentOrder = appDailyPaymentDao.findDailPaymentOrderByCode(outTradeNo);

            BigDecimal payPrice = aliPaymentOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(aliPaymentOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        aliPaymentOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        aliPaymentOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        aliPaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = appDailyPaymentDao.updateDPOrderStatusByCode(aliPaymentOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }





    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfShoppingRepair", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfShoppingRepair(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppGoodsAppointment appGoodsAppointment = shoppingDao.findGoodsOrderByCode(outTradeNo);

            BigDecimal payPrice = appGoodsAppointment.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(appGoodsAppointment!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        appGoodsAppointment.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        appGoodsAppointment.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        appGoodsAppointment.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult =  shoppingDao.updateSGAStatusByCode(appGoodsAppointment);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }



    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfReportRepair", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfReportRepair(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String userName = request.getParameter("name"); //从request获取用户姓名
        Integer userId = Integer.valueOf(request.getParameter("id"));//从request获取用户id

        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            AppRepairOrder appRepairOrder = appReportRepairDao.findRepairOrderByCode(outTradeNo);

            BigDecimal payPrice = appRepairOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(appRepairOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        appRepairOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        appRepairOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        appRepairOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = appReportRepairDao.updateDPOrderStatusByCode(appRepairOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }



    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfLeaseRentOrder", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfLeaseRentOrder(HttpServletRequest request) throws IOException, GeneralSecurityException {


        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseRentOrder sysLeaseRentOrder = leaseDao.findSysLeaseRentOrderByCode(outTradeNo);

            BigDecimal payPrice = sysLeaseRentOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysLeaseRentOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysLeaseRentOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysLeaseRentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseRentOrderStatusByCode(sysLeaseRentOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }



    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfLeaseRentBillOrder", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfLeaseRentBillOrder(HttpServletRequest request) throws IOException, GeneralSecurityException {


        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseRentBillOrder sysLeaseRentBillOrder = leaseDao.findSysLeaseRentBillOrderByCode(outTradeNo);

            BigDecimal payPrice = sysLeaseRentBillOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysLeaseRentBillOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysLeaseRentBillOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseRentBillOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysLeaseRentBillOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseRentBillOrderStatusByCode(sysLeaseRentBillOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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





    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfAdvancePaymentOrder", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfAdvancePaymentOrder(HttpServletRequest request) throws IOException, GeneralSecurityException {


        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysAdvancePaymentOrder sysAdvancePaymentOrder = alipayDao.findSysAdvancePaymentOrderByCode(outTradeNo);

            BigDecimal payPrice = sysAdvancePaymentOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysAdvancePaymentOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysAdvancePaymentOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysAdvancePaymentOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysAdvancePaymentOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateAdvancePaymentOrderStatusByCode(sysAdvancePaymentOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }



    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfHousekeepingServiceOrder", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfHousekeepingServiceOrder(HttpServletRequest request) throws IOException, GeneralSecurityException {


        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysHousekeepingServiceOrder sysHousekeepingServiceOrder = alipayDao.findSysHousekeepingServiceOrderByCode(outTradeNo);

            BigDecimal payPrice = sysHousekeepingServiceOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(sysHousekeepingServiceOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysHousekeepingServiceOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysHousekeepingServiceOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysHousekeepingServiceOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateHousekeepingServiceOrderStatusByCode(sysHousekeepingServiceOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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


    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotifyOfMeterReadingShareDetailsOrder", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String payNotifyOfMeterReadingShareDetailsOrder(HttpServletRequest request) throws IOException, GeneralSecurityException {


        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysMeterReadingShareDetailsOrder shareDetailsOrder = alipayDao.findShareDetailsOrderOrderByCode(outTradeNo);

            BigDecimal payPrice =shareDetailsOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);


            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            if(shareDetailsOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        shareDetailsOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        shareDetailsOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        shareDetailsOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = alipayDao.updateShareDetailsOrderStatusByCode(shareDetailsOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
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


}
