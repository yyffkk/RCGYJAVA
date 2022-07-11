package com.api.model.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 预案推送通知内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanPushAlert implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 报警发生时间
     */
    private Date alarmOccurrenceTime;
    /**
     * 推送时间
     */
    private Date pushTime;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 预案内容
     */
    private String planContent;
    /**
     * 报警内容
     */
    private String alarmContent;
}
