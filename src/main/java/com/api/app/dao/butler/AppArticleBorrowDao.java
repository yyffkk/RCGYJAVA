package com.api.app.dao.butler;

import com.api.model.app.AppArticleBorrow;
import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.vo.app.AppArticleBorrowDetailVo;
import com.api.vo.app.AppArticleBorrowReturnVo;
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

    /**
     * 根据物品总类主键id查询未借出的物品明细
     * @param articleId 物品总类主键id
     * @return 未借出的物品明细
     */
    List<AppArticleBorrowDetailVo> findDetailById(Integer articleId);

    /**
     * 借取物品(添加物品借还信息)
     * @param appArticleBorrow 物品借还信息
     * @return 影响行数
     */
    int borrow(AppArticleBorrow appArticleBorrow);

    /**
     * 查询出借中或待检查的物品明细主键id数组
     * @return 正在出借中或待检查的物品明细主键id数组
     */
    List<Integer> findBorrowOrCheckArticleId();

    /**
     * 根据用户主键id查询需要归还物品信息
     * @param id 用户主键id
     * @return 需要归还物品信息
     */
    List<AppArticleBorrowReturnVo> findBorrowByUserId(Integer id);

    /**
     * 查询该用户出借中的物品明细主键id数组
     * @param userId 用户主键id
     * @return 物品借还主键id数组
     */
    List<Integer> findBorrowArticleIdByUserId(Integer userId);

    /**
     * 根据借还主键id修改物品借还归还状态信息
     * @param appArticleBorrow 物品借还信息
     * @return 影响行数
     */
    int articleReturn(AppArticleBorrow appArticleBorrow);
}
