package com.api.vo.systemDataBigScreen;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 系统数据 公告信息集合（发布时间、标题、内容）（触摸屏）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SDTSAnnouncementVo {
    /**
     * 公告主键id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 公告照片路径集合
     */
    private List<VoResourcesImg> imgUrls;
}
