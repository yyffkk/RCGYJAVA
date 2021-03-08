package com.api.manage.dao.butlerService;

import com.api.model.butlerService.*;
import com.api.vo.butlerService.*;

import java.math.BigDecimal;
import java.util.List;

public interface UserDecorationDao {
    /**
     * 查询装修信息（包含条件搜索）
     * @param searchUserDecoration 搜索条件
     * @return 装修管理 Vo list回显
     */
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);

    /**
     * 查询所有装修人员情况
     * @param id 装修主键id
     * @return 装修人员情况 Vo list
     */
    List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id);

    /**
     * 查询所有跟踪检查记录
     * @param id 装修主键id
     * @return 跟踪检查记录Vo 回显list
     */
    List<VoUserDecorationTrackRecord> decorationTrackRecordList(Integer id);

    /**
     * 查询所有装修跟踪记录明细表
     * @param id 装修跟踪记录id
     * @return 跟踪检查记录明细表Vo 回显list
     */
    List<VoUserDecorationTrackRecordDetail> decorationTrackRecordDetailList(Integer id);

    /**
     * 查询所有完工检查记录
     * @param id 装修主键id
     * @return  完工检查记录Vo 回显list
     */
    List<VoUserDecorationTrackRecord> decorationFinishRecordList(Integer id);

    /**
     * 根据装修信息主键id删除装修信息
     * @param id 装修信息主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据装修信息主键id删除装修门禁卡关联信息
     * @param id 装修信息主键id
     * @return 影响行数
     */
    int deleteDecorationAccessCard(int id);

    /**
     * 根据装修信息主键id查询装修跟踪记录表
     * @param id 装修信息主键id
     * @return 装修跟踪记录表 Vo list
     */
    List<VoUserDecorationTrackRecord> findTrackRecordByDecorationId(int id);

    /**
     * 根据装修跟踪记录表主键id删除装修跟踪记录明细表
     * @param id 装修跟踪记录表主键id
     * @return 影响行数
     */
    int deleteTrackRecordDetail(Integer id);

    /**
     * 根据装修信息主键id删除装修跟踪记录表
     * @param id 装修信息主键id
     * @return 影响行数
     */
    int deleteTrackRecord(int id);


    /**
     * 根据装修信息主键id查询装修门禁卡关联信息
     * @param id 装修信息主键id
     * @return 装修门禁卡关联信息集合
     */
    List<UserDecorationAccessCard> findUDACByDecorationId(int id);

    /**
     * 批量删除门禁卡信息
     * @param accessCartId 门禁卡id
     * @return 影响行数
     */
    int deleteAccessCard(Integer accessCartId);

    /**
     * 根据装修跟踪记录表主键id查询装修跟踪记录明细表
     * @param id 装修跟踪记录表主键id
     * @return 装修跟踪记录明细表集合
     */
    List<UserDecorationTrackRecordDetail> findUDTRDByTrackRecordId(Integer id);

    /**
     * 作废装修信息
     * @param id 装修信息主键id
     * @return 影响行数
     */
    int invalid(int id);

    /**
     * 查询今日预计发起装修数量
     * @return 今日预计发起装修数量
     */
    Integer countDecorationNow();

    /**
     * 查询未执行的家庭装修数量
     * @return 未执行的家庭装修数量
     */
    Integer countPerformed();

    /**
     * 当装修状态为未开始，根据房产id查询装修id
     * @param buildingUnitEstateId 房产id
     * @return 装修id
     */
    Integer findIdByEstateId(Integer buildingUnitEstateId);

    /**
     * 查询所有的检查内容信息
     * @return 检查内容信息集合
     */
    List<VoUserDecorationChecksContent> findAllChecksContent();

    /**
     * 添加检查内容信息
     * @param checksContent 装修检查内容
     * @return 影响行数
     */
    int insertCheckContent(UserDecorationChecksContent checksContent);

    /**
     * 修改检查内容信息
     * @param checksContent 装修检查内容
     * @return 影响行数
     */
    int updateCheckContent(UserDecorationChecksContent checksContent);

    /**
     * 删除检查内容信息
     * @param checkContentId 检查内容主键id
     * @return 影响行数
     */
    int deleteCheckContent(Integer checkContentId);

    /**
     * 删除全部装修须知doc文件
     * @return 影响行数
     */
    int deleteAllDoc();

    /**
     * 添加装修须知doc文件
     * @param userDecorationDoc 装修须知Doc文件
     * @return 影响行数
     */
    int insertDoc(UserDecorationDoc userDecorationDoc);

    /**
     * 查询装修须知doc路径
     * @return doc路径集合
     */
    List<String> findDocUrl();

    /**
     * 根据装修主键id查询装修押金
     * @param id 装修主键id
     * @return 装修押金
     */
    VoDepositPriceAndId findDepositById(Integer id);

    /**
     * 根据押金管理主键id查询装修附加费用
     * @param id 押金管理主键id
     * @return 装修附加费用集合
     */
    List<VoDepositAdditionalCost> findDepositAdditionalCost(Integer id);

    /**
     * 根据装修主键id查询退还押金
     * @param id 装修主键id
     * @return 退还押金
     */
    BigDecimal findRefundDeposit(Integer id);

    /**
     * 根据装修主键id查询未归还门禁卡数量
     * @param id 装修主键id
     * @return 未归还门禁卡数量
     */
    int findNoReturnAccessCard(Integer id);

    /**
     * 修改装修信息
     * @param userDecoration 装修model信息
     * @return 影响行数
     */
    int update(UserDecoration userDecoration);
}
