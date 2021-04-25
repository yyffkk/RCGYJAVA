package com.api.systemDataBigScreen.filter;

import com.api.app.filter.SpringContextUtil;
import com.api.app.service.login.AppLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(urlPatterns = "/systemData/*")
public class SystemDataBigScreenFilter implements Filter {
    ObjectMapper objectMapper = new ObjectMapper();
    /**
     *   第三方对外接口token值
     */
    @Value("${res.systemDataToken}")
    private String SYSTEM_DATA_TOKEN;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //转换成httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取token信息
        String tokenId = req.getHeader("system-data-token");
        if (SYSTEM_DATA_TOKEN.equals(tokenId)){
            //通行
            chain.doFilter(request, response);
        }else {
            this.respFail(response);
        }
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
