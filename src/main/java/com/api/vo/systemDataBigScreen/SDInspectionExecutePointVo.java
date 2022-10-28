package com.api.vo.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统数据 巡更执行点 Vo 回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SDInspectionExecutePointVo {
    /**
     * 巡检点Id
     */
    private Integer id;
    /**
     * 巡检点编号
     */
    private String code;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 巡检点完成时间
     */
    private Date completeDate;


}
