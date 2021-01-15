package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.UserVisitorsDao;
import com.api.model.butlerService.SearchUserVisitors;
import com.api.model.butlerService.UserVisitors;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.UserVisitorsService;
import com.api.vo.butlerService.VoFindByIdVisitors;
import com.api.vo.butlerService.VoUserVisitors;
import com.api.vo.butlerService.VoUserVisitorsDetail;
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
public class UserVisitorsServiceImpl implements UserVisitorsService {
    private Map<String,Object> map = null;
    @Resource
    UserVisitorsDao userVisitorsDao;

    @Override
    public List<VoUserVisitors> list(SearchUserVisitors searchUserVisitors) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchUserVisitors.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchUserVisitors.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchUserVisitors.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchUserVisitors.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchUserVisitors.setRoomNumber(split[2]);
            }
        }
        List<VoUserVisitors> voUserVisitorsList = userVisitorsDao.list(searchUserVisitors);
        if (voUserVisitorsList != null && voUserVisitorsList.size()>0){
            //处理显示的roomName信息
            for (VoUserVisitors voUserVisitors : voUserVisitorsList) {
                //如果状态为1.未到，并且当前时间大于有效时间，则显示3.已过期
                if (voUserVisitors.getVisitorStatus() == 1 && (new Date().getTime()>voUserVisitors.getEffectiveTime().getTime())){
                    voUserVisitors.setVisitorStatus(3);
                }
                voUserVisitors.setRoomName(voUserVisitors.getEstateNo()+"-"+voUserVisitors.getUnitNo()+"-"+voUserVisitors.getRoomNumber());
            }
        }
        return voUserVisitorsList;
    }

    @Override
    public VoFindByIdVisitors findById(Integer id) {
        VoFindByIdVisitors voFindByIdVisitors = userVisitorsDao.findById(id);
        if (voFindByIdVisitors != null){
            //如果状态为1.未到，并且当前时间大于有效时间，则显示3.已过期
            if (voFindByIdVisitors.getVisitorStatus() == 1&&(new Date().getTime()>voFindByIdVisitors.getEffectiveTime().getTime())){
                voFindByIdVisitors.setVisitorStatus(3);
            }
            voFindByIdVisitors.setRoomName(voFindByIdVisitors.getEstateNo()+"-"+voFindByIdVisitors.getUnitNo()+"-"+voFindByIdVisitors.getRoomNumber());
        }
        return voFindByIdVisitors;
    }

    @Override
    public Map<String, Object> update(UserVisitors userVisitors) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人id
        userVisitors.setModifyId(sysUser.getId());
        //填入修改时间
        userVisitors.setModifyDate(new Date());

        int update = userVisitorsDao.update(userVisitors);
        if (update >0){
            map.put("message","更新访客信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新访客信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> cancel(int[] ids) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            for (int id : ids) {
                UserVisitors userVisitors = new UserVisitors();
                //填入访客信息主键id
                userVisitors.setId(id);
                //填入访客状态 4.作废
                userVisitors.setVisitorStatus(4);
                //填入核对人
                userVisitors.setVerifierId(sysUser.getId());
                //填入核对时间
                userVisitors.setVisitDate(new Date());

                int update = userVisitorsDao.update(userVisitors);
                if (update<=0){
                    throw new RuntimeException("批量作废访客信息失败");
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
        map.put("message","批量作废访客信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = userVisitorsDao.delete(id);
                if (update<=0){
                    throw new RuntimeException("批量删除访客信息失败");
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
        map.put("message","批量删除访客信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> listDetail(Integer id) {
        map = new HashMap<>();
        List<VoUserVisitorsDetail> voUserVisitorsDetailList = userVisitorsDao.listDetail(id);
        map.put("voUserVisitorsDetailList",voUserVisitorsDetailList);
        return map;
    }

    @Override
    public Map<String, Object> countVisitorsNew() {
        map = new HashMap<>();
        Integer integer = userVisitorsDao.countVisitorsNew();
        map.put("countNew",integer);
        return map;
    }
}
