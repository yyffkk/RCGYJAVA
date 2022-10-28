package com.api.qrCode;


import com.api.app.dao.qrCode.QRCodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
@Service
public class QRCodeServiceImpl {

    @Resource
    QRCodeDao qrCodeDao;
    public String getQRCode(QRCode qrCode) throws Exception {
        String message=qrCode.getUid()+"_"+qrCode.getBuildingNo()+"-"+qrCode.getBuildingUnitNo()+"-"+
                qrCode.getFloorNo() +"-"+qrCode.getRoomNo()+"_"+qrCode.getStartTime()+"_"+qrCode.getEndTime();
        byte[] data=Des.getKey(message);
        String s = data.toString();
        String dnakeiot = Des.encryptDES(s, "dnakeiot");
        String messageData="iot:"+dnakeiot;
        return messageData;
    }

    public Boolean buildQRCode() throws Exception {
        //当前时间的时间戳
        long l = System.currentTimeMillis() / 1000;
        long l1 = l - 3000;
        String s = Long.toString(l1);
        long ADD_YEAR = 10 * 365 * 24 * 60 * 60 * 1000L;
        long l2 = l + ADD_YEAR;
        String s1 = Long.toString(l2);
        List<DeviceDataList> list = qrCodeDao.selectDevice();
        int a=1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getDeviceId().substring(list.get(i).getDeviceId().length() - 4, list.get(i).getDeviceId().length() - 2).equals("99")){
                String message=list.get(i).getRemark1()+"_"+list.get(i).getDeviceId().substring(0, list.get(i).getDeviceId().length() - 6)+"-"+
                        list.get(i).getDeviceId().substring( list.get(i).getDeviceId().length() - 6, list.get(i).getDeviceId().length() - 4)+"-"+
                        list.get(i).getDeviceId().substring( list.get(i).getDeviceId().length() - 4, list.get(i).getDeviceId().length() - 2)+"-"+
                        list.get(i).getDeviceId().substring(list.get(i).getDeviceId().length() - 2)+"_"+s+"_"+s1;

                byte[] data=Des.getKey(message);
                String dataToDes = data.toString();
                String dnakeiot = Des.encryptDES(dataToDes, "dnakeiot");
                String messageData="iot:"+dnakeiot;
                int update= qrCodeDao.updateRemark2(messageData,list.get(i).getDeviceId());
                a=a&update;
            }
        }
        return a>0;
    }

    public String findRemark2(ResidentInformation residentInformation){
        String s = residentInformation.getBuildingNo() + residentInformation.getBuildingUnitNo() + "99"+residentInformation.getRoomNo();
        return qrCodeDao.findRemark2(s);
    }


}
