package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.UserAccessCardDao;
import com.aku.dao.butlerService.UserDecorationDao;
import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.service.butlerService.UserDecorationService;
import com.aku.vo.butlerService.VoUserAccessCard;
import com.aku.vo.butlerService.VoUserDecoration;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationTrackRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserDecorationServiceImpl implements UserDecorationService {
    private static Map<String,Object> map = null;

    @Resource
    UserDecorationDao userDecorationDao;
    @Resource
    UserAccessCardDao userAccessCardDao;

    @Override
    public List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchUserDecoration.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchUserDecoration.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchUserDecoration.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchUserDecoration.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchUserDecoration.setRoomNumber(split[2]);
            }
        }
        List<VoUserDecoration> list = userDecorationDao.list(searchUserDecoration);
        for (VoUserDecoration voUserDecoration : list) {
            //填入房屋信息
            voUserDecoration.setRoomName(voUserDecoration.getBuildingNo()+"-"+voUserDecoration.getUnitNo()+"-"+voUserDecoration.getRoomNumber());
            //填入门禁卡数量
            int num = userAccessCardDao.countCardNum(voUserDecoration.getId());
            voUserDecoration.setUserAccessCardNum(num);
        }
        return list;
    }

    @Override
    public List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id) {
        return userDecorationDao.decorationPersonnelList(id);
    }

    @Override
    public List<VoUserAccessCard> userAccessCardList(Integer id) {
        List<VoUserAccessCard> voUserAccessCardList = userAccessCardDao.userAccessCardList(id);
        if (voUserAccessCardList != null){
            for (VoUserAccessCard voUserAccessCard : voUserAccessCardList) {
                //如果到期时间不为null,为1.临时类型；为null，则为2.永久类型
                if (voUserAccessCard.getExpireDate() != null){
                    voUserAccessCard.setType(1);
                }else {
                    voUserAccessCard.setType(2);
                }
            }
        }

        return voUserAccessCardList;
    }

    @Override
    public List<VoUserDecorationTrackRecord> decorationTrackRecordList(Integer id) {
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationDao.decorationTrackRecordList(id);
        if (voUserDecorationTrackRecordList != null){
            for (VoUserDecorationTrackRecord voUserDecorationTrackRecord : voUserDecorationTrackRecordList) {
                //遍历查询跟踪检查记录明细
                //                userDecorationDao.
            }
        }
        return null;
    }
}
