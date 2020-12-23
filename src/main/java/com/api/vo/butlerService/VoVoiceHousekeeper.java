package com.api.vo.butlerService;
/**
 * 语音管家 Vo
 */
public class VoVoiceHousekeeper {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 姓名
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 语音路径
     */
    private String voiceUrl;
    /**
     * 状态（1.未处理，2.已处理）
     */
    private Integer status;
    /**
     * 备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoVoiceHousekeeper{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", status=" + status +
                ", remake='" + remake + '\'' +
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

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoVoiceHousekeeper() {
    }

    public VoVoiceHousekeeper(Integer id, String roomName, String name, String tel, String voiceUrl, Integer status, String remake) {
        this.id = id;
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.voiceUrl = voiceUrl;
        this.status = status;
        this.remake = remake;
    }
}
