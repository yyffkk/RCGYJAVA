package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchUserDecoration;
import com.api.model.butlerService.UserDecoration;
import com.api.model.butlerService.UserDecorationPersonnel;
import com.api.model.butlerService.UserDecorationChecksContent;
import com.api.vo.butlerService.VoUserAccessCard;
import com.api.vo.butlerService.VoUserDecoration;
import com.api.vo.butlerService.VoUserDecorationPersonnel;
import com.api.vo.butlerService.VoUserDecorationTrackRecord;

import java.util.List;
import java.util.Map;

public interface UserDecorationService {
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);

    List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id);

    Map<String, Object> decorationData(Integer id);

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

    Map<String, Object> findAllChecksContent();

    Map<String, Object> insertCheckContent(UserDecorationChecksContent trackChecksContent);

    Map<String, Object> updateCheckContent(UserDecorationChecksContent trackChecksContent);

    Map<String, Object> deleteCheckContent(Integer checkContentId);

    Map<String, Object> updateDecoration(UserDecoration userDecoration);
}
