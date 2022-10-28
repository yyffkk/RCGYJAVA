package com.api.app.dao.qrCode;

import com.api.qrCode.DeviceDataList;

import java.util.List;

public interface QRCodeDao {

    List<DeviceDataList> selectDevice();

    int updateRemark2(String dataToDes ,String deviceId);

    String findRemark2(String deviceId);
}
