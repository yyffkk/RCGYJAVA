package com.api.vo.dataStatistics;

/**
 * 环境卫生任务情况Vo 回显
 */
public class EnvironmentalHealthVo {
    /**
     * 绿化任务总任务数
     */
    private Integer greenTaskTotal;
    /**
     * 绿化任务待完成任务数
     */
    private Integer greenTaskPending;
    /**
     * 绿化任务已完成任务数
     */
    private Integer greenTaskCompleted;
    /**
     * 绿化任务未完成任务数
     */
    private Integer greenTaskUnFinished;
    /**
     * 卫生任务总任务数
     */
    private Integer hygieneTaskTotal;
    /**
     * 卫生任务待完成任务数
     */
    private Integer hygieneTaskPending;
    /**
     * 卫生任务已完成任务数
     */
    private Integer hygieneTaskCompleted;
    /**
     * 卫生任务未完成任务数
     */
    private Integer hygieneTaskUnFinished;

    @Override
    public String toString() {
        return "EnvironmentalHealthVo{" +
                "greenTaskTotal=" + greenTaskTotal +
                ", greenTaskPending=" + greenTaskPending +
                ", greenTaskCompleted=" + greenTaskCompleted +
                ", greenTaskUnFinished=" + greenTaskUnFinished +
                ", hygieneTaskTotal=" + hygieneTaskTotal +
                ", hygieneTaskPending=" + hygieneTaskPending +
                ", hygieneTaskCompleted=" + hygieneTaskCompleted +
                ", hygieneTaskUnFinished=" + hygieneTaskUnFinished +
                '}';
    }

    public Integer getGreenTaskTotal() {
        return greenTaskTotal;
    }

    public void setGreenTaskTotal(Integer greenTaskTotal) {
        this.greenTaskTotal = greenTaskTotal;
    }

    public Integer getGreenTaskPending() {
        return greenTaskPending;
    }

    public void setGreenTaskPending(Integer greenTaskPending) {
        this.greenTaskPending = greenTaskPending;
    }

    public Integer getGreenTaskCompleted() {
        return greenTaskCompleted;
    }

    public void setGreenTaskCompleted(Integer greenTaskCompleted) {
        this.greenTaskCompleted = greenTaskCompleted;
    }

    public Integer getGreenTaskUnFinished() {
        return greenTaskUnFinished;
    }

    public void setGreenTaskUnFinished(Integer greenTaskUnFinished) {
        this.greenTaskUnFinished = greenTaskUnFinished;
    }

    public Integer getHygieneTaskTotal() {
        return hygieneTaskTotal;
    }

    public void setHygieneTaskTotal(Integer hygieneTaskTotal) {
        this.hygieneTaskTotal = hygieneTaskTotal;
    }

    public Integer getHygieneTaskPending() {
        return hygieneTaskPending;
    }

    public void setHygieneTaskPending(Integer hygieneTaskPending) {
        this.hygieneTaskPending = hygieneTaskPending;
    }

    public Integer getHygieneTaskCompleted() {
        return hygieneTaskCompleted;
    }

    public void setHygieneTaskCompleted(Integer hygieneTaskCompleted) {
        this.hygieneTaskCompleted = hygieneTaskCompleted;
    }

    public Integer getHygieneTaskUnFinished() {
        return hygieneTaskUnFinished;
    }

    public void setHygieneTaskUnFinished(Integer hygieneTaskUnFinished) {
        this.hygieneTaskUnFinished = hygieneTaskUnFinished;
    }

    public EnvironmentalHealthVo() {
    }

    public EnvironmentalHealthVo(Integer greenTaskTotal, Integer greenTaskPending, Integer greenTaskCompleted, Integer greenTaskUnFinished, Integer hygieneTaskTotal, Integer hygieneTaskPending, Integer hygieneTaskCompleted, Integer hygieneTaskUnFinished) {
        this.greenTaskTotal = greenTaskTotal;
        this.greenTaskPending = greenTaskPending;
        this.greenTaskCompleted = greenTaskCompleted;
        this.greenTaskUnFinished = greenTaskUnFinished;
        this.hygieneTaskTotal = hygieneTaskTotal;
        this.hygieneTaskPending = hygieneTaskPending;
        this.hygieneTaskCompleted = hygieneTaskCompleted;
        this.hygieneTaskUnFinished = hygieneTaskUnFinished;
    }
}
