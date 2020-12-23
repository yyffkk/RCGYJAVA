package com.api.dao.butlerService;

import com.api.model.butlerService.SearchVoiceHousekeeper;
import com.api.model.butlerService.VoiceHousekeeperRemake;
import com.api.vo.butlerService.VoVoiceHousekeeper;

import java.util.List;

public interface SysVoiceHousekeeperDao {
    /**
     * 查询所有的语音管家信息 （包含条件搜索）
     * @param searchVoiceHousekeeper 搜索条件
     * @return 语音管家信息集合
     */
    List<VoVoiceHousekeeper> list(SearchVoiceHousekeeper searchVoiceHousekeeper);

    /**
     *添加备注信息
     * @param voiceHousekeeperRemake 备注信息
     * @return 影响行数
     */
    int insertRemake(VoiceHousekeeperRemake voiceHousekeeperRemake);
}
