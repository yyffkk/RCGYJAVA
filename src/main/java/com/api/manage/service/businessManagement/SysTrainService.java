package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchTrain;
import com.api.model.businessManagement.SysTrain;
import com.api.vo.businessManagement.VoTrain;

import java.util.List;
import java.util.Map;

public interface SysTrainService {
    List<VoTrain> list(SearchTrain searchTrain);

    Map<String, Object> insert(SysTrain sysTrain);

    Map<String, Object> delete(int[] ids);
}
