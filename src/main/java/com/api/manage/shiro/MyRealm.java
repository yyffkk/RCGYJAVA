package com.api.manage.shiro;

import com.api.model.system.SysJurisdiction;
import com.api.model.system.SysRole;
import com.api.model.system.SysUser;
import com.api.manage.service.system.SysJurisdictionService;
import com.api.manage.service.system.SysRoleService;
import com.api.manage.service.system.SysLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    SysLoginService sysUserService;
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
        SysRole role2 = sysRoleService.findByIdentityId(sysUser.getPositionId());

        //根据角色ID查找角色信息
        SysRole role3 = sysRoleService.findById(sysUser.getRoleId());
        //-2-授权角色
        authorizationInfo.addRole(role1.getName());
        authorizationInfo.addRole(role2.getName());
        authorizationInfo.addRole(role3.getName());

        //授权权限
        //-1-查后台数据
        //根据角色ID查找权限拥有的信息
        List<SysJurisdiction> sysJurisdictionList1 = sysJurisdictionService.findByRoleId(role1.getId());
        List<SysJurisdiction> sysJurisdictionList2 = sysJurisdictionService.findByRoleId(role2.getId());
        List<SysJurisdiction> sysJurisdictionList3 = sysJurisdictionService.findByRoleId(role3.getId());
        //添加到Set集合中，去掉重复权限数据
        Set<SysJurisdiction> sysJurisdictionLists = new HashSet<>();
        sysJurisdictionLists.addAll(sysJurisdictionList1);
        sysJurisdictionLists.addAll(sysJurisdictionList2);
        sysJurisdictionLists.addAll(sysJurisdictionList3);

        for (SysJurisdiction sysJurisdiction : sysJurisdictionLists) {
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
