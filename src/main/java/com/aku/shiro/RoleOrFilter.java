package com.aku.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * 默认role[admin,manager]要求两个角色同时满足,
 * 要实现两个角色或的关系，自定义RoleFilter
 */
public class RoleOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object obj) throws Exception {
        String roles[] = (String[]) obj;
        Subject subject = getSubject(servletRequest, servletResponse);
        if (roles==null || roles.length==0){
            //角色授权没有,权限授权可能有
            return true;
        }
        for (String role : roles){
            if (subject.hasRole(role)){
                //若当前用户时rolesArray中的任何一个，则有权限访问
                //只要满足一个角色就有角色授权
                return true;
            }
        }
        return false;
    }
}
