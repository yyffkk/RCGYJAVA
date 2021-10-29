package com.api.vo.systemDataBigScreen;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SDTSActivityVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主办方名称
     */
    private String sponsorName;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 联系人
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名结束时间
     */
    private Date registrationEndTime;
    /**
     * 活动开始时间
     */
    private Date activityStartTime;
    /**
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 参与人数
     */
    private Integer participantsNumber;
    /**
     * 活动照片路径集合
     */
    private List<VoResourcesImg> imgUrls;
}
