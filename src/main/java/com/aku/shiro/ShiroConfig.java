package com.aku.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig {
    /**
     * 验证授权、认证
     * 将自己的验证方式加入容器
     *
     * @return 授权认证
     */
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    /**
     * 权限安全管理器，配置主要是Realm的管理认证
     * session manager
     *
     * @param myRealm 授权认证
     * @return 安全管理
     */
    @Bean
    public SecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    /**
     * shiro 过滤器工厂，设置对应的过滤条件和跳转条件
     *
     * @param securityManager securityManager session 管理
     * @return shiro过滤工厂
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

//        // 登录
//        shiroFilterFactoryBean.setLoginUrl("https://www.baidu.com/");
//        // 首页
//        shiroFilterFactoryBean.setSuccessUrl("/admin/index.html");
//        // 错误页面，认证不通过跳转
//        shiroFilterFactoryBean.setUnauthorizedUrl("https://www.baidu.com/");

        //配置自定义过滤器 多角色 认证
//        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
//        filterMap.put("roleOrFilter", new RoleOrFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);


        //new HashMap<String, String>() 会有12条put的限制 ，超过12条put就会出错，所以改为用LinkedHashMap<String, String>()
        //Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();  ×
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 登出
//        filterChainDefinitionMap.put("/logout", "logout");


        // 对所有用户认证
//        filterChainDefinitionMap.put("/**", "authc");


//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLife(){
        return  new LifecycleBeanPostProcessor();
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 加入注解的使用，不加入这个，注解不生效
     *
     * @param securityManager 安全管理器
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    /**
//     * 捕获注解的权限不足异常，跳转到指定页面
//     * @return SimpleMappingExceptionResolver
//     */
//    @Bean
//    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.put("org.apache.shiro.authz.UnauthorizedException","https://www.baidu.com/");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }
}
