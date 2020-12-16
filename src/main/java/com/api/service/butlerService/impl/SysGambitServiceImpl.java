package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysGambitDao;
import com.api.model.butlerService.SearchGambit;
import com.api.model.butlerService.SysGambit;
import com.api.model.resources.ResourcesImg;
import com.api.model.system.SysUser;
import com.api.service.butlerService.SysGambitService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFindByIdGambit;
import com.api.vo.butlerService.VoGambit;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysGambitServiceImpl implements SysGambitService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-gambit}")
    private String UPLOAD_GAMBIT;
    @Resource
    SysGambitDao sysGambitDao;

    @Override
    public List<VoGambit> list(SearchGambit searchGambit) {
        //查询所有的话题信息 （包含条件搜索）
        List<VoGambit> list = sysGambitDao.list(searchGambit);
        if (list != null && list.size()>0){
            //遍历所有的话题信息
            for (VoGambit voGambit : list) {
                //查询参与人数
                int count = sysGambitDao.countGambitNum(voGambit.getId());
                //传入参与人数
                voGambit.setPeopleNum(count);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysGambit sysGambit) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //后台管理添加，默认为3.物业
            sysGambit.setUserType(3);
            //填入创建人id
            sysGambit.setCreateId(sysUser.getId());
            //填入创建时间
            sysGambit.setCreateDate(new Date());
            //填入是否删除，默认1.非删
            sysGambit.setIsDelete(1);
            //添加话题信息(物业后台添加)
            int insert = sysGambitDao.insert(sysGambit);
            if (insert <= 0){
                throw new RuntimeException("添加话题信息失败");
            }

            //上传文件
            UploadUtil uploadUtil = new UploadUtil();
            MultipartFile file = sysGambit.getFile();
            //如果文件file不为空，则上传该文件到 ../static/img/gambit目录下,并录入数据库
            if (file != null){
                uploadUtil.upload(file,UPLOAD_GAMBIT,"sysGambit",sysGambit.getId(),"gambitImg","600",30,20);
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

        map.put("message","添加话题信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoFindByIdGambit findById(Integer id) {
        //根据话题主键id查询话题详情
        VoFindByIdGambit voFindByIdGambit = sysGambitDao.findById(id);
        if (voFindByIdGambit != null){
            //查询照片信息
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambit", id, "gambitImg");
            voFindByIdGambit.setImgUrls(imgByDate);
        }
        return voFindByIdGambit;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysGambit sysGambit) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人id
        sysGambit.setModifyId(sysUser.getId());
        //填入修改时间
        sysGambit.setModifyDate(new Date());
        try {
            //修改话题信息(物业后台修改)
            int update = sysGambitDao.update(sysGambit);
            if (update <= 0){
                throw new RuntimeException("修改话题信息失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先删除上传文件
            uploadUtil.delete("sysGambit",sysGambit.getId(),"gambitImg");

            MultipartFile file = sysGambit.getFile();
            if (file != null){
                //再添加上传文件
                uploadUtil.upload(file,UPLOAD_GAMBIT,"sysGambit",sysGambit.getId(),"gambitImg","600",30,20);
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
        map.put("message","修改话题信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysGambitDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("批量删除话题信息失败");
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
        map.put("message","批量删除话题信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> enableGambit(Integer id) {
        map = new HashMap<>();
        int update = sysGambitDao.enableGambit(id);
        if (update >0){
            map.put("message","启用话题信息成功");
            map.put("status",true);
        }else {
            map.put("message","启用话题信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> disableGambit(Integer id) {
        map = new HashMap<>();
        int update = sysGambitDao.disableGambit(id);
        if (update >0){
            map.put("message","禁用话题信息成功");
            map.put("status",true);
        }else {
            map.put("message","禁用话题信息失败");
            map.put("status",false);
        }
        return map;
    }
}
