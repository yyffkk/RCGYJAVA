package com.api.manage.service.butlerService;

import com.api.model.butlerService.SysDoorQRCode;

import java.util.Date;
import java.util.Map;

public interface SysDoorQRCodeService {
    Map<String, Object> addQrCode(SysDoorQRCode sysDoorQRCode);

    Map<String, Object> getQrCode(Date startTime, Date endTime);
}
