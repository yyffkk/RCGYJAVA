package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 投票详情Vo
 */
public class AppVoteDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态（1.未开始，2.进行中，3.已结束，4.已投票）
     */
    private Integer status;
    /**
     * 所有候选人投票总数
     */
    private Integer totals;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 投票候选人
     */
    private List<AppVoteCandidateVo> appVoteCandidateVos;

    @Override
    public String toString() {
        return "AppVoteDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", totals=" + totals +
                ", imgUrls=" + imgUrls +
                ", appVoteCandidateVos=" + appVoteCandidateVos +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public List<AppVoteCandidateVo> getAppVoteCandidateVos() {
        return appVoteCandidateVos;
    }

    public void setAppVoteCandidateVos(List<AppVoteCandidateVo> appVoteCandidateVos) {
        this.appVoteCandidateVos = appVoteCandidateVos;
    }

    public AppVoteDetailVo() {
    }

    public AppVoteDetailVo(Integer id, String title, String content, Integer status, Integer totals, List<VoResourcesImg> imgUrls, List<AppVoteCandidateVo> appVoteCandidateVos) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.totals = totals;
        this.imgUrls = imgUrls;
        this.appVoteCandidateVos = appVoteCandidateVos;
    }
}
