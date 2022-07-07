package com.api.model.butlerService;

/**
 * 语音管家 备注信息
 */
public class VoiceHousekeeperRemake {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 备注信息
     */
    private String remake;

    @Override
    public String toString() {
        return "VoiceHousekeeperRemake{" +
                "id=" + id +
                ", remake='" + remake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoiceHousekeeperRemake() {
    }

    public VoiceHousekeeperRemake(Integer id, String remake) {
        this.id = id;
        this.remake = remake;
    }
}
