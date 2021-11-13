package com.api.model.butlerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取h5页面二维码model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHtmlCode implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 生效时间戳开始
     */
    private Date startTime;
    /**
     * 生效时间戳结束
     */
    private Date endTime;
    /**
     * 访客手机号
     */
    private String tel;
}
