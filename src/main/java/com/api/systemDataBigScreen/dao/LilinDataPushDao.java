package com.api.systemDataBigScreen.dao;

import com.api.model.systemDataBigScreen.LilinAccessControlRecord;

public interface LilinDataPushDao {
    /**
     * 根据clientId查询clientSecret
     * @param clientId clientId
     * @return clientSecret
     */
    String findClientSecretByClientId(String clientId);

    /**
     * 推送门禁记录报告
     * @param data 门禁记录数据
     * @return 影响行数
     */
    int pushAccessControlRecord(LilinAccessControlRecord data);
}
