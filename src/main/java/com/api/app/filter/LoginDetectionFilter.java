package com.api.app.filter;

import com.api.app.dao.login.AppLoginDao;
import com.api.model.app.UserLoginToken;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.UserLoginTokenVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//过滤器去掉@Component，在程序启动类加上@ServletComponentScan，过滤器和urlPatterns属性均生效。
//@Component
@WebFilter(urlPatterns = "/app/user/*")
public class LoginDetectionFilter implements Filter {
    @Resource
    AppLoginDao appLoginDao;
    //登录过期时间为30分钟
    private static final long LoginExpireTime = 30*60*1000;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //转换成httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取token信息
        String tokenId = req.getHeader("app-admin-token");

        //如果tokenId为null，则返回失败json
        if (tokenId == null || "".equals(tokenId) || tokenId.isEmpty()) {
            this.respFail(response);
            return;
        }

        //根据token Id查询登录信息 (user_login_token)
        UserLoginTokenVo userLoginTokenVo = appLoginDao.findULTByTokenId(Long.valueOf(tokenId));
        //如果根据tokenId查询登录信息为null，返回失败结果Json数据
        if (userLoginTokenVo == null) {
            this.respFail(response);
            return;
        }

        //如果登录时间超时，返回失败结果json数据
        if (new Date().getTime() - userLoginTokenVo.getUserLoginDate().getTime() > LoginExpireTime){
            this.respFail(response);
            return;
        }
        //根据主键id查询住户信息
        UserResident userResident = appLoginDao.findUserResidentById(userLoginTokenVo.getResidentId());


        //每次请求更新一次登录user_login_token时间
        userLoginTokenVo.setUserLoginDate(new Date());
        appLoginDao.updateULTById(userLoginTokenVo);

        //创建一个重新包装的Request请求
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(req);
        //往Request请求中添加新的对象信息
        requestWrapper.addObject(userResident);

        chain.doFilter(requestWrapper, response);
    }

    /** 返回失败结果Json数据 */
    private void respFail(ServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("status", false);
        map.put("message", "登录失效，请登录");
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