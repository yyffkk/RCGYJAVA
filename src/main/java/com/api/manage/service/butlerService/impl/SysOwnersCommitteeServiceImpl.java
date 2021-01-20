package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysOwnersCommitteeDao;
import com.api.model.butlerService.SearchOwnersCommittee;
import com.api.model.butlerService.SysOwnersCommittee;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysOwnersCommitteeService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFindByIdOwnersCommittee;
import com.api.vo.butlerService.VoOwnersCommittee;
import com.api.vo.resources.VoResourcesImg;
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
public class SysOwnersCommitteeServiceImpl implements SysOwnersCommitteeService {
    private static Map<String,Object> map = null;
    @Resource
    SysOwnersCommitteeDao sysOwnersCommitteeDao;

    @Override
    public List<VoOwnersCommittee> list(SearchOwnersCommittee searchOwnersCommittee) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchOwnersCommittee.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchOwnersCommittee.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchOwnersCommittee.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchOwnersCommittee.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchOwnersCommittee.setRoomNumber(split[2]);
            }
        }
        List<VoOwnersCommittee> list = sysOwnersCommitteeDao.list(searchOwnersCommittee);
        if (list != null && list.size()>0){
            //处理显示的roomName信息
            for (VoOwnersCommittee voOwnersCommittee : list) {
                voOwnersCommittee.setRoomName(voOwnersCommittee.getEstateNo()+"-"+voOwnersCommittee.getUnitNo()+"-"+voOwnersCommittee.getRoomNumber());
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysOwnersCommittee sysOwnersCommittee) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //填入创建人
            sysOwnersCommittee.setCreateId(sysUser.getId());
            //填入创建时间
            sysOwnersCommittee.setCreateDate(new Date());
            //添加业委会信息
            int insert = sysOwnersCommitteeDao.insert(sysOwnersCommittee);
            if (insert <= 0){
                throw new RuntimeException("添加业委会信息失败");
            }
            //上传照片到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysOwnersCommittee.getFileUrls(),"sysOwnersCommittee",sysOwnersCommittee.getId(),"ownersCommitteeImg","600",30,20);
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
        map.put("message","添加业委会信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoFindByIdOwnersCommittee findById(Integer id) {
        VoFindByIdOwnersCommittee byId = sysOwnersCommitteeDao.findById(id);
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysOwnersCommittee", id, "ownersCommitteeImg");
        //填入照片资源集合
        byId.setImgUrls(imgByDate);
        return byId;
    }

    @Override
    public Map<String, Object> update(SysOwnersCommittee sysOwnersCommittee) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入修改人
            sysOwnersCommittee.setModifyId(sysUser.getId());
            //填入修改时间
            sysOwnersCommittee.setModifyDate(new Date());
            int update = sysOwnersCommitteeDao.update(sysOwnersCommittee);
            if (update <= 0) {
                throw new RuntimeException("更新业委会信息失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先根据业委会数据id删除数据库照片资源
            uploadUtil.delete("sysOwnersCommittee", sysOwnersCommittee.getId(), "ownersCommitteeImg");
            //在添加照片资源
            uploadUtil.saveUrlToDB(sysOwnersCommittee.getFileUrls(),"sysOwnersCommittee",sysOwnersCommittee.getId(),"ownersCommitteeImg","600",30,20);
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
        map.put("message","更新业委会信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length>0){
                for (int id : ids) {
                    //根据业委会主键id删除业委会信息
                    int delete = sysOwnersCommitteeDao.delete(id);
                    if (delete <= 0){
                        throw new RuntimeException("删除业委会信息失败");
                    }
                }
            }else {
                throw new RuntimeException("没传入任何主键id");
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
        map.put("message","删除业委会信息成功");
        map.put("status",true);
        return map;
    }
}
