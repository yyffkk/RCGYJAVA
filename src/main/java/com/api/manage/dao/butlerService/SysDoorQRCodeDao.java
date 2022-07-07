package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchDoorQRCode;
import com.api.model.butlerService.SysDoorQRCode;
import com.api.vo.butlerService.VoDoorQRCode;

import java.util.List;

public interface SysDoorQRCodeDao {
    /**
     * 添加设备二维码
     * @param sysDoorQRCode 门禁二维码model
     * @return 影响行数
     */
    int addQrCode(SysDoorQRCode sysDoorQRCode);

    /**
     * 删除设备二维码
     * @param sysDoorQRCode 门禁二维码model
     * @return 影响行数
     */
    int removeQrCode(SysDoorQRCode sysDoorQRCode);

    /**
     * 根据房产主键id和手机号查询是否存在门禁二维码关联信息
     * @param sysDoorQRCode 房产主键id和手机号
     * @return 门禁二维码关联信息数量
     */
    int countQRCodeByEstateIdAndTel(SysDoorQRCode sysDoorQRCode);

    /**
     * 查询设备二维码
     * @param searchDoorQRCode 门禁二维码 搜索条件
     * @return 设备二维码
     */
    List<VoDoorQRCode> list(SearchDoorQRCode searchDoorQRCode);
}
