package com.api.app.service.my;

import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SysLease;
import com.api.model.my.MyHouse;
import com.api.vo.app.AppLeaseVo;

import java.util.List;
import java.util.Map;

public interface MyHouseService {
    Map<String, Object> houseList(Integer id);

    Map<String, Object> examineList(Integer id);

    Map<String, Object> authentication(MyHouse myHouse, Integer type);

    Map<String, Object> falseDelete(int[] ids,Integer residentId);

    Map<String, Object> findById(Integer estateExamineId);

    Map<String, Object> changeSelectExamineId(Integer examineId, Integer id);

    Map<String, Object> leaseCertification(UserResident userResident);

    Map<String, Object> leaseEcho(String tel);

    List<AppLeaseVo> leaseList();

    Map<String, Object> leaseFindById(Integer leaseId);

    Map<String, Object> submitPersonalLeaseInfo(SysLease sysLease);
}
