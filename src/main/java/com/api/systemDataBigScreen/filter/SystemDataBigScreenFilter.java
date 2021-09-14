package com.api.systemDataBigScreen.filter;

import com.api.app.filter.ParameterRequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebFilter(urlPatterns = "/systemData/*")
public class SystemDataBigScreenFilter implements Filter {
    ObjectMapper objectMapper = new ObjectMapper();
//    /**
//     *   第三方对外接口token值
//     */
//    @Value("${res.systemDataToken}")
//    private String SYSTEM_DATA_TOKEN;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //转换成httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取token信息
        String tokenId = req.getHeader("system-data-token");
        ////如果token为''，则表示没权限
        if (tokenId == null || "".equals(tokenId) || tokenId.isEmpty()) {
            this.respFail(response);
            return;
        }
        //创建一个重新包装的Request请求
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(req);
        //第三方对外接口token值{system-data-token:9627a35847e640cb92a7067557f09bda}
        //如果不相同则提示权限认证不足
        if (!"9627a35847e640cb92a7067557f09bda".equals(tokenId)){
            this.respFail(response);
            return;
        }
        //通行
        chain.doFilter(requestWrapper, response);
    }

    /** 返回失败结果Json数据 */
    private void respFail(ServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("status", false);
        map.put("message", "权限认证失败");
        map.put("data", null);
        String s = objectMapper.writeValueAsString(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().write(s.getBytes());
    }

    @Override
    public void destroy() {

    }
}
