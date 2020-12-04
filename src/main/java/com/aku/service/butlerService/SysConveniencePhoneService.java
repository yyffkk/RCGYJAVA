package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhoneReminder;
import com.aku.vo.butlerService.VoConveniencePhone;

import java.util.List;
import java.util.Map;

public interface SysConveniencePhoneService {
    List<VoConveniencePhone> list(SearchConveniencePhone searchConveniencePhone);

    Map<String, Object> insert(SysConveniencePhone sysConveniencePhone);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysConveniencePhone sysConveniencePhone);

    Map<String, Object> updateReminder(SysConveniencePhoneReminder sysConveniencePhoneReminder);

}
