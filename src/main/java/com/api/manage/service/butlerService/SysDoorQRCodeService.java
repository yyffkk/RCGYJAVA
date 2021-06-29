package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchDoorQRCode;
import com.api.model.butlerService.SysDoorQRCode;
import com.api.vo.butlerService.VoDoorQRCode;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysDoorQRCodeService {
    Map<String, Object> addQrCode(SysDoorQRCode sysDoorQRCode);

    Map<String, Object> getQrCode(Date startTime, Date endTime, String tel);

    Map<String, Object> removeQrCode(SysDoorQRCode sysDoorQRCode);

    List<VoDoorQRCode> list(SearchDoorQRCode searchDoorQRCode);

    Map<String, Object> getVisitorsQrCode(Date startTime, Date endTime, String visitorsTel);
}
