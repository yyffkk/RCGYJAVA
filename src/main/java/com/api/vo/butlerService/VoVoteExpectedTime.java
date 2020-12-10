package com.api.vo.butlerService;

/**
 * 设置的预期时间间隔
 */
public class VoVoteExpectedTime {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 时间长度
     */
    private Integer longs;
    /**
     * 时间类型（1.分钟，2.小时，3.天）
     */
    private Integer type;

    @Override
    public String toString() {
        return "VoVoteExpectedTime{" +
                "id=" + id +
                ", longs=" + longs +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLongs() {
        return longs;
    }

    public void setLongs(Integer longs) {
        this.longs = longs;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public VoVoteExpectedTime() {
    }

    public VoVoteExpectedTime(Integer id, Integer longs, Integer type) {
        this.id = id;
        this.longs = longs;
        this.type = type;
    }
}
