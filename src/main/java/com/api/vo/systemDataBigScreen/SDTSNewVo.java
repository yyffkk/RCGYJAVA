package com.api.vo.systemDataBigScreen;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 资讯信息（触摸屏）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SDTSNewVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 资讯照片路径集合
     */
    private List<VoResourcesImg> imgUrls;
}
