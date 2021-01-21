package com.api.vo.app;

import java.util.Date;

/**
 * app 物品出户 二维码信息Vo
 */
public class AppArticleOutQRCodeVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 业主id
     */
    private Integer residentId;
    /**
     * 业主姓名
     */
    private String residentName;
    /**
     * 有效时间 = 预计时间 + 24小时
     */
    private Date effectiveTime;

    @Override
    public String toString() {
        return "AppArticleOutQRCodeVo{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", residentName='" + residentName + '\'' +
                ", effectiveTime=" + effectiveTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public AppArticleOutQRCodeVo() {
    }

    public AppArticleOutQRCodeVo(Integer id, Integer residentId, String residentName, Date effectiveTime) {
        this.id = id;
        this.residentId = residentId;
        this.residentName = residentName;
        this.effectiveTime = effectiveTime;
    }
}
