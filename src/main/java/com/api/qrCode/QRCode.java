package com.api.qrCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QRCode {
    /**
     * uid
     */
    private String uid;
    /**
     * 所属楼栋号
     */
    private Integer buildingNo;
    /**
     * 所属楼栋单元号
     */
    private Integer buildingUnitNo;
    /**
     * 楼层号
     */
    private Integer floorNo;
    /**
     * 房间号
     */
    private Integer roomNo;
    /**
     * 起止时间
     */
    private String startTime;
    /**
     * 截止时间
     */
    private String endTime;

}
