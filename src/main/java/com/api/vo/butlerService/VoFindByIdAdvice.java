package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 咨询建议详情
 */
public class VoFindByIdAdvice {
    /**
     * 咨询建议主键id
     */
    private Integer id;
    /**
     * 类型(1.咨询，2.建议,3.投诉，4.建议)
     */
    private Integer type;
    /**
     * 咨询建议内容
     */
    private String content;
    /**
     * 评分数1-10分
     */
    private Integer score;
    /**
     * 照片信息集合
     */
    private List<VoResourcesImg> imgUrl;
    /**
     * 反馈信息集合
     */
    private List<VoUserAdviceDetail> voUserAdviceDetailList;

    @Override
    public String toString() {
        return "VoFindByIdAdvice{" +
                "id=" + id +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", imgUrl=" + imgUrl +
                ", voUserAdviceDetailList=" + voUserAdviceDetailList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<VoUserAdviceDetail> getVoUserAdviceDetailList() {
        return voUserAdviceDetailList;
    }

    public void setVoUserAdviceDetailList(List<VoUserAdviceDetail> voUserAdviceDetailList) {
        this.voUserAdviceDetailList = voUserAdviceDetailList;
    }

    public VoFindByIdAdvice() {
    }

    public VoFindByIdAdvice(Integer id, Integer type, String content, Integer score, List<VoResourcesImg> imgUrl, List<VoUserAdviceDetail> voUserAdviceDetailList) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.score = score;
        this.imgUrl = imgUrl;
        this.voUserAdviceDetailList = voUserAdviceDetailList;
    }
}
