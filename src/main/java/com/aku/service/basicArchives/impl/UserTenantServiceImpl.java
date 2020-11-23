package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.*;
import com.aku.model.basicArchives.*;
import com.aku.model.system.SysUser;
import com.aku.service.basicArchives.UserTenantService;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoTenantCpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoUpdateTenant;
import com.aku.vo.basicArchives.VoUserTenant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserTenantServiceImpl implements UserTenantService {
    private final Map<String,Object> map = new HashMap<>();
    //设置业主类型，3租客
    private static final int RESIDENT_TYPE = 3;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    CpmParkingSpaceDao cpmParkingSpaceDao;
    @Resource
    UserTenantDao userTenantDao;
    @Resource
    CpmBuildingDao cpmBuildingDao;
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<VoUserTenant> list(UserResident userTenant) {
        List<VoUserTenant> voUserTenantList = userTenantDao.list(userTenant);
        for (VoUserTenant userTenantList : voUserTenantList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(userTenantList.getRoomId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            userTenantList.setRoomName(cpmBuilding.getId()+"-"+cpmBuildingUnit.getId()+"-"+userTenantList.getRoomId());
        }
        return voUserTenantList;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(UserTenantInsert userTenantInsert) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //判断是否关联房产（房产一定要关联）
        if (userTenantInsert.getCpmResidentEstateList() ==null || userTenantInsert.getCpmResidentEstateList().size()<=0){
            map.put("message","添加租户信息失败，请关联至少一栋楼栋单元房产信息");
            map.put("status",false);
            return map;
        }
        //添加租客信息
        UserResident userResident = userTenantInsert.getUserResident();
        userResident.setCreateId(sysUser.getId());
        userResident.setCreateDate(new Date());
        userResident.setType(RESIDENT_TYPE);
        int insert = userResidentDao.insert(userResident);
        if (insert <= 0){
            throw new RuntimeException("添加租客信息失败");
        }

        //关联组客房产信息
        for (CpmResidentEstate cpmResidentEstate : userTenantInsert.getCpmResidentEstateList()) {
            cpmResidentEstate.setResidentId(userResident.getId());
            //添加业主房产关联信息
            int i = userTenantDao.insertResidentEstate(cpmResidentEstate);
            //更新房产状态 5.已租
            CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();
            cpmBuildingUnitEstate.setId(cpmResidentEstate.getBuildingUnitEstateId());
            cpmBuildingUnitEstate.setStatus(5);
            int j = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
            if (i <= 0 || j<= 0){
                throw new RuntimeException("关联租户房产信息失败");
            }
        }

        //关联亲属信息
        for (UserResident relatives : userTenantInsert.getVoRelativesList()) {
            //添加亲属信息
            relatives.setType(2);
            relatives.setCreateId(sysUser.getId());
            relatives.setCreateDate(new Date());
            int insertRelatives = userResidentDao.insert(relatives);
            if (insertRelatives <= 0){
                throw new RuntimeException("添加租户亲属信息失败");
            }
            //添加业主亲属关联表
            UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
            userResidentRelatives.setIdentity(relatives.getIdentity());
            userResidentRelatives.setRelativesId(relatives.getId());
            userResidentRelatives.setResidentId(userResident.getId());
            int insertResidentRelatives = userResidentDao.insertResidentRelatives(userResidentRelatives);
            if (insertResidentRelatives <= 0){
                throw new RuntimeException("关联租户亲属信息失败");
            }
        }

        //添加车位信息
        if (userTenantInsert.getCpmParkingSpaceList() != null){
            for (CpmParkingSpace cpmParkingSpace : userTenantInsert.getCpmParkingSpaceList()) {
                cpmParkingSpace.setUserId(userResident.getId());
                cpmParkingSpace.setModifyId(sysUser.getId());
                cpmParkingSpace.setModifyDate(new Date());
                int update = cpmParkingSpaceDao.update(cpmParkingSpace);
                if (update>0){
                    map.put("message","添加业主信息成功，已关联楼栋单元房产信息,及其成功关联车位");
                    map.put("status",true);
                }else {
                    throw new RuntimeException("关联车位信息失败");
                }
            }
        }


        map.put("message","添加租户信息成功，已关联楼栋单元房产信息");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        //根据id查询租户信息
        UserResident userResident = userResidentDao.findById(id);

        //查询租户所使用的房产
        List<VoTenantCpmBuildingUnitEstate> cpmBuildingUnitEstateList = cpmBuildingUnitEstateDao.findByTenantId(id);
        //遍历查询出房产对应的单元和楼栋
        for (VoTenantCpmBuildingUnitEstate voTenantCpmBuildingUnitEstate : cpmBuildingUnitEstateList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(voTenantCpmBuildingUnitEstate.getBuildingUnitId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            voTenantCpmBuildingUnitEstate.setRoomName(cpmBuilding.getId()+"-"+cpmBuildingUnit.getId()+"-"+voTenantCpmBuildingUnitEstate.getRoomNumber());
        }
        //查询租户所有的车位，判断是否有租车位
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByUserId(id);
        if (cpmParkingSpaceList != null && cpmParkingSpaceList.size()>0){
            map.put("cpmParkingSpaceList",cpmParkingSpaceList);
        }

        //查询租户关联亲属信息
        List<VoRelatives> voRelativesList = userResidentDao.findRelativesById(id);
        map.put("voRelativesList",voRelativesList);
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",cpmBuildingUnitEstateList);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelativesList) {
        boolean flag = true;
        //修改租户信息
        int update = userResidentDao.update(residentAndRelativesList.getUserResident());
        if (update <= 0){
            flag =false;
        }
        //删除关联亲属信息信息
        List<VoRelatives> relativesById = userResidentDao.findRelativesById(residentAndRelativesList.getUserResident().getId());
        if (relativesById != null){
            for (VoRelatives voRelatives : relativesById) {
                int delete = userResidentDao.deleteByResidentIdAndRelativesId(new ResidentIdAndRelativesId(residentAndRelativesList.getUserResident().getId(),voRelatives.getId()));
                if (delete <= 0){
                    flag = false;
                }
            }
        }
        //再添加业主的关联亲属
        if (residentAndRelativesList.getUserRelatives() != null){
            for (UserResident userRelative : residentAndRelativesList.getUserRelatives()) {
                //添加亲属信息
                userResidentDao.insert(userRelative);
                //添加业主亲属关联信息
                UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
                userResidentRelatives.setRelativesId(userRelative.getId());
                userResidentRelatives.setResidentId(residentAndRelativesList.getUserResident().getId());
                userResidentRelatives.setIdentity(userRelative.getIdentity());
                int insertResidentRelatives = userResidentDao.insertResidentRelatives(userResidentRelatives);
                if (insertResidentRelatives <=0){
                    flag = false;
                }
            }
        }
        if (flag){
            map.put("message","修改租户亲属关联信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改租户亲属关联信息失败");
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateEstate(List<CpmResidentEstate> cpmResidentEstateList,Integer tenantId) {
        boolean flag = true;
        //先删除租客房产关联信息
        List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(tenantId);
        if (byResidentId != null){
            for (CpmBuildingUnitEstate cpmBuildingUnitEstate : byResidentId) {
                int delete = userResidentDao.deleteByResidentIdAndEstateId(new ResidentIdAndEstateId(tenantId, cpmBuildingUnitEstate.getId()));
                if (delete <=0){
                    flag = false;
                }
            }
        }
        //再添加租哭房产关联信息
        if (cpmResidentEstateList != null){
            for (CpmResidentEstate cpmResidentEstate : cpmResidentEstateList) {
                int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
                if (i<=0){
                    flag = false;
                }
            }
        }
        if (flag){
            map.put("message","修改租户房产关联信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改租户房产关联信息失败");
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateParkingSpace(List<CpmParkingSpace> cpmParkingSpaceList,Integer tenantId) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        boolean flag = true;
        //先删除租客车位关联信息
        List<CpmParkingSpace> byUserId = cpmParkingSpaceDao.findByUserId(tenantId);
        if (byUserId != null){
            for (CpmParkingSpace cpmParkingSpace : byUserId) {
                //将使用者这栏置为空（将车位变为空置状态）
                cpmParkingSpace.setUserId(null);
                int update = cpmParkingSpaceDao.update(cpmParkingSpace);
                if (update <= 0){
                    flag =false;
                }
            }
        }

        //再添加租客车位关联信息
        if (cpmParkingSpaceList != null){
            for (CpmParkingSpace cpmParkingSpace : cpmParkingSpaceList) {
                cpmParkingSpace.setModifyDate(new Date());
                cpmParkingSpace.setModifyId(sysUser.getId());
                cpmParkingSpace.setUserId(tenantId);
                cpmParkingSpaceDao.update(cpmParkingSpace);
            }
        }

        if (flag){
            map.put("message","修改租户车位关联信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改租户车位关联信息失败");
        }
        return map;
    }


}
