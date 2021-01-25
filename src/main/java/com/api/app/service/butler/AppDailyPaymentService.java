package com.api.app.service.butler;

import com.api.vo.app.AppDailyPaymentVo;

import java.util.List;

public interface AppDailyPaymentService {
    List<AppDailyPaymentVo> list(Integer estateId);
}
