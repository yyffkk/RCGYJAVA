package com.api.vo.basicArchives;

import java.util.Date;

/**
 * 查看审核信息
 */
public class VoCheckAuditById {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 申请人id
     */
    private Integer applicantId;
    /**
     * 申请人姓名
     */
    private String name;
    /**
     * 申请身份（1 审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
    /**
     * 审核状态（1.审核中，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 申请人手机号
     */
    private String tel;
    /**
     * 申请人证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 申请人证件号码
     */
    private String idNumber;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;
    /**
     * 业主id
     */
    private String residentId;
    /**
     * 业主名称
     */
    private String residentName;
    /**
     * 业主手机号
     */
    private String residentTel;
    /**
     * 提交申请时间
     */
    private Date createDate;
}
