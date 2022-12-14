package com.api.manage.service.operationManagement.impl;

import com.api.manage.service.operationManagement.SysGeographyService;
import com.api.mapper.manage.SysGeographyMapper;
import com.api.mapper.manage.SysUserMapper;
import com.api.model.businessManagement.SysUser;
import com.api.model.entity.SysUserDo;
import com.api.model.operationManagement.GeographyInsert;
import com.api.model.operationManagement.GeographySearch;
import com.api.model.entity.SysGeographyDo;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.SysGeographyFBIVo;
import com.api.vo.operationManagement.SysGeographyVo;
import com.api.vo.resources.VoResourcesImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysGeographyServiceImpl implements SysGeographyService {
    private static Map<String,Object> map = null;
    @Resource
    SysGeographyMapper sysGeographyMapper;
    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public List<SysGeographyVo> list(GeographySearch geographySearch) {
        QueryWrapper<SysGeographyDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(geographySearch.getName()),"name", geographySearch.getName());
        queryWrapper.eq(geographySearch.getStatus() != null,"status", geographySearch.getStatus());
        List<SysGeographyDo> sysGeographyDoList = sysGeographyMapper.selectList(queryWrapper);
        ArrayList<SysGeographyVo> sysGeographyVoList = new ArrayList<>();
        if (sysGeographyDoList != null && sysGeographyDoList.size()>0){
            for (SysGeographyDo sysGeographyDo : sysGeographyDoList) {
                SysGeographyVo sysGeographyVo = new SysGeographyVo();
                //DO ??? VO
                PropertyUtils.copyProperties(sysGeographyDo,sysGeographyVo);
                SysUserDo sysUserDo = sysUserMapper.selectById(sysGeographyDo.getCreateId());
                sysGeographyVo.setCreateName(sysUserDo.getActualName());
                sysGeographyVoList.add(sysGeographyVo);
            }
        }
        return sysGeographyVoList;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(GeographyInsert geographyInsert) {
        map = new HashMap<>();
        try {
            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysGeographyDo sysGeographyDo = new SysGeographyDo();
            sysGeographyDo.setName(geographyInsert.getName());//??????????????????
            sysGeographyDo.setContent(geographyInsert.getContent());//??????????????????
            sysGeographyDo.setStatus(2);//2.?????????
            sysGeographyDo.setCreateId(sysUser.getId());//???????????????
            sysGeographyDo.setCreateDate(new Date());//??????????????????
            int insert = sysGeographyMapper.insert(sysGeographyDo);
            if (insert <=0){
                throw new RuntimeException("????????????");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(geographyInsert.getImgUrls(),"sysGeography",sysGeographyDo.getId(),"geographyImg","600",30,20);

        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer geographyId) {
        map = new HashMap<>();
        SysGeographyDo sysGeographyDo = sysGeographyMapper.selectById(geographyId);
        SysGeographyFBIVo sysGeographyFBIVo = new SysGeographyFBIVo();
        PropertyUtils.copyProperties(sysGeographyDo,sysGeographyFBIVo);

        //????????????
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGeography", geographyId, "geographyImg");
        sysGeographyFBIVo.setImgList(imgByDate);


        map.put("message","????????????");
        map.put("status",true);
        map.put("data",sysGeographyFBIVo);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(GeographyInsert geographyInsert) {
        map = new HashMap<>();
        try {
            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysGeographyDo sysGeographyDo = new SysGeographyDo();
            sysGeographyDo.setId(geographyInsert.getId());//????????????????????????id
            sysGeographyDo.setName(geographyInsert.getName());//??????????????????
            sysGeographyDo.setContent(geographyInsert.getContent());//??????????????????
            sysGeographyDo.setModifyId(sysUser.getId());//???????????????
            sysGeographyDo.setModifyDate(new Date());//??????????????????
            int update = sysGeographyMapper.updateById(sysGeographyDo);
            if (update <=0){
                throw new RuntimeException("????????????");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //?????????????????????
            uploadUtil.delete("sysGeography",sysGeographyDo.getId(),"geographyImg");
            //?????????????????????
            uploadUtil.saveUrlToDB(geographyInsert.getImgUrls(),"sysGeography",sysGeographyDo.getId(),"geographyImg","600",30,20);

        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> enable(Integer geographyId) {
        map = new HashMap<>();
        try {
            SysGeographyDo sysGeographyDo = new SysGeographyDo();

            //????????????????????????
            QueryWrapper<SysGeographyDo> queryWrapper = new QueryWrapper<>();
            queryWrapper.ne("id",geographyId);
            sysGeographyDo.setStatus(2);//??????2.?????????
            sysGeographyMapper.update(sysGeographyDo,queryWrapper);

            //????????????????????????
            QueryWrapper<SysGeographyDo> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("id",geographyId);
            sysGeographyDo.setStatus(1);//??????1.??????
            int update = sysGeographyMapper.update(sysGeographyDo,queryWrapper2);
            if (update <=0){
                throw new RuntimeException("????????????");
            }

        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {

            for (int id : ids) {
                int delete = sysGeographyMapper.deleteById(id);
                if (delete <= 0){
                    throw new RuntimeException("????????????");
                }

                UploadUtil uploadUtil = new UploadUtil();
                uploadUtil.delete("sysGeography",id,"geographyImg");

            }
        } catch (RuntimeException e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }
}
