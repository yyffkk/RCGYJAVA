package com.api.manage.service.operationManagement.impl;

import com.api.manage.service.operationManagement.SysSurroundingEnterprisesService;
import com.api.mapper.manage.SysSurroundingEnterprisesMapper;
import com.api.mapper.manage.SysUserMapper;
import com.api.model.businessManagement.SysUser;
import com.api.model.entity.SysGeographyDo;
import com.api.model.entity.SysSurroundingEnterprisesDo;
import com.api.model.entity.SysUserDo;
import com.api.model.operationManagement.SurroundingEnterprisesInsert;
import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.SysSurroundingEnterprisesFBIVo;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;
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
public class SysSurroundingEnterprisesServiceImpl implements SysSurroundingEnterprisesService {
    private static Map<String,Object> map = null;
    @Resource
    SysSurroundingEnterprisesMapper sysSurroundingEnterprisesMapper;
    @Resource
    SysUserMapper sysUserMapper;


    @Override
    public List<SysSurroundingEnterprisesVo> list(SurroundingEnterprisesSearch surroundingEnterprisesSearch) {

        QueryWrapper<SysSurroundingEnterprisesDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(surroundingEnterprisesSearch.getName()),"name",surroundingEnterprisesSearch.getName());
        queryWrapper.eq(surroundingEnterprisesSearch.getReleaseStatus() != null,"release_status",surroundingEnterprisesSearch.getReleaseStatus());

        List<SysSurroundingEnterprisesDo> selectList = sysSurroundingEnterprisesMapper.selectList(queryWrapper);
        ArrayList<SysSurroundingEnterprisesVo> surroundingEnterprisesVoList = new ArrayList<>();
        if (selectList != null && selectList.size()>0){
            for (SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo : selectList) {
                SysSurroundingEnterprisesVo surroundingEnterprisesVo = new SysSurroundingEnterprisesVo();
                PropertyUtils.copyProperties(sysSurroundingEnterprisesDo,surroundingEnterprisesVo);
                SysUserDo sysUserDo = sysUserMapper.selectById(sysSurroundingEnterprisesDo.getCreateId());
                surroundingEnterprisesVo.setCreateName(sysUserDo.getActualName());
                surroundingEnterprisesVoList.add(surroundingEnterprisesVo);
            }
        }

        return surroundingEnterprisesVoList;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SurroundingEnterprisesInsert surroundingEnterprisesInsert) {
        map = new HashMap<>();
        try {
            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
            sysSurroundingEnterprisesDo.setName(surroundingEnterprisesInsert.getName());//??????????????????
            sysSurroundingEnterprisesDo.setContent(surroundingEnterprisesInsert.getContent());//??????????????????
            sysSurroundingEnterprisesDo.setReleaseStatus(surroundingEnterprisesInsert.getReleaseStatus());//??????????????????
            if (surroundingEnterprisesInsert.getReleaseStatus() == 1){//1.??????
                sysSurroundingEnterprisesDo.setReleaseDate(new Date());//??????????????????
            }
            sysSurroundingEnterprisesDo.setCreateId(sysUser.getId());//?????????????????????id
            sysSurroundingEnterprisesDo.setCreateDate(new Date());//??????????????????
            int insert = sysSurroundingEnterprisesMapper.insert(sysSurroundingEnterprisesDo);
            if (insert <= 0){
                throw new RuntimeException("????????????");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(surroundingEnterprisesInsert.getImgUrls(),"sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg","600",30,20);

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
    public Map<String, Object> findById(Integer surroundingEnterprisesId) {
        map = new HashMap<>();

        SysSurroundingEnterprisesDo surroundingEnterprisesDo = sysSurroundingEnterprisesMapper.selectById(surroundingEnterprisesId);
        SysSurroundingEnterprisesFBIVo surroundingEnterprisesFBIVo = new SysSurroundingEnterprisesFBIVo();
        PropertyUtils.copyProperties(surroundingEnterprisesDo,surroundingEnterprisesFBIVo);

        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysSurroundingEnterprises", surroundingEnterprisesId, "surroundingEnterprisesImg");
        surroundingEnterprisesFBIVo.setImgList(imgByDate);

        map.put("message","????????????");
        map.put("status",true);
        map.put("data",surroundingEnterprisesFBIVo);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SurroundingEnterprisesInsert surroundingEnterprisesInsert) {
        map = new HashMap<>();
        try {
            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
            sysSurroundingEnterprisesDo.setId(surroundingEnterprisesInsert.getId());//??????????????????id
            sysSurroundingEnterprisesDo.setName(surroundingEnterprisesInsert.getName());//??????????????????
            sysSurroundingEnterprisesDo.setContent(surroundingEnterprisesInsert.getContent());//??????????????????
            sysSurroundingEnterprisesDo.setReleaseStatus(surroundingEnterprisesInsert.getReleaseStatus());//??????????????????
            if (surroundingEnterprisesInsert.getReleaseStatus() == 1){//1.??????
                sysSurroundingEnterprisesDo.setReleaseDate(new Date());//??????????????????
            }
            sysSurroundingEnterprisesDo.setModifyId(sysUser.getId());//?????????????????????id
            sysSurroundingEnterprisesDo.setModifyDate(new Date());//??????????????????
            int update = sysSurroundingEnterprisesMapper.updateById(sysSurroundingEnterprisesDo);
            if (update <= 0){
                throw new RuntimeException("????????????");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg");
            uploadUtil.saveUrlToDB(surroundingEnterprisesInsert.getImgUrls(),"sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg","600",30,20);

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
                int delete = sysSurroundingEnterprisesMapper.deleteById(id);
                if (delete <= 0){
                    throw new RuntimeException("????????????");
                }

                UploadUtil uploadUtil = new UploadUtil();
                uploadUtil.delete("sysSurroundingEnterprises",id,"surroundingEnterprisesImg");
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
    public Map<String, Object> release(Integer surroundingEnterprisesId) {
        map = new HashMap<>();

        SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
        sysSurroundingEnterprisesDo.setId(surroundingEnterprisesId);
        sysSurroundingEnterprisesDo.setReleaseStatus(1);//?????????????????? 1.??????
        sysSurroundingEnterprisesDo.setReleaseDate(new Date());//??????????????????
        int update = sysSurroundingEnterprisesMapper.updateById(sysSurroundingEnterprisesDo);
        if (update > 0){
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> noRelease(Integer surroundingEnterprisesId) {
        map = new HashMap<>();

        SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
        sysSurroundingEnterprisesDo.setId(surroundingEnterprisesId);
        sysSurroundingEnterprisesDo.setReleaseStatus(2);//?????????????????? 2.?????????
        int update = sysSurroundingEnterprisesMapper.updateById(sysSurroundingEnterprisesDo);
        if (update > 0){
            map.put("message","??????????????????");
            map.put("status",true);
        }else {
            map.put("message","??????????????????");
            map.put("status",false);
        }
        return map;
    }
}
