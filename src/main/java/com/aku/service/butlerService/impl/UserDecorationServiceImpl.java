package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.UserAccessCardDao;
import com.aku.dao.butlerService.UserDecorationDao;
import com.aku.dao.butlerService.UserDecorationPersonnelDao;
import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.model.butlerService.UserDecorationPersonnel;
import com.aku.model.system.SysUser;
import com.aku.service.butlerService.UserDecorationService;
import com.aku.vo.butlerService.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDecorationServiceImpl implements UserDecorationService {
    private static Map<String,Object> map = null;

    @Resource
    UserDecorationDao userDecorationDao;
    @Resource
    UserAccessCardDao userAccessCardDao;
    @Resource
    UserDecorationPersonnelDao userDecorationPersonnelDao;

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
                List<VoUserDecorationTrackRecordDetail> voUserDecorationTrackRecordDetailList = userDecorationDao.decorationTrackRecordDetailList(voUserDecorationTrackRecord.getId());
                voUserDecorationTrackRecord.setReview(voUserDecorationTrackRecordDetailList);
            }
        }
        return voUserDecorationTrackRecordList;
    }

    @Override
    public List<VoUserDecorationTrackRecord> decorationFinishRecordList(Integer id) {
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationDao.decorationFinishRecordList(id);
        if (voUserDecorationTrackRecordList != null){
            for (VoUserDecorationTrackRecord voUserDecorationTrackRecord : voUserDecorationTrackRecordList) {
                //遍历查询完工检查记录明细
                List<VoUserDecorationTrackRecordDetail> voUserDecorationTrackRecordDetailList = userDecorationDao.decorationTrackRecordDetailList(voUserDecorationTrackRecord.getId());
                voUserDecorationTrackRecord.setReview(voUserDecorationTrackRecordDetailList);
            }
        }
        return voUserDecorationTrackRecordList;
    }

    @Override
    public Map<String, Object> insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        userDecorationPersonnel.setCreateId(sysUser.getId());
        //填入创建时间
        userDecorationPersonnel.setCreateDate(new Date());

        //添加装修人员信息
        int insert = userDecorationPersonnelDao.insertDecorationPersonnel(userDecorationPersonnel);

        if (insert>0){
            map.put("message","添加装修人员成功");
            map.put("status",true);
        }else {
            map.put("message","添加装修人员失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteDecorationPersonnel(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = userDecorationPersonnelDao.deleteDecorationPersonnel(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除装修人员信息失败");
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","批量删除装修人员信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findByIdDecorationPersonnel(Integer id) {
        map = new HashMap<>();
        VoUserDecorationPersonnel voUserDecorationPersonnel = userDecorationPersonnelDao.findByIdDecorationPersonnel(id);
        map.put("voUserDecorationPersonnel",voUserDecorationPersonnel);
        return map;
    }

    @Override
    public Map<String, Object> updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        userDecorationPersonnel.setModifyId(sysUser.getId());
        //填入修改时间
        userDecorationPersonnel.setModifyDate(new Date());
        //修改装修人员信息
        int update = userDecorationPersonnelDao.updateDecorationPersonnel(userDecorationPersonnel);
        if (update>0){
            map.put("message","修改装修人员成功");
            map.put("status",true);
        }else {
            map.put("message","修改装修人员失败");
            map.put("status",false);
        }
        return map;
    }
}
