package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app最新主题信息Vo list 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppGambitThemeVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主题id
     */
    private Integer id;
    /**
     * 发布人id
     */
    private Integer createId;
    /**
     * 是否可以评论（默认1.可以）（1.可以，0.不可以）
     */
    private Integer isComment;
    /**
     * 该用户是否点赞（1.已点赞，0.未点赞）
     */
    private Integer isLike;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 主题内容
     */
    private String content;
    /**
     * 话题摘要
     */
    private String gambitTitle;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 点赞数量
     */
    private Integer likeNamesNum;
    /**
     * 点赞人信息
     */
    private List<IdAndName> likeNames;
    /**
     * 主题照片内容
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 发布人头像信息
     */
    private List<VoResourcesImg> headSculptureImgUrl;
    /**
     * 评论数量
     */
    private Integer gambitThemeCommentNum;
    /**
     * 主题评论信息集合
     */
    private List<AppGambitThemeCommentVo> gambitThemeCommentVoList;
    /**
     * 浏览量
     */
    private Integer views;


}
