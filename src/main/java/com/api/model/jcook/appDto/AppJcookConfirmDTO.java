package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * app确认收货DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppJcookConfirmDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单主键id
     */
    private Integer orderId;
    /**
     * 用户主键id
     */
    private Integer id;
}
