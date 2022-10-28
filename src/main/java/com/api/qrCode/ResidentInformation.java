package com.api.qrCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentInformation {
    /**
     * 楼栋号
     */
    private String buildingNo;
    /**
     * 单元号
     */
    private String buildingUnitNo;
    /**
     * 房间号
     */
    private String roomNo;

}
