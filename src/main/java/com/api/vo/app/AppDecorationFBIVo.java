package com.api.vo.app;

import java.util.Date;

/**
 * app装修管理Vo findById 回显
 */
public class AppDecorationFBIVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 装修单号
     */
    private String code;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 装修负责人
     */
    private String director;
    /**
     * 装修负责人联系电话
     */
    private String directorTel;
    /**
     * 预计开始时间
     */
    private Date expectedBegin;
    /**
     * 预计结束时间
     */
    private Date expectedEnd;

    @Override
    public String toString() {
        return "AppDecorationFBIVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", code='" + code + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
    }

    public Date getExpectedBegin() {
        return expectedBegin;
    }

    public void setExpectedBegin(Date expectedBegin) {
        this.expectedBegin = expectedBegin;
    }

    public Date getExpectedEnd() {
        return expectedEnd;
    }

    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    public AppDecorationFBIVo() {
    }

    public AppDecorationFBIVo(Integer id, String roomName, String code, String constructionUnit, String director, String directorTel, Date expectedBegin, Date expectedEnd) {
        this.id = id;
        this.roomName = roomName;
        this.code = code;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
    }
}
