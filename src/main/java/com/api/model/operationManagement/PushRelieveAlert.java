package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 推送灾情解除通知model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PushRelieveAlert implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 预案主键id
     */
    private Integer planAlertId;
    /**
     * 内容说明
     */
    private String contentDescription;
}
