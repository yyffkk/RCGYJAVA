package com.api.aop;

import java.util.Arrays;

public class RequestData {
    private String url;
    private String addr;
    private String classMethod;
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
