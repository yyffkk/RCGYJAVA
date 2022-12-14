package com.api.butlerApp.filter;

import com.api.app.service.login.AppLoginService;
import com.api.butlerApp.service.login.ButlerLoginService;
import com.api.model.basicArchives.UserResident;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerLoginToken;
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
@WebFilter(urlPatterns = "/butlerApp/user/*")
public class ButlerLoginDetectionFilter implements Filter {

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
        ButlerLoginService butlerLoginService = (ButlerLoginService) ButlerSpringContextUtil.getBean("butlerLoginServiceImpl");
        //转换成httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取token信息
        String tokenId = req.getHeader("butlerApp-admin-token");

        //如果tokenId为null，则返回失败json
        if (tokenId == null || "".equals(tokenId) || tokenId.isEmpty()) {
            this.respFail(response);
            return;
        }

        //根据token Id查询登录信息 (butler_login_token)
        ButlerLoginToken butlerLoginToken = butlerLoginService.findBLTByTokenId(Long.valueOf(tokenId));
        //如果根据tokenId查询登录信息为null，返回失败结果Json数据
        if (butlerLoginToken == null) {
            this.respFail(response);
            return;
        }

        //如果登录时间超时，返回失败结果json数据
        if (new Date().getTime() - butlerLoginToken.getButlerLoginDate().getTime() > LoginExpireTime){
            this.respFail(response);
            return;
        }
        //根据主键id查询管家用户信息
        SysUser sysUser = butlerLoginService.findSysUserById(butlerLoginToken.getSysUserId());

        //如果用户已被删除，返回失败结果json数据
        if (sysUser.getIsDelete() == 0){
            this.respFail(response);
            return;
        }

        if (sysUser.getStatus() == 3 || sysUser.getStatus() == 4){
            //如果用户已被停用，返回失败结果json数据
            this.respFail(response);
            return;
        }else if (sysUser.getStatus() == 2){
            //如果用户已被禁止登录，返回失败结果json数据
            this.respFail(response);
            return;
        }

        //每次请求更新一次登录user_login_token时间
        butlerLoginToken.setButlerLoginDate(new Date());
        butlerLoginService.updateBLTById(butlerLoginToken);

        //创建一个重新包装的Request请求
        ButlerParameterRequestWrapper requestWrapper = new ButlerParameterRequestWrapper(req);
        //往Request请求中添加新的对象信息
        requestWrapper.addObject(sysUser);

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
