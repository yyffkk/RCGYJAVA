package com.api.qrCode;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDataList {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 子模块类型
     */
    private String modelType;
    /**
     * 子模块区域位置
     */
    private String modelRegionalLocation;
    /**
     * 楼栋
     */
    private String building;
    /**
     * 单元
     */
    private String unit;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 设备编号
     */
    private String deviceId;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备ip
     */
    private String deviceIp;
    /**
     * 设备在线状态
     */
    private String deviceStatus;
    /**
     * 三维点位（X）
     */
    private String threeDimensionalX;
    /**
     * 三维点位（Y）
     */
    private String threeDimensionalY;
    /**
     * 三维点位（Z）
     */
    private String threeDimensionalZ;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /**
     * 当前报警内容
     */
    private String content;
    /**
     * 操作状态
     */
    private String operatingState;
    /**
     * 备注1
     */
    private String remark1;
    /**
     * 备注2
     */
    private String remark2;
    /**
     * 备注3
     */
    private String remark3;
    /**
     * 建筑相机IP
     */
    private String buildingCameraIp;
    /**
     * 报警铃声
     */
    private String alarmBell;
}
