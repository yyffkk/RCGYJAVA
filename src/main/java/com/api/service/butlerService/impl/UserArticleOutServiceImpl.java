package com.api.service.butlerService.impl;

import com.api.dao.butlerService.UserArticleOutDao;
import com.api.model.butlerService.SearchUserArticleOut;
import com.api.model.butlerService.UserArticleOut;
import com.api.model.system.SysUser;
import com.api.service.butlerService.UserArticleOutService;
import com.api.vo.butlerService.VoUserArticleOut;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserArticleOutServiceImpl implements UserArticleOutService {
    private static Map<String,Object> map = null;
    @Resource
    UserArticleOutDao userArticleOutDao;

    @Override
    public List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchUserArticleOut.getRoomName()!=null){
            //去掉所有空格，以"-"截取字符串成数组
            String[] split2 = searchUserArticleOut.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchUserArticleOut.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchUserArticleOut.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchUserArticleOut.setRoomNumber(split[2]);
            }
        }
        List<VoUserArticleOut> list = userArticleOutDao.list(searchUserArticleOut);
        //处理显示的roomName信息
        for (VoUserArticleOut voUserArticleOut : list) {
            voUserArticleOut.setRoomName(voUserArticleOut.getBuildingNo()+"-"+voUserArticleOut.getUnitNo()+"-"+voUserArticleOut.getRoomNumber());
        }
        return list;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = userArticleOutDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除物品出门信息失败");
                }
            }
        } catch (Exception e) {
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
        map.put("message","批量删除物品出门信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> applicationRejection(Integer id) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        UserArticleOut userArticleOut = new UserArticleOut();
        //添加物品出门主键id
        userArticleOut.setId(id);
        //添加审核人
        userArticleOut.setReviewId(sysUser.getId());
        //添加审核时间
        userArticleOut.setReviewDate(new Date());
        //填入驳回状态
        userArticleOut.setStatus(3);

        int update = userArticleOutDao.applicationRejection(userArticleOut);
        if (update>0){
            map.put("message","驳回申请成功");
            map.put("status",true);
        }else {
            map.put("message","驳回申请失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String,Object> countArticleOutNow() {
        map = new HashMap<>();
        Integer integer = userArticleOutDao.countArticleOutNow();
        map.put("countNow",integer);
        return map;
    }

    @Override
    public Map<String, Object> countPerformed() {
        map = new HashMap<>();
        Integer integer = userArticleOutDao.countPerformed();
        map.put("countPerformed",integer);
        return map;
    }
}
