package com.api.systemDataBigScreen.service;

import com.api.model.systemDataBigScreen.LilinAccessControlRecordTemplate;

import java.util.Map;

public interface LilinDataPushService {
    String findClientSecretByClientId(String clientId);

    Map<String, Object> pushAccessControlRecord(LilinAccessControlRecordTemplate accessControlRecordTemplate);
}
