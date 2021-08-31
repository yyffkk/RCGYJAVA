package com.api.aop;

import java.util.Arrays;

public class RequestData {
    /**
     * 请求链接
     */
    private String url;
    /**
     * 发送请求的地址ip
     */
    private String addr;
    /**
     * 请求方法
     */
    private String classMethod;
    /**
     * 请求参数
     */
    private Object[] args;

    @Override
    public String toString() {
        return "RequestData{" +
                "url='" + url + '\'' +
                ", addr='" + addr + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public RequestData() {
    }

    public RequestData(String url, String addr, String classMethod, Object[] args) {
        this.url = url;
        this.addr = addr;
        this.classMethod = classMethod;
        this.args = args;
    }
}
