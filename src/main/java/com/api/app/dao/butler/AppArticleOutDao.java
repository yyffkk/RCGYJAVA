package com.api.app.dao.butler;

import com.api.model.app.AppArticleOut;
import com.api.model.app.UserIdAndArticleOutId;
import com.api.vo.app.AppArticleOutVo;
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

    /**
     * 查询当前用户所有的物品出户信息
     * @param id 当前用户主键id
     * @return 物品出户信息集合
     */
    List<AppArticleOutVo> list(Integer id);

    /**
     * 假删除物品出户信息
     * @param userIdAndArticleOutId 用户主键id 和 物品出户主键id
     * @return 影响行数
     */
    int falseDelete(UserIdAndArticleOutId userIdAndArticleOutId);
}
