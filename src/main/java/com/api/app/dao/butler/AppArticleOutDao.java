package com.api.app.dao.butler;

import com.api.model.app.AppArticleOut;
import com.api.vo.app.AppMovingCompanyVo;

import java.util.List;

public interface AppArticleOutDao {
    /**
     * 提交物品出户信息
     * @param appArticleOut app物品出户信息
     * @return 影响行数
     */
    int submit(AppArticleOut appArticleOut);

    /**
     * 获取搬家公司手机号
     * @return 搬家公司信息
     */
    List<AppMovingCompanyVo> getMovingCompanyTel();
}
