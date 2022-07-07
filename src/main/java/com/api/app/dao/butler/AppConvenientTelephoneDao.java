package com.api.app.dao.butler;

import com.api.model.butlerService.SearchConveniencePhone;
import com.api.vo.app.AppConvenientTelephoneVo;

import java.util.List;

public interface AppConvenientTelephoneDao {
    List<AppConvenientTelephoneVo> list(SearchConveniencePhone searchConveniencePhone);
}
