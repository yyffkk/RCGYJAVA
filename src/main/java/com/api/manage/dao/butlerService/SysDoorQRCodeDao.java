package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SysDoorQRCode;

public interface SysDoorQRCodeDao {
    /**
     * 添加设备二维码
     * @param sysDoorQRCode 门禁二维码model
     * @return 影响行数
     */
    int addQrCode(SysDoorQRCode sysDoorQRCode);
}
