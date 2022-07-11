package com.api.model.butlerApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 管家端出借审核model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ButlerBorrowLendingApproval implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 借还管理主键id
     */
    private Integer id;
    /**
     * 借取状态（0.出借审核失败，1.出借中（出借审核成功））
     */
    private Integer status;
    /**
     * 出借驳回原因
     */
    private String rejectReasons;


}
