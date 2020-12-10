package com.api.vo.butlerService;

/**
 * 开放题内容报表详情
 */
public class VoReportQuestionnaireShort {
    /**
     * 答题主键id
     */
    private Integer id;
    /**
     * 答题人姓名
     */
    private String name;
    /**
     * 答题人答案内容
     */
    private String answer;

    @Override
    public String toString() {
        return "VoReportQuestionnaireShort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answer='" + answer + '\'' +
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public VoReportQuestionnaireShort() {
    }

    public VoReportQuestionnaireShort(Integer id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;
    }
}
