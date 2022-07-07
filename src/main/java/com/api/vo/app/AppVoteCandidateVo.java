package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 投票候选人信息
 */
public class AppVoteCandidateVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 选项名称
     */
    private String name;
    /**
     * 投票总数
     */
    private Integer total;
    /**
     * 选项照片资源
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppVoteCandidateVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppVoteCandidateVo() {
    }

    public AppVoteCandidateVo(Integer id, String name, Integer total, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.imgUrls = imgUrls;
    }
}
