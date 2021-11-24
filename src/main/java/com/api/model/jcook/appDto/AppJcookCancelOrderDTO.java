package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * app取消订单 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppJcookCancelOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单主键id
     */
    private Integer orderId;
    /**
     * 取消原因。1:订单不能按 预计 时间送达 2:其他 渠道价格更 低 3:该商 品降价了 4:不想买了 5: 其他原因 6:操作有误(商 品、地址等选错) 7: 商品 无货 100:其他
     */
    private Integer cancelReasonCode;
}
