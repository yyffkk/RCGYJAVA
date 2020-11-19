package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.*;
import com.aku.model.basicArchives.*;
import com.aku.model.system.SysUser;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateResident;
import com.aku.service.basicArchives.UserResidentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserResidentServiceImpl implements UserResidentService {
    private final Map<String,Object> map = new HashMap<>();
    //设置业主类型，1业主
    private static final int RESIDENT_TYPE = 1;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    CpmParkingSpaceDao cpmParkingSpaceDao;
    @Resource
    CpmBuildingDao cpmBuildingDao;
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<UserResident> list(UserResident userResident) {
        return userResidentDao.list(userResident);
    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident, List<VoRelatives>  voRelativesList, List<Integer> cpmParkingSpaceIds, List<Integer> buildingUnitEstateIds) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //判断是否关联房产（房产一定要关联）
        if (buildingUnitEstateIds ==null || buildingUnitEstateIds.size()<=0){
            map.put("message","添加业主信息失败，请关联至少一栋楼栋单元房产信息");
            map.put("status",false);
            return map;
        }
        //添加业主信息
        userResident.setCreateId(sysUser.getId());
        userResident.setCreateDate(new Date());
        userResident.setType(RESIDENT_TYPE);
        int insert = userResidentDao.insert(userResident);
        if (insert <= 0){
            throw new RuntimeException("添加业主信息失败");
        }

        //关联业主房产信息
        for (Integer buildingUnitEstateId : buildingUnitEstateIds) {
            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
            cpmResidentEstate.setBuildingUnitEstateId(buildingUnitEstateId);
            cpmResidentEstate.setResidentId(userResident.getId());
            //添加业主房产关联信息
            int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
            if (i <= 0){
                throw new RuntimeException("关联业主房产信息失败");
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
                throw new RuntimeException("关联亲属信息失败");
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

        //添加车位信息
        if (cpmParkingSpaceIds != null){
            for (Integer cpmParkingSpaceId : cpmParkingSpaceIds) {
                CpmParkingSpace cpmParkingSpace = new CpmParkingSpace();
                cpmParkingSpace.setId(cpmParkingSpaceId);
                cpmParkingSpace.setResidentId(userResident.getId());
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
        map.put("message","添加业主信息成功，已关联楼栋单元房产信息");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(VoUpdateResident voUpdateResident) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //修改业主信息
        int update = userResidentDao.update(voUpdateResident.getUserResident());
        if (update<=0){
            map.put("message","修改业主信息失败");
            map.put("status",false);
            return map;
        }
        //删除亲属信息
        int[] deleteRelativesId = voUpdateResident.getDeleteRelativesId();
        if ( deleteRelativesId != null){
            for (int id : deleteRelativesId) {
                int delete = userResidentDao.deleteRelativesId(id);
                if (delete <= 0){
                    throw new RuntimeException("删除亲属失败");
                }
            }
        }

        //修改家属信息
        List<VoRelatives> voRelativesList = voUpdateResident.getUpdateRelatives();
        if (voRelativesList!=null){
            for (VoRelatives voRelatives : voRelativesList) {
                UserResident userResident = new UserResident();
                userResident.setId(voRelatives.getId());
                userResident.setTel(voRelatives.getTel());
                userResident.setIdType(voRelatives.getIdType());
                userResident.setIdNumber(voRelatives.getIdNumber());
                //修改家属基础信息
                int update2 = userResidentDao.update(userResident);
                //修改家属关联身份信息
                UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
                userResidentRelatives.setIdentity(voRelatives.getIdentity());
                userResidentRelatives.setRelativesId(voRelatives.getId());
                userResidentRelatives.setResidentId(voUpdateResident.getUserResident().getId());
                int update3 = userResidentDao.updateResidentRelatives(userResidentRelatives);
                if (update2<=0 || update3<=0){
                    throw new RuntimeException("修改家属信息失败");
                }
            }
        }


        //添加家属信息
        List<VoRelatives> insertRelatives = voUpdateResident.getInsertRelatives();
        if (insertRelatives!=null){
            for (VoRelatives voRelatives : insertRelatives) {
                //添加亲属信息
                voRelatives.setType(2);
                voRelatives.setCreateId(sysUser.getId());
                voRelatives.setCreateDate(new Date());
                int insertRelatives2 = userResidentDao.insertRelatives(voRelatives);
                //添加业主亲属关联表
                UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
                userResidentRelatives.setIdentity(voRelatives.getIdentity());
                userResidentRelatives.setRelativesId(voRelatives.getId());
                userResidentRelatives.setResidentId(voUpdateResident.getUserResident().getId());
                int insertResidentRelatives = userResidentDao.insertResidentRelatives(userResidentRelatives);
                if (insertRelatives2 <=0 || insertResidentRelatives <= 0){
                    throw new RuntimeException("关联亲属信息失败");
                }
                //关联亲属房产信息
                List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(voUpdateResident.getUserResident().getId());
                for (CpmBuildingUnitEstate cpmBuildingUnitEstate : byResidentId) {
                    CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                    cpmResidentEstate.setBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
                    cpmResidentEstate.setResidentId(voRelatives.getId());
                    //添加亲属房产关联信息
                    int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
                    if (i <= 0){
                        throw new RuntimeException("关联亲属房产信息失败");
                    }
                }

            }
        }
        map.put("message","修改业主信息成功");
        map.put("status",true);
        return map;
    }



    @Override
    public UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId) {
        return userResidentDao.findByBuildingUnitEstateId(buildingUnitEstateId);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询住户所拥有的房产
        List<CpmBuildingUnitEstate> cpmBuildingUnitEstateList = cpmBuildingUnitEstateDao.findByResidentId(id);
        cpmBuildingUnitEstateDao.findById(id);
        ArrayList<Object> objects = new ArrayList<>();
        //遍历查询出房产对应的单元和楼栋
        for (CpmBuildingUnitEstate cpmBuildingUnitEstate : cpmBuildingUnitEstateList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(cpmBuildingUnitEstate.getBuildingUnitId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            objects.add(cpmBuilding.getId()+","+cpmBuildingUnit.getId()+","+cpmBuildingUnitEstate.getId());
        }
        //查询业主所有的车位，判断是否有车位
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByResidentId(id);
        ArrayList<Object> objects1 = new ArrayList<>();
        //遍历查询所有的车位id
        for (CpmParkingSpace cpmParkingSpace : cpmParkingSpaceList) {
            objects1.add(cpmParkingSpace.getId());
        }

        //查询业主关联亲属信息
        List<VoRelatives> voRelativesList = userResidentDao.findRelativesById(id);

        map.put("voRelativesList",voRelativesList);
        map.put("cpmParkingSpaceIdList",objects1);
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",objects);
        return map;
    }

    @Override
    public Map<String, Object> delete(int id) {
        List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(id);
        if (byResidentId != null && byResidentId.size()>0){
            map.put("message","该业主有房产，无法删除");
            map.put("status",false);
            return map;
        }
        List<CpmParkingSpace> byResidentId1 = cpmParkingSpaceDao.findByResidentId(id);
        if (byResidentId1 != null && byResidentId1.size()>0){
            map.put("message","该业主有车位，无法删除");
            map.put("status",false);
            return map;
        }
        int delete = userResidentDao.delete();
        if (delete > 0){
            map.put("message","删除业主成功");
            map.put("status",true);
        }else {
            map.put("message","删除业主失败");
            map.put("status",false);
        }
        return map;
    }

}
