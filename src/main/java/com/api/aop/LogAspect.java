package com.api.aop;

import com.api.util.GetIpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * manage日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.api.manage.controller..*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("在进入controller之前处理流-------------");
        //通过上下文来获取请求里面的信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        //获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息(反射)
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName();
        // 1. 获取URL
        String url = request.getRequestURL().toString();
        //2. 获取发送请求的ip地址（已处理反向代理问题）
        String addr = GetIpUtil.getIp2(request);

        /*创建一个类RequestData，来保存相关信息*/
        RequestData requestData = new RequestData(
                url, addr, classMethod, joinPoint.getArgs()
        );
        //在控制台打印出来
//        log.info("RequestData------{}",requestData);
    }
    @After("log()")
    public void doAfter(){
        System.out.println("在进入controller之后处理流-------------");
    }
    //在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
    @AfterReturning(returning = "result",pointcut="log()")
    public void doAfterReturning(Object result){
        System.out.println("在切入点return内容之后处理流-------------");
//        log.info("Return ------ {}",result );
    }
}
