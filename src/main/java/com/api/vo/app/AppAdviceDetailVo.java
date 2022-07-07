package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * app 咨询建议反馈信息
 */
public class AppAdviceDetailVo {
    /**
     * 咨询建议信息
     */
    private AppAdviceVo appAdviceVo;
    /**
     * 反馈文本信息集合
     */
    private List<AppAdviceContentVo> appAdviceContentVos;

    @Override
    public String toString() {
        return "AppAdviceDetailVo{" +
                "appAdviceVo=" + appAdviceVo +
                ", appAdviceContentVos=" + appAdviceContentVos +
                '}';
    }

    public AppAdviceVo getAppAdviceVo() {
        return appAdviceVo;
    }

    public void setAppAdviceVo(AppAdviceVo appAdviceVo) {
        this.appAdviceVo = appAdviceVo;
    }

    public List<AppAdviceContentVo> getAppAdviceContentVos() {
        return appAdviceContentVos;
    }

    public void setAppAdviceContentVos(List<AppAdviceContentVo> appAdviceContentVos) {
        this.appAdviceContentVos = appAdviceContentVos;
    }

    public AppAdviceDetailVo() {
    }

    public AppAdviceDetailVo(AppAdviceVo appAdviceVo, List<AppAdviceContentVo> appAdviceContentVos) {
        this.appAdviceVo = appAdviceVo;
        this.appAdviceContentVos = appAdviceContentVos;
    }
}
