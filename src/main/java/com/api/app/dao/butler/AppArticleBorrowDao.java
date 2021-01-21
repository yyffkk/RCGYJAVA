package com.api.app.dao.butler;

import com.api.vo.app.AppArticleBorrowVo;

import java.util.List;

public interface AppArticleBorrowDao {
    /**
     * 查询所有可借物品信息
     * @return app物品所有可借信息集合
     */
    List<AppArticleBorrowVo> list();

    /**
     * 根据物品主键id查询借出数量
     * @param id 物品主键id
     * @return 借出数量
     */
    int findBorrowNumById(Integer id);
}
