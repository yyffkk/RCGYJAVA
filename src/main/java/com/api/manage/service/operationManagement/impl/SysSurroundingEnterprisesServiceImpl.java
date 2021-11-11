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
    public Map<String, Object> insert(SurroundingEnterprisesInsert surroundingEnterprisesInsert) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
            sysSurroundingEnterprisesDo.setName(surroundingEnterprisesInsert.getName());//填入企业名称
            sysSurroundingEnterprisesDo.setContent(surroundingEnterprisesInsert.getContent());//填入企业介绍
            sysSurroundingEnterprisesDo.setReleaseStatus(surroundingEnterprisesInsert.getReleaseStatus());//填入发布状态
            if (surroundingEnterprisesInsert.getReleaseStatus() == 1){//1.发布
                sysSurroundingEnterprisesDo.setReleaseDate(new Date());//填入发布时间
            }
            sysSurroundingEnterprisesDo.setCreateId(sysUser.getId());//填入创建人主键id
            sysSurroundingEnterprisesDo.setCreateDate(new Date());//填入创建时间
            int insert = sysSurroundingEnterprisesMapper.insert(sysSurroundingEnterprisesDo);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(surroundingEnterprisesInsert.getImgUrls(),"sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg","600",30,20);

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
        map.put("message","添加成功");
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

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",surroundingEnterprisesFBIVo);
        return map;
    }

    @Override
    public Map<String, Object> update(SurroundingEnterprisesInsert surroundingEnterprisesInsert) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
            sysSurroundingEnterprisesDo.setId(surroundingEnterprisesInsert.getId());//填入企业主键id
            sysSurroundingEnterprisesDo.setName(surroundingEnterprisesInsert.getName());//填入企业名称
            sysSurroundingEnterprisesDo.setContent(surroundingEnterprisesInsert.getContent());//填入企业介绍
            sysSurroundingEnterprisesDo.setReleaseStatus(surroundingEnterprisesInsert.getReleaseStatus());//填入发布状态
            if (surroundingEnterprisesInsert.getReleaseStatus() == 1){//1.发布
                sysSurroundingEnterprisesDo.setReleaseDate(new Date());//填入发布时间
            }
            sysSurroundingEnterprisesDo.setModifyId(sysUser.getId());//填入修改人主键id
            sysSurroundingEnterprisesDo.setModifyDate(new Date());//填入修改时间
            int update = sysSurroundingEnterprisesMapper.updateById(sysSurroundingEnterprisesDo);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg");
            uploadUtil.saveUrlToDB(surroundingEnterprisesInsert.getImgUrls(),"sysSurroundingEnterprises",sysSurroundingEnterprisesDo.getId(),"surroundingEnterprisesImg","600",30,20);

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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = sysSurroundingEnterprisesMapper.deleteById(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
                }

                UploadUtil uploadUtil = new UploadUtil();
                uploadUtil.delete("sysSurroundingEnterprises",id,"surroundingEnterprisesImg");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> release(Integer surroundingEnterprisesId) {
        map = new HashMap<>();

        SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo = new SysSurroundingEnterprisesDo();
        sysSurroundingEnterprisesDo.setId(surroundingEnterprisesId);
        sysSurroundingEnterprisesDo.setReleaseStatus(1);//填入发布状态 1.发布
        sysSurroundingEnterprisesDo.setReleaseDate(new Date());//填入发布时间
        int update = sysSurroundingEnterprisesMapper.updateById(sysSurroundingEnterprisesDo);
        if (update > 0){
            map.put("message","发布成功");
            map.put("status",true);
        }else {
            map.put("message","发布失败");
            map.put("status",false);
        }
        return map;
    }
}
