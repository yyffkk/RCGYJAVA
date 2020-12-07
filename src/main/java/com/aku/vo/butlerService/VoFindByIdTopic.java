package com.aku.vo.butlerService;

import com.aku.model.butlerService.SysQuestionnaireChoice;

import java.util.Date;
import java.util.List;

/**
 * 题目表信息 findById 回显
 */
public class VoFindByIdTopic {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 答题类型（1.单选，2.多选，3.下拉单选，4.判断题，5.开放题）
     */
    private Integer type;
    /**
     * 题目
     */
    private String topic;
    /**
     * 选择题选项信息集合（仅选择题需要填写）
     */
    private List<VoFindByIdChoice> voFindByIdChoiceList;

    @Override
    public String toString() {
        return "VoFindByIdTopic{" +
                "id=" + id +
                ", type=" + type +
                ", topic='" + topic + '\'' +
                ", voFindByIdChoiceList=" + voFindByIdChoiceList +
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<VoFindByIdChoice> getVoFindByIdChoiceList() {
        return voFindByIdChoiceList;
    }

    public void setVoFindByIdChoiceList(List<VoFindByIdChoice> voFindByIdChoiceList) {
        this.voFindByIdChoiceList = voFindByIdChoiceList;
    }

    public VoFindByIdTopic() {
    }

    public VoFindByIdTopic(Integer id, Integer type, String topic, List<VoFindByIdChoice> voFindByIdChoiceList) {
        this.id = id;
        this.type = type;
        this.topic = topic;
        this.voFindByIdChoiceList = voFindByIdChoiceList;
    }
}
