package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchConveniencePhone;
import com.api.model.butlerService.SysConveniencePhone;
import com.api.model.butlerService.SysConveniencePhoneReminder;
import com.api.vo.butlerService.VoConveniencePhone;

import java.util.List;
import java.util.Map;

public interface SysConveniencePhoneService {
    List<VoConveniencePhone> list(SearchConveniencePhone searchConveniencePhone);

    Map<String, Object> insert(SysConveniencePhone sysConveniencePhone);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysConveniencePhone sysConveniencePhone);

    Map<String, Object> updateReminder(SysConveniencePhoneReminder sysConveniencePhoneReminder);

    Map<String, Object> delete(int[] ids);
}
