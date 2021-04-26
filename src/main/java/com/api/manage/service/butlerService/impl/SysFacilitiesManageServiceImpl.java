package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesManageDao;
import com.api.manage.service.butlerService.SysFacilitiesManageService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesManage;
import com.api.model.butlerService.SearchFacilitiesManage;
import com.api.vo.butlerService.VoFacilitiesManage;
import com.api.vo.butlerService.VoFacilitiesManageDetail;
import com.api.vo.butlerService.VoFacilitiesManageFBI;
import com.api.vo.butlerService.VoFacilitiesManageSituation;
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
public class SysFacilitiesManageServiceImpl implements SysFacilitiesManageService {
    private static Map<String,Object> map = null;

    @Resource
    SysFacilitiesManageDao sysFacilitiesManageDao;

    @Override
    public List<VoFacilitiesManage> list(SearchFacilitiesManage searchFacilitiesManage) {
        return sysFacilitiesManageDao.list(searchFacilitiesManage);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(FacilitiesManage facilitiesManage) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            facilitiesManage.setCreateId(sysUser.getId());
            facilitiesManage.setCreateDate(new Date());
            facilitiesManage.setIsDelete(1); //填入是否删除 默认为1.非删
            facilitiesManage.setStatus(1); //填入默认状态 1.空置中

            //对设施分类数量 加一
            int inc = sysFacilitiesManageDao.incCategory(facilitiesManage.getFacilitiesCategoryId());
            if (inc <= 0){
                throw new RuntimeException("累加失败");
            }

            int insert = sysFacilitiesManageDao.insert(facilitiesManage);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
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

        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> update(FacilitiesManage facilitiesManage) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        facilitiesManage.setModifyId(sysUser.getId());
        facilitiesManage.setModifyDate(new Date());

        int update = sysFacilitiesManageDao.update(facilitiesManage);
        if (update <= 0){
            map.put("message","修改失败");
            map.put("status",false);
        }else {
            map.put("message","修改成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> findDetailById(Integer id) {
        map = new HashMap<>();
        VoFacilitiesManageFBI voFacilitiesManageFBI = new VoFacilitiesManageFBI();

        VoFacilitiesManageDetail voFacilitiesManageDetail = sysFacilitiesManageDao.findDetailById(id);
        voFacilitiesManageFBI.setDetail(voFacilitiesManageDetail);
        if (voFacilitiesManageDetail != null && voFacilitiesManageDetail.getStatus() == 3){
            List<VoFacilitiesManageSituation> voFacilitiesManageSituation = sysFacilitiesManageDao.findSituationById(voFacilitiesManageDetail.getId());
            voFacilitiesManageFBI.setSituation(voFacilitiesManageSituation.get(0));
            //TODO 照片信息
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFacilitiesManageFBI);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                VoFacilitiesManageDetail detailById = sysFacilitiesManageDao.findDetailById(id);

                int dec = sysFacilitiesManageDao.decCategoryNum(detailById.getFacilitiesCategoryId());
                if (dec <= 0){
                    throw new RuntimeException("累减失败");
                }
                //TODO 做个条件限制，不可直接删除

                int update = sysFacilitiesManageDao.delete(id);
                if (update <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        //根据设施主键ID查询设施状态
        int status = sysFacilitiesManageDao.findStatusById(id);
        if (status != 3){
            map.put("message","此设施不处于停用状态，不可开启");
            map.put("status",false);
            return map;
        }
        int update = sysFacilitiesManageDao.isEnable(id);
        if (update <= 0){
            map.put("message","开启失败");
            map.put("status",false);
        }else {
            map.put("message","开启成功");
            map.put("status",true);
        }
        return map;
    }
}
