package com.api.wx2;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 小程序微信支付
 *
 * @author 夕四
 **/
public interface WXPayNewService {
    /**
     * 微信统一下单接口
     *
     * @param
     * @return
     * @throws Exception
     */
    Map doUnifiedOrder(String outTradeNo,Integer totalAmount) throws Exception;

    /**
     * 获取v3的证书
     *
     * @return
     * @throws IOException
     */
    String createPlatformCert() throws IOException;

    /**
     * 微信支付回调接口
     *
     * @param request
     * @param response
     */
    void callBack(HttpServletRequest request, HttpServletResponse response);
}
