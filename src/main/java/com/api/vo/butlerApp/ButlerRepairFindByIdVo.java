package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 报修详情Vo findById 回显
 */
public class ButlerRepairFindByIdVo {
    /**
     * 报修主键id
     */
    private Integer id;
    /**
     * 派工单主键id
     */
    private Integer dispatchId;
    /**
     * 绑定房屋
     */
    private String roomName;
    /**
     * 报修人名称
     */
    private String name;
    /**
     * 报修人手机号
     */
    private String tel;
    /**
     * 服务类型（1.公区维修（户外报修），2.家庭维修）
     */
    private Integer type;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废，8.已取消）
     */
    private Integer status;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerRepairFindByIdVo{" +
                "id=" + id +
                ", dispatchId=" + dispatchId +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Integer dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerRepairFindByIdVo() {
    }

    public ButlerRepairFindByIdVo(Integer id, Integer dispatchId, String roomName, String name, String tel, Integer type, Integer status, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.dispatchId = dispatchId;
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.type = type;
        this.status = status;
        this.imgUrls = imgUrls;
    }
}
