package com.api.alipay.controller;

import com.api.alipay.service.AlipayService;
import com.api.model.alipay.OrderTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝支付
 */
@RestController
@RequestMapping("/alipay")
@Slf4j
public class AlipayController {
    @Resource
    AlipayService alipayService;

    /**
     * 获取支付宝加签后台的订单信息字符串
     * @return map
     */
    @PostMapping("/getAliPayOrderStr")
    public String getAliPayOrderStr(@RequestBody OrderTest orderTest){
        return alipayService.getAliPayOrderStr(orderTest);
    }

    /**
     * 支付宝支付成功后.异步请求该接口
     * @param request request
     * @return 状态
     * @throws IOException io异常
     */
    @RequestMapping(value="/notify_url",method=RequestMethod.POST)
    @ResponseBody
    public String notify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("==================支付宝异步返回支付结果开始");
        //1.从支付宝回调的request域中取值
        //获取支付宝返回的参数集合
        Map<String, String[]> aliParams = request.getParameterMap();
        //用以存放转化后的参数集合
        Map<String, String> conversionParams = new HashMap<String, String>();
        for (Iterator<String> iter = aliParams.keySet().iterator(); iter.hasNext();) {
            String key = iter.next();
            String[] values = aliParams.get(key);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "uft-8");
            conversionParams.put(key, valueStr);
        }
        log.info("==================返回参数集合："+conversionParams);
        String status=alipayService.notify(conversionParams);
        return status;
    }

    /**
     * 向支付宝发起订单查询请求
     * @param outTradeNo 商户订单号
     * @return map
     */
    @PostMapping("/checkAlipay")
    public Byte checkAlipay(String outTradeNo){
        return alipayService.checkAlipay(outTradeNo);
    }



}
