package com.api.vo.butlerService;

/**
 * 问卷调查报表--选择项
 */
public class VoReportQuestionnaireChoice {
    /**
     * 选择主键id
     */
    private Integer id;
    /**
     * 选项（A，B，C，D）
     */
    private String options;
    /**
     * 选择项答案内容
     */
    private String answer;
    /**
     * 选择人数
     */
    private Integer answerNum;

    @Override
    public String toString() {
        return "VoReportQuestionnaireChoice{" +
                "id=" + id +
                ", options='" + options + '\'' +
                ", answer='" + answer + '\'' +
                ", answerNum=" + answerNum +
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

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public VoReportQuestionnaireChoice() {
    }

    public VoReportQuestionnaireChoice(Integer id, String options, String answer, Integer answerNum) {
        this.id = id;
        this.options = options;
        this.answer = answer;
        this.answerNum = answerNum;
    }
}
