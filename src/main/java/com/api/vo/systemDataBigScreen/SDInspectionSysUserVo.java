package com.api.vo.systemDataBigScreen;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 系统数据 巡更人员信息
 */
public class SDInspectionSysUserVo {
    /**
     * 巡更人员主键id
     */
    private Integer id;
    /**
     * 巡更人员真实姓名
     */
    private String actualName;
    /**
     * 巡更人员手机号
     */
    private String tel;
    /**
     * 巡更人员的头像，照片路径取集合中的第一个
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "SDInspectionSysUserVo{" +
                "id=" + id +
                ", actualName='" + actualName + '\'' +
                ", tel='" + tel + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public SDInspectionSysUserVo() {
    }

    public SDInspectionSysUserVo(Integer id, String actualName, String tel, List<VoResourcesImg> imgList) {
        this.id = id;
        this.actualName = actualName;
        this.tel = tel;
        this.imgList = imgList;
    }
}
