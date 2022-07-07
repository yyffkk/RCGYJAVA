package com.api.systemDataBigScreen.filter;

import com.alibaba.fastjson.JSONObject;
import com.api.app.filter.ParameterRequestWrapper;
import com.api.app.filter.SpringContextUtil;
import com.api.app.service.login.AppLoginService;
import com.api.systemDataBigScreen.service.LilinDataPushService;
import com.api.util.RequestReaderHttpServletRequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.*;

@WebFilter(urlPatterns = "/lilinPush/*")
public class LilinDataPushFilter implements Filter {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //解决外置 tomcat启动Spring Boot程序模式下解决过滤器中 @AutoWired注入bean的空指针问题
        //在相应的业务代码中 使用SpringContextUtil.getBean("xxx") 获取相应的bean组件即可
        LilinDataPushService lilinDataPushService = (LilinDataPushService) SpringContextUtil.getBean("lilinDataPushServiceImpl");

        //转换成httpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //创建一个重新包装的Request请求
        RequestReaderHttpServletRequestWrapper requestWrapper = new RequestReaderHttpServletRequestWrapper(request);

        try {
            //获取post请求参数
            String body = "";
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                InputStream inputStream = requestWrapper.getInputStream();
                if (inputStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                } else {
                    stringBuilder.append("");
                }
            } catch (IOException ex) {
                throw ex;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        throw ex;
                    }
                }
            }
            body = stringBuilder.toString();

            TreeMap paramsMaps = JSONObject.parseObject(body, TreeMap.class);
            String clientId = String.valueOf(paramsMaps.get("clientId"));
    //        String method = String.valueOf(paramsMaps.get("method"));
            String method = "pushAccessControlRecord";
            String timestamp = String.valueOf(paramsMaps.get("timestamp"));
            String nonce = String.valueOf(paramsMaps.get("nonce"));
            String signature = String.valueOf(paramsMaps.get("signature"));

            String stringA = "clientId="+clientId+"&method="+method+"&timestamp="+timestamp+"&nonce="+nonce;

            //根据clientId查询clientSecret
            String clientSecret = lilinDataPushService.findClientSecretByClientId(clientId);

            //签名验签
            String signature2 = genHMAC(stringA, clientSecret);
            if (!signature.equals(signature2)){
                throw new RemoteException("验签失败");
            }

        } catch (Exception e) {
            this.respFail(servletResponse);
            return;
        }

        //通行
        chain.doFilter(requestWrapper, servletResponse);
    }

    public static String genHMAC(String data, String key) throws Exception {
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        //生成一个指定 Mac 算法 的 Mac 对象f
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        //用给定密钥初始化 Mac 对象
        mac.init(signinKey);
        //完成 Mac 操作
        byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
        String s = new BASE64Encoder().encodeBuffer(Hex.encodeHexString(rawHmac).getBytes());
        //去掉换行符和特殊符号
        String s2 = s.replaceAll("[\\s*\t\n\r]", "");
        return s2;
    }

    /** 返回失败结果Json数据 */
    private void respFail(ServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("result", 4030);
        map.put("message", "验签失败");
        map.put("data", null);
        map.put("requestId", UUID.randomUUID());
        String s = objectMapper.writeValueAsString(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().write(s.getBytes());
    }

    @Override
    public void destroy() {

    }
}
