package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerChecksContentVo;
import com.api.vo.butlerApp.ButlerDecorationFBIVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.butlerApp.ButlerTrackInspectionFBIVo;

import java.util.List;

public interface ButlerDecorationDao {
    /**
     * 查询装修管理信息list列表
     * @param decorationSearch 管家app 装修管理搜索条件
     * @return 管家app 装修管理Vo list 回显
     */
    List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch);

    /**
     * 根据装修主键id查询装修信息
     * @param decorationId 装修主键id
     * @return 装修信息
     */
    ButlerDecorationFBIVo findById(Integer decorationId);

    /**
     * 根据装修主键id查询检查周期信息
     * @param decorationId 装修主键id
     * @return 检查周期信息
     */
    ButlerTrackInspectionFBIVo findInspectionById(Integer decorationId);

    /**
     * 查询检查内容信息
     * @return 检查内容信息集合
     */
    List<ButlerChecksContentVo> findChecksContent();
}
