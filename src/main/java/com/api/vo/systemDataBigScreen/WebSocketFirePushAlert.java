package com.api.vo.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * websocket 火灾推送通知
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketFirePushAlert implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 设备号
     */
    private String deviceNo;
    /**
     * 报警号
     */
    private String alarmNo;
    /**
     * 数值报警，还是状态报警
     * (C:数值报警，X:状态报警)
     */
    private String alarmType;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 报警时间
     */
    private String time;
    /**
     * 报警类型：1.火灾报警（消防），2.设备报警
     */
    private Integer type;
}
