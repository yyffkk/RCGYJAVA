package com.aku.vo.butlerService;

import java.util.Date;

/**
 * 选择题选项信息 findById 回显
 */
public class VoFindByIdChoice {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 选项（A,B,C,D）
     */
    private String options;
    /**
     * 选项对应答案
     */
    private String answer;

    @Override
    public String toString() {
        return "VoFindByIdChoice{" +
                "id=" + id +
                ", options='" + options + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public VoFindByIdChoice() {
    }

    public VoFindByIdChoice(Integer id, String options, String answer) {
        this.id = id;
        this.options = options;
        this.answer = answer;
    }
}
