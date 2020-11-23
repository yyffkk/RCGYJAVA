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
    public Map<String, Object> insert(UserResident userResident, List<VoRelatives> voRelativesList, List<Integer> buildingUnitEstateIds) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //判断是否关联房产（房产一定要关联）
        if (buildingUnitEstateIds ==null || buildingUnitEstateIds.size()<=0){
            map.put("message","添加租户信息失败，请关联至少一栋楼栋单元房产信息");
            map.put("status",false);
            return map;
        }
        //添加租客信息
        userResident.setCreateId(sysUser.getId());
        userResident.setCreateDate(new Date());
        userResident.setType(RESIDENT_TYPE);
        int insert = userResidentDao.insert(userResident);
        if (insert <= 0){
            throw new RuntimeException("添加租客信息失败");
        }

        //关联组客房产信息
        for (Integer buildingUnitEstateId : buildingUnitEstateIds) {
            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
            cpmResidentEstate.setBuildingUnitEstateId(buildingUnitEstateId);
            cpmResidentEstate.setResidentId(userResident.getId());
            //添加业主房产关联信息
            int i = userTenantDao.insertResidentEstate(cpmResidentEstate);
            //更新房产状态 5.已租
            CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();
            cpmBuildingUnitEstate.setId(buildingUnitEstateId);
            cpmBuildingUnitEstate.setStatus(5);
            int j = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
            if (i <= 0 || j<= 0){
                throw new RuntimeException("关联租户房产信息失败");
            }
        }

        //关联亲属信息
        for (VoRelatives voRelatives : voRelativesList) {
            //添加亲属信息
            voRelatives.setType(2);
            voRelatives.setCreateId(sysUser.getId());
            voRelatives.setCreateDate(new Date());
            int insertRelatives = userResidentDao.insertRelatives(voRelatives);
            //添加业主亲属关联表
            UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
            userResidentRelatives.setIdentity(voRelatives.getIdentity());
            userResidentRelatives.setRelativesId(voRelatives.getId());
            userResidentRelatives.setResidentId(userResident.getId());
            int insertResidentRelatives = userResidentDao.insertResidentRelatives(userResidentRelatives);
            if (insertRelatives <=0 || insertResidentRelatives <= 0){
                throw new RuntimeException("关联租户亲属信息失败");
            }
            //关联亲属房产信息
            for (Integer buildingUnitEstateId : buildingUnitEstateIds) {
                CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                cpmResidentEstate.setBuildingUnitEstateId(buildingUnitEstateId);
                cpmResidentEstate.setResidentId(voRelatives.getId());
                //添加亲属房产关联信息
                int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
                if (i <= 0){
                    throw new RuntimeException("关联亲属房产信息失败");
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

        //查询业主关联亲属信息
        List<VoRelatives> voRelativesList = userResidentDao.findRelativesById(id);

        map.put("voRelativesList",voRelativesList);
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",cpmBuildingUnitEstateList);
        return map;
    }

    @Override
    public Map<String, Object> update(VoUpdateTenant voUpdateTenant) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //修改租户信息
        int update = userResidentDao.update(voUpdateTenant.getUserResident());
        if (update<=0){
            map.put("message","修改业主信息失败");
            map.put("status",false);
            return map;
        }
        //删除租房信息




        return null;
    }
}
