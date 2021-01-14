package com.api.app.service.my;

import com.api.model.basicArchives.ResidentIdAndEstateId;

import java.util.Map;

public interface MyHouseService {
    Map<String, Object> authentication(ResidentIdAndEstateId residentIdAndEstateId);
}
