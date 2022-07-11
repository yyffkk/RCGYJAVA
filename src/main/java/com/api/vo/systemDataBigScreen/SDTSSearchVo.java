package com.api.vo.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索信息 Vo 回显（触摸屏）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SDTSSearchVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动信息集合
     */
    List<SDTSActivityVo> sdtsActivityVoList;
    /**
     * 通告信息集合
     */
    List<SDTSAnnouncementVo> sdtsAnnouncementVoList;
    /**
     * 资讯信息集合
     */
    List<SDTSNewVo> sdtsNewVoList;
}
