package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
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

    List<VoUserDecorationTrackRecord> decorationFinishRecordList(Integer id);
}
