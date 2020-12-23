package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysVoiceHousekeeperDao;
import com.api.model.butlerService.SearchVoiceHousekeeper;
import com.api.model.butlerService.VoiceHousekeeperRemake;
import com.api.service.butlerService.SysVoiceHousekeeperService;
import com.api.vo.butlerService.VoVoiceHousekeeper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysVoiceHousekeeperServiceImpl implements SysVoiceHousekeeperService {
    private static Map<String,Object> map = null;
    @Resource
    SysVoiceHousekeeperDao sysVoiceHousekeeperDao;

    @Override
    public List<VoVoiceHousekeeper> list(SearchVoiceHousekeeper searchVoiceHousekeeper) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchVoiceHousekeeper.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchVoiceHousekeeper.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchVoiceHousekeeper.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchVoiceHousekeeper.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchVoiceHousekeeper.setRoomNumber(split[2]);
            }
        }
        return sysVoiceHousekeeperDao.list(searchVoiceHousekeeper);
    }

    @Override
    public Map<String, Object> insertRemake(VoiceHousekeeperRemake voiceHousekeeperRemake) {
        map = new HashMap<>();
        //添加备注信息
        int update = sysVoiceHousekeeperDao.insertRemake(voiceHousekeeperRemake);
        if (update > 0){
            map.put("message","添加备注成功");
            map.put("status",true);
        }else {
            map.put("message","添加备注失败");
            map.put("status",false);
        }
        return map;
    }
}
