package com.api.app.dao.butler;

import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppMyArticleBorrowVo;

import java.util.List;

public interface AppArticleBorrowDao {
    /**
     * 查询所有可借物品信息
     * @return app物品所有可借信息集合(当前 quantity 为 正常物品数量)
     */
    List<AppArticleBorrowVo> list();

    /**
     * 根据物品主键id查询借出数量
     * @param id 物品主键id
     * @return 借出数量
     */
    int findBorrowNumById(Integer id);

    /**
     * 查询该用户的所有物品借还信息
     * @param id 用户id
     * @return 我的借还物品信息集合
     */
    List<AppMyArticleBorrowVo> myList(Integer id);

    /**
     * 报损
     * @param userIdAndArticleBorrowId 用户id 和 物品借还主键id
     * @return 影响行数
     */
    int frmLoss(UserIdAndArticleBorrowId userIdAndArticleBorrowId);
}
