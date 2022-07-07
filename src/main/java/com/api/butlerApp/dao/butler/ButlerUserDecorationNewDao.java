package com.api.butlerApp.dao.butler;

import com.api.model.app.AppUserDecorationNew;
import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.model.butlerApp.ButlerUserDecorationNewCheck;
import com.api.vo.butlerApp.ButlerUserDecorationNewCheckVo;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;

public interface ButlerUserDecorationNewDao {
    /**
     * 查询所有的装修管理信息
     * @param butlerUserDecorationNewSearch 管家app 新版装修搜索条件
     * @return map
     */
    List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch);

    /**
     * 提交检查报告
     * @param butlerUserDecorationNewCheck 管家app 新版装修检查信息model
     * @return 影响行数
     */
    int submitReport(ButlerUserDecorationNewCheck butlerUserDecorationNewCheck);

    /**
     * 修改检查状态和最后一次完工检查是否合格（1.合格，0.不合格）
     * @param appUserDecorationNew app新版装修 model信息
     * @return 影响行数
     */
    int updateLastCheckInfo(AppUserDecorationNew appUserDecorationNew);

    /**
     * 根据新版装修主键id查询新版装修状态
     * @param decorationNewId 新版装修主键id
     * @return 新版装修状态
     */
    int findStatusById(Integer decorationNewId);

    /**
     * 根据新版装修主键id 查询 完工检查记录
     * @param id 新版装修主键id
     * @return 完工检查记录
     */
    List<ButlerUserDecorationNewCheckVo> findCheckDetailById(Integer id);
}
