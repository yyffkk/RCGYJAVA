package com.api.vo.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 预案报警Vo list 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoPlanAlarm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 报警内容
     */
    private String alarmContent;
    /**
     * 预案内容
     */
    private String planContent;
    /**
     * 报警发生时间
     */
    private Date alarmOccurrenceTime;
}
