package com.api.model.operationManagement;

import java.util.Date;

/**
 * 发布时间和主键id
 */
public class ReleaseDateAndId {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 发布时间
     */
    private Date releaseDate;

    @Override
    public String toString() {
        return "PreviewDateAndId{" +
                "id=" + id +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ReleaseDateAndId() {
    }

    public ReleaseDateAndId(Integer id, Date releaseDate) {
        this.id = id;
        this.releaseDate = releaseDate;
    }
}
