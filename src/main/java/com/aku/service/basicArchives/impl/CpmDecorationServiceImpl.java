package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmDecorationDao;
import com.aku.dao.basicArchives.UserStaffDao;
import com.aku.model.basicArchives.*;
import com.aku.service.basicArchives.CpmDecorationService;
import com.aku.vo.basicArchives.VoDecoration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CpmDecorationServiceImpl implements CpmDecorationService {
    private final Map<String,Object> map = new HashMap<>();
    @Resource
    CpmDecorationDao cpmDecorationDao;
    @Resource
    UserStaffDao userStaffDao;


    @Override
    public List<VoDecoration> list(SearchDecoration searchDecoration) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchDecoration.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchDecoration.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchDecoration.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchDecoration.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchDecoration.setRoomNumber(split[2]);
            }
        }
        List<VoDecoration> list = cpmDecorationDao.list(searchDecoration);
        if (list != null && list.size()>0){
            //处理显示的roomName信息
            for (VoDecoration voDecoration : list) {
                voDecoration.setRoomName(voDecoration.getEstateNo()+"-"+voDecoration.getUnitNo()+"-"+voDecoration.getRoomNumber());
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(DecorationAndStaff decorationAndStaff) {
        int insert = cpmDecorationDao.insert(decorationAndStaff.getCpmDecoration());
        if (decorationAndStaff.getUserStaffList() != null && decorationAndStaff.getUserStaffList().size() >0){
            for (UserStaff userStaff : decorationAndStaff.getUserStaffList()) {
                int insert2 = userStaffDao.insert(userStaff);
                if (insert2 <= 0){
                    throw new RuntimeException("添加装修附属人员信息失败");
                }
            }
        }
        if (insert>0){
            map.put("message","添加装修信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加装修信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(DecorationAndStaff decorationAndStaff) {
        boolean flag =true;
        //修改装修信息
        int update = cpmDecorationDao.update(decorationAndStaff.getCpmDecoration());
        if (update <= 0){
            flag = false;
        }
        //查询该装修的所有附属员工
        List<UserStaff> userStaffList = userStaffDao.findByDecorationId(decorationAndStaff.getCpmDecoration().getId());
        for (UserStaff userStaff : userStaffList) {
            //先删除附属员工关联信息 和 对应的员工信息
            int delete = userStaffDao.deleteByDecorationIdAndStaffId(new DecorationIdAndStaffId(decorationAndStaff.getCpmDecoration().getId(),userStaff.getId()));
            if (delete <= 0){
                flag = false;
            }
            int delete1 = userStaffDao.deleteById(userStaff.getId());
            if (delete1 <= 0){
                flag = false;
            }
        }

        //再添加关联附属员工关联信息
        if (decorationAndStaff.getUserStaffList() != null && decorationAndStaff.getUserStaffList().size() >0){
            for (UserStaff userStaff : decorationAndStaff.getUserStaffList()) {
                //先添加附属员工表
                int insert2 = userStaffDao.insert(userStaff);
                if (insert2 <= 0){
                    flag = false;
                }
                CpmDecorationStaff cpmDecorationStaff = new CpmDecorationStaff();
                cpmDecorationStaff.setDecorationId(decorationAndStaff.getCpmDecoration().getId());
                cpmDecorationStaff.setStaffId(userStaff.getId());
                cpmDecorationStaff.setIdentity(userStaff.getIdentity());
                //在添加附属员工装修关联表
                int insert3 = userStaffDao.insertDecorationIdAndStaffId(cpmDecorationStaff);
                if (insert3 <= 0){
                    flag = false;
                }
            }
        }

        if (flag){
            map.put("message","修改装修信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改装修信息失败");
        }
        return map;
    }

    @Override
    public DecorationAndStaff findById(Integer id) {
        DecorationAndStaff decorationAndStaff = new DecorationAndStaff();
        CpmDecoration cpmDecoration = cpmDecorationDao.findById(id);
        decorationAndStaff.setCpmDecoration(cpmDecoration);
        List<UserStaff> userStaffList = userStaffDao.findByDecorationId(decorationAndStaff.getCpmDecoration().getId());
        if (userStaffList != null && userStaffList.size()>0){
            decorationAndStaff.setUserStaffList(userStaffList);
        }
        return decorationAndStaff;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        try {
            for (int id : ids) {
                //查询是否有关联附属员工信息
                List<UserStaff> userStaffList = userStaffDao.findByDecorationId(id);
                if (userStaffList != null && userStaffList.size()>0){
                    throw new RuntimeException("批量删除失败，请先删除对应的成员关联信息");
                }
                //删除装修信息
                int delete = cpmDecorationDao.deleteById(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除楼栋单元信息失败");
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
        map.put("message","删除装修信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteStaff(DecorationIdAndStaffId decorationIdAndStaffId) {
        boolean flag = true;
        //删除附属成员装修关联信息
        int delete1 = userStaffDao.deleteByDecorationIdAndStaffId(decorationIdAndStaffId);
        if (delete1 <= 0){
            flag = false;
        }

        //删除附属成员信息
        int delete = userStaffDao.deleteById(decorationIdAndStaffId.getStaffId());
        if (delete <= 0){
            flag = false;
        }

        if (flag){
            map.put("message","删除关联成员成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("删除关联成员失败");
        }
        return map;
    }


}
