package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.vo.butlerService.VoUserAccessCard;
import com.aku.vo.butlerService.VoUserDecoration;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationTrackRecord;

import java.util.List;

public interface UserDecorationService {
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);

    List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id);

    List<VoUserAccessCard> userAccessCardList(Integer id);

    List<VoUserDecorationTrackRecord> decorationTrackRecordList(Integer id);
}
