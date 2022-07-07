package com.api.vo.butlerService;

import java.util.Date;

/**
 * 客户评价Vo
 */
public class VoEvaluation {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 评价打分1-10
     */
    private Integer evaluation_level;
    /**
     * 评价内容
     */
    private String evaluation_content;
    /**
     * 评价时间
     */
    private Date evaluation_date;

    @Override
    public String toString() {
        return "VoEvaluation{" +
                "id=" + id +
                ", evaluation_level=" + evaluation_level +
                ", evaluation_content='" + evaluation_content + '\'' +
                ", evaluation_date=" + evaluation_date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaluation_level() {
        return evaluation_level;
    }

    public void setEvaluation_level(Integer evaluation_level) {
        this.evaluation_level = evaluation_level;
    }

    public String getEvaluation_content() {
        return evaluation_content;
    }

    public void setEvaluation_content(String evaluation_content) {
        this.evaluation_content = evaluation_content;
    }

    public Date getEvaluation_date() {
        return evaluation_date;
    }

    public void setEvaluation_date(Date evaluation_date) {
        this.evaluation_date = evaluation_date;
    }

    public VoEvaluation() {
    }

    public VoEvaluation(Integer id, Integer evaluation_level, String evaluation_content, Date evaluation_date) {
        this.id = id;
        this.evaluation_level = evaluation_level;
        this.evaluation_content = evaluation_content;
        this.evaluation_date = evaluation_date;
    }
}
