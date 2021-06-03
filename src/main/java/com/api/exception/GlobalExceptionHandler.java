package com.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义全局异常处理的类 @ControllerAdvice 该注解表示开启了全局异常的捕获
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public  ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    /**
     * shiro登录认证异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    @ResponseBody
    public ResultBody UnauthenticatedException(HttpServletRequest req, UnauthenticatedException e) {
        log.error("登录认证异常!原因是:",e);
        return ResultBody.error(CommonEnum.NOT_LOGGED_IN);
    }

    /**
     * shiro权限异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public ResultBody authorizationException(HttpServletRequest req, AuthorizationException e) {
        log.error("权限异常!原因是:",e);
        return ResultBody.error(CommonEnum.NOT_PERMISSIONS);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }


}
