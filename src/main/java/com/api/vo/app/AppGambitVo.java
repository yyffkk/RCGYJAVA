package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app话题信息Vo list 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppGambitVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 话题照片资源
     */
    private List<VoResourcesImg> imgUrl;
    /**
     * 热度（活跃度）
     */
    private Integer activityNum;
    /**
     * 动态主题数
     */
    private Integer themeNum;
    /**
     * 评论数
     */
    private Integer sumCommentNum;

}
