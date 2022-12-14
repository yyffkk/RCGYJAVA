package com.api.app.filter;

import com.api.app.service.login.AppLoginService;
import com.api.model.app.AppRequestLog;
import com.api.model.basicArchives.UserResident;
import com.api.util.GetIpUtil;
import com.api.vo.app.UserLoginTokenVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//过滤器去掉@Component，在程序启动类加上@ServletComponentScan，过滤器和urlPatterns属性均生效。
//@Component
//@Order注解表示执行过滤顺序，值越小，越先执行
//@Order(1)
@WebFilter(urlPatterns = "/app/user/*")
public class LoginDetectionFilter implements Filter {

    //登录过期时间为15天，连续15天没登录，需要重新登录
    private static final long LoginExpireTime = 15*24*60*60*1000;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //解决外置 tomcat启动Spring Boot程序模式下解决过滤器中 @AutoWired注入bean的空指针问题
        //在相应的业务代码中 使用SpringContextUtil.getBean("xxx") 获取相应的bean组件即可
        AppLoginService appLoginService = (AppLoginService) SpringContextUtil.getBean("appLoginServiceImpl");
        //转换成httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取token信息
        String tokenId = req.getHeader("app-admin-token");

        ////如果token为''，则表示 没登录通行状态【游客状态】。
        if (tokenId == null || "".equals(tokenId) || tokenId.isEmpty()) {
            //如果token为''，则表示 没登录通行状态。
            //创建一个重新包装的Request请求
            ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(req);
            UserResident userResident = new UserResident();
            userResident.setId(0);
            userResident.setType(0);
            //往Request请求中添加新的对象信息
            requestWrapper.addObject(userResident);
            //通行
            chain.doFilter(requestWrapper, response);
            return;
        }

        //根据token Id查询登录信息 (user_login_token)
        UserLoginTokenVo userLoginTokenVo = appLoginService.findULTByTokenId(Long.valueOf(tokenId));
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
        UserResident userResident = appLoginService.findUserResidentById(userLoginTokenVo.getResidentId());

        //写入用户请求日志,用于日活跃查询
        //根据住户id,和当前时间查询是否有当天日志存入
        AppRequestLog appRequestLog1 = new AppRequestLog();
        //填入住户id
        appRequestLog1.setResidentId(userResident.getId());
        //填入当前时间
        appRequestLog1.setLastDate(new Date());
        //填入用户登录ip
        appRequestLog1.setLoginIp(GetIpUtil.getIp2(req));
        //根据住户id和当前时间查询今日是否有操作记录
        AppRequestLog appRequestLog = appLoginService.findRequestLog(appRequestLog1);
        if (appRequestLog != null){
            //填入主键id
            appRequestLog1.setId(appRequestLog.getId());
            //更新当日用户请求日志
            appLoginService.updateRequestLog(appRequestLog1);
        }else {
            //填入请求次数，初始为1
            appRequestLog1.setRequestNum(1);
            //添加当日用户请求日志
            appLoginService.insertRequestLog(appRequestLog1);
        }


        //每次请求更新一次登录user_login_token时间
        userLoginTokenVo.setUserLoginDate(new Date());
        appLoginService.updateULTById(userLoginTokenVo);

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
