package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.model.butlerService.UserDecorationAccessCard;
import com.aku.model.butlerService.UserDecorationTrackRecordDetail;
import com.aku.vo.butlerService.VoUserDecoration;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationTrackRecord;
import com.aku.vo.butlerService.VoUserDecorationTrackRecordDetail;

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

    List<UserDecorationTrackRecordDetail> findUDTRDByTrackRecordId(Integer id);

    int invalid(int id);
}
