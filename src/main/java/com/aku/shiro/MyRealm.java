package com.aku.shiro;

import com.aku.model.system.SysJurisdiction;
import com.aku.model.system.SysRole;
import com.aku.model.system.SysUser;
import com.aku.service.system.SysJurisdictionService;
import com.aku.service.system.SysRoleService;
import com.aku.service.system.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysJurisdictionService sysJurisdictionService;

    /**
     *
     * 认证登录
     *
     * @param token 令牌
     * @return AuthenticationInfo
     * @throws AuthenticationException 异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String loginName = usernamePasswordToken.getUsername();
        //通过用户名查找用户
        SysUser sysUser = sysUserService.findByUserName(loginName);
        //用户是否存在
        if (sysUser==null){
            //用户不存在
            return null;
        }else {
            //比对查到的密码和登录页的密码
            return new SimpleAuthenticationInfo(sysUser,sysUser.getPwd(),this.getName());
        }

    }


    /**
     * 授权
     * @param principalCollection 身份集合，因为我们可以在Shiro中同时配置多个Realm，所以呢身份信息可能就有多个；因此其提供了PrincipalCollection用于聚合这些身份信息
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //授权角色
        //-1-查后台数据
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //根据组织ID查找角色信息
        SysRole role1 = sysRoleService.findByOrganizationId(sysUser.getOrganizationId());

        //根据身份ID查找角色信息

        //根据用户组查找角色信息

        //根据角色ID查找角色信息
        SysRole role = sysRoleService.findById(sysUser.getRoleId());
        //-2-授权角色
        authorizationInfo.addRole(role.getName());
        authorizationInfo.addRole(role1.getName());


        //授权权限
        //-1-查后台数据
        //根据角色ID查找权限拥有的信息
        List<SysJurisdiction> sysJurisdictionList = sysJurisdictionService.findByRoleId(role.getId());
        for (SysJurisdiction sysJurisdiction : sysJurisdictionList) {
            //-2-如果存在就授权权限
            if (sysJurisdiction.getName()!=null && !"".equals(sysJurisdiction.getName().trim())){
                //授权
                authorizationInfo.addStringPermission(sysJurisdiction.getName());
                //将该信息存进shiro的session里
                subject.getSession().setAttribute("permission",sysJurisdiction.getName());
            }
        }


        return authorizationInfo;
    }


}
