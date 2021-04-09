package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.*;
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

    /**
     * 添加提醒 消息列表 并返回主键id
     * @param butlerMessage 消息列表信息
     * @return 影响行数
     */
    int insertMessage(ButlerMessage butlerMessage);

    /**
     * 根据借还管理主键id来查询借取人id
     * @param borrowId 借还管理主键id
     * @return 借取人id
     */
    int findBorrowerIdById(Integer borrowId);

    /**
     * 添加消息接收列表
     * @param butlerSending 管家app 消息接收列表
     * @return 影响行数
     */
    int insertSending(ButlerSending butlerSending);

    /**
     * 添加物品明细信息
     * @param butlerArticleDetail 管家app 物品明细 model
     * @return 影响行数
     */
    int insertArticleDetail(ButlerArticleDetail butlerArticleDetail);

    /**
     * 根据物品总类主键id修改物品总类数量，基础上加1递增
     * @param articleId 物品总类主键id
     * @return 影响行数
     */
    int incQuantityByArticleId(Integer articleId);

    /**
     * 根据物品明细主键id删除物品明细
     * @param id 物品明细主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据物品明细主键id查询物品总类id
     * @param id 物品明细主键id
     * @return 物品总类id
     */
    Integer findArticleIdById(int id);

    /**
     * 对该物品总类id进行累减操作-1
     * @param articleId 物品总类id
     * @return 影响行数
     */
    int decQuantityById(int articleId);

    /**
     * 根据物品明细主键id统计借取记录数量
     * @param id 物品明细主键id
     * @return 借取记录数量
     */
    int countRecordNumById(int id);
}
