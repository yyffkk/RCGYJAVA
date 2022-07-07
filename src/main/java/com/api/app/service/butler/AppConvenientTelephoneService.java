package com.api.app.service.butler;

import com.api.model.butlerService.SearchConveniencePhone;
import com.api.vo.app.AppConvenientTelephoneVo;

import java.util.List;

public interface AppConvenientTelephoneService {
    List<AppConvenientTelephoneVo> list(SearchConveniencePhone searchConveniencePhone);
}
