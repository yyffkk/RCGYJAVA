package com.api.app.dao.butler;

import com.api.model.app.AppUserDecorationNew;
import com.api.model.app.SearchAppUserDecorationNew;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;

public interface AppUserDecorationNewDao {
    /**
     * 查询所有的新版装修信息
     * @param searchAppUserDecorationNew 新版装修 搜索条件
     * @return 新版装修信息
     */
    List<ButlerUserDecorationNewVo> list(SearchAppUserDecorationNew searchAppUserDecorationNew);

    /**
     * 添加新版装修信息（申请装修）
     * @param appUserDecorationNew app新版装修 model信息
     * @return 影响行数
     */
    int insert(AppUserDecorationNew appUserDecorationNew);
}
