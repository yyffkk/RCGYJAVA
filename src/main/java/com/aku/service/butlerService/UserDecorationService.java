package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.model.butlerService.UserDecorationPersonnel;
import com.aku.vo.basicArchives.VoIds;
import com.aku.vo.butlerService.VoUserAccessCard;
import com.aku.vo.butlerService.VoUserDecoration;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationTrackRecord;

import java.util.List;
import java.util.Map;

public interface UserDecorationService {
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);

    List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id);

    List<VoUserAccessCard> userAccessCardList(Integer id);

    List<VoUserDecorationTrackRecord> decorationTrackRecordList(Integer id);

    List<VoUserDecorationTrackRecord> decorationFinishRecordList(Integer id);

    Map<String, Object> insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    Map<String, Object> deleteDecorationPersonnel(int[] ids);

    Map<String, Object> findByIdDecorationPersonnel(Integer id);

    Map<String, Object> updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> invalid(int[] ids);

    Map<String, Object> countDecorationNow();

    Map<String, Object> countPerformed();
}
