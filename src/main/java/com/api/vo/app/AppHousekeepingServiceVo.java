package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app新版家政服务 Vo list 回显
 */
public class AppHousekeepingServiceVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 服务类型(1.室内清洁，2.洗涤护理)
     */
    private Integer type;
    /**
     * 服务内容
     */
    private String content;
    /**
     * 状态：1.待派单，2.已派单（待接单），3.处理中，4.待支付，5.待评价，6.已完成，9.已取消
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 提交照片资源信息
     */
    private List<VoResourcesImg> submitImgList;

    @Override
    public String toString() {
        return "AppHousekeepingServiceVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", submitImgList=" + submitImgList +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getSubmitImgList() {
        return submitImgList;
    }

    public void setSubmitImgList(List<VoResourcesImg> submitImgList) {
        this.submitImgList = submitImgList;
    }

    public AppHousekeepingServiceVo() {
    }

    public AppHousekeepingServiceVo(Integer id, String roomName, Integer type, String content, Integer status, Date createDate, List<VoResourcesImg> submitImgList) {
        this.id = id;
        this.roomName = roomName;
        this.type = type;
        this.content = content;
        this.status = status;
        this.createDate = createDate;
        this.submitImgList = submitImgList;
    }
}
