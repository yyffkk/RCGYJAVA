package com.api.model.butlerService;

/**
 * 便民电话定时检查
 */
public class SysConveniencePhoneReminder {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 提醒间隔(1.一个月，2.半年)
     */
    private Integer reminderInterval;
    /**
     * 提醒内容
     */
    private String reminderContent;

    @Override
    public String toString() {
        return "SysConveniencePhoneReminder{" +
                "id=" + id +
                ", reminderInterval=" + reminderInterval +
                ", reminderContent='" + reminderContent + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReminderInterval() {
        return reminderInterval;
    }

    public void setReminderInterval(Integer reminderInterval) {
        this.reminderInterval = reminderInterval;
    }

    public String getReminderContent() {
        return reminderContent;
    }

    public void setReminderContent(String reminderContent) {
        this.reminderContent = reminderContent;
    }

    public SysConveniencePhoneReminder() {
    }

    public SysConveniencePhoneReminder(Integer id, Integer reminderInterval, String reminderContent) {
        this.id = id;
        this.reminderInterval = reminderInterval;
        this.reminderContent = reminderContent;
    }
}
