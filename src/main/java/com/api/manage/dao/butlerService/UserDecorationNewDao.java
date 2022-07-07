package com.api.manage.dao.butlerService;

import com.api.model.app.AppUserDecorationNew;
import com.api.model.butlerService.UserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;

public interface UserDecorationNewDao {
    /**
     * 查询所有的新版装修管理信息
     * @param userDecorationNewSearch 新版装修管理 搜索条件
     * @return 新版装修管理信息
     */
    List<ButlerUserDecorationNewVo> list(UserDecorationNewSearch userDecorationNewSearch);

    /**
     * 审核装修信息（2.通过/3.驳回）
     * @param appUserDecorationNew app新版装修 model信息
     * @return 影响行数
     */
    int examine(AppUserDecorationNew appUserDecorationNew);

    /**
     * 根据新版装修主键id查询新版装修状态
     * @param id 新版装修主键id
     * @return 新版装修状态
     */
    int findStatusById(Integer id);

    /**
     * 指派完工检查人
     * @param appUserDecorationNew app新版装修 model信息
     * @return 影响行数
     */
    int assign(AppUserDecorationNew appUserDecorationNew);
}
