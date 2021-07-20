package com.api.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.api.alipay.service.AlipayService;
import com.api.model.alipay.*;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppRepairOrder;
import com.api.model.app.UserIdAndRepairId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * app支付宝支付
 */
@RestController
@RequestMapping("app/user/alipay")
@Slf4j
public class AlipayController {
    @Resource
    AlipayService alipayService;


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
}
