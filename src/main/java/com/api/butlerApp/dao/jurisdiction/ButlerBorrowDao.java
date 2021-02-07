package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerArticle;
import com.api.model.butlerApp.ButlerArticleDetail;
import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.model.butlerApp.ButlerSubmitCheck;
import com.api.vo.butlerApp.*;

import java.util.List;

public interface ButlerBorrowDao {
    /**
     * 查询所有的借还信息（包含条件搜索）
     * @param butlerBorrowSearch 管家app 借还管理搜索条件
     * @return 借还信息集合
     */
    List<ButlerBorrowVo> list(ButlerBorrowSearch butlerBorrowSearch);

    /**
     * 根据借还管理主键id查询检查信息
     * @param articleBorrowId 借还管理主键id
     * @return 管家app 检查信息Vo findById 回显
     */
    ButlerCheckItemsVo checkItems(Integer articleBorrowId);

    /**
     * 根据借还管理主键id修改借还管理状态
     * @param butlerSubmitCheck 管家app 提交检查信息model
     * @return 影响行数
     */
    int updateSAEByBorrowId(ButlerSubmitCheck butlerSubmitCheck);

    /**
     * 根据物品明细主键id修改物品明细状态
     * @param butlerSubmitCheck 管家app 提交检查信息model
     * @return 影响行数
     */
    int updateStatusByDetailId(ButlerSubmitCheck butlerSubmitCheck);

    /**
     * 根据借还管理主键id查询借还管理状态信息
     * @param articleBorrowId 借还管理主键id
     * @return 借还管理状态
     */
    ButlerBorrowVo findStatusByBorrowId(Integer articleBorrowId);

    /**
     * 查询全部物品
     * @return 全部物品信息
     */
    List<ButlerArticleVo> articleList();

    /**
     * 根据物品主键id 查询 借取数量
     * @param id 物品主键id
     * @return 借取数量
     */
    int findBorrowNumById(Integer id);

    /**
     * 新增总类
     * @param butlerArticle 管家app 物品管理model
     * @return 影响行数
     */
    int insertArticle(ButlerArticle butlerArticle);

    /**
     * 根据物品明细id 查询物品信息
     * @param articleDetailId 物品明细id
     * @return 物品明细 Vo findById 回显
     */
    ButlerArticleDetailFBIVo findById(Integer articleDetailId);

    /**
     * 根据物品明细id查询出借数量
     * @param id 物品明细id
     * @return 出借数量
     */
    int countBorrowByADId(Integer id);

    /**
     * 根据物品主键id查询所有的物品明细信息
     * @param articleId 物品主键id
     * @return 物品明细信息集合
     */
    List<ButlerArticleDetailVo> articleDetailList(Integer articleId);

    /**
     * 修改物品明细信息
     * @param butlerArticleDetail 管家app 物品明细 model
     * @return 影响行数
     */
    int updateArticleDetail(ButlerArticleDetail butlerArticleDetail);

}
