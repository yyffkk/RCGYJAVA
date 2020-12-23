package com.api.service.butlerService;

import com.api.model.butlerService.SearchVoiceHousekeeper;
import com.api.model.butlerService.VoiceHousekeeperRemake;
import com.api.vo.butlerService.VoVoiceHousekeeper;

import java.util.List;
import java.util.Map;

public interface SysVoiceHousekeeperService {
    List<VoVoiceHousekeeper> list(SearchVoiceHousekeeper searchVoiceHousekeeper);

    Map<String, Object> insertRemake(VoiceHousekeeperRemake voiceHousekeeperRemake);
}
