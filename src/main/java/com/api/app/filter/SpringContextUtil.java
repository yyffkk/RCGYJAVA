package com.api.app.filter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//问题原因：在web.xml中各个元素的执行顺序是这样的，context-param-->listener-->filter-->servlet  可以看出在Spring MVC 的dispatcherservlet初始化之前过滤器就已经加载好了,所以注入的是null。
//SpringBoot--过滤器注入bean的空指针问题 https://www.cnblogs.com/tjqBlog/p/9401129.html
//解决外置 tomcat启动Spring Boot程序模式下解决过滤器注入bean的空指针问题 https://www.cnblogs.com/tjqBlog/p/9403656.html
//最后 在相应的业务代码中 使用SpringContextUtil.getBean("xxx") 获取相应的bean组件即可
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过名字获取上下文中的bean
    public static Object getBean(String name){
       return applicationContext.getBean(name);
    }
    //通过类型获取上下文中的bean
    public static Object getBean(Class<?> requiredType){
        return applicationContext.getBean(requiredType);
    }
}
