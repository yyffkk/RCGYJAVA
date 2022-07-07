package com.api.app.dao.butler;

import com.api.vo.app.AppCommunityIntroductionVo;

public interface AppCommunityIntroductionDao {
    /***
     * 查询开启的社区介绍模版
     * @return 社区介绍模版
     */
    AppCommunityIntroductionVo findEnable();
}
