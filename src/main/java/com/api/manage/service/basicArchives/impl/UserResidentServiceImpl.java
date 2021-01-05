package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.*;
import com.api.model.basicArchives.*;
import com.api.model.system.SysUser;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.basicArchives.VoRelatives;
import com.api.manage.service.basicArchives.UserResidentService;
import com.api.vo.basicArchives.VoUserResident;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserResidentServiceImpl implements UserResidentService {
    private static Map<String,Object> map = null;
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
    public List<VoUserResident> list(UserResident userResident) {
        return userResidentDao.list(userResident);
    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident, List<VoRelatives>  voRelativesList, int[] cpmParkingSpaceIds, int[] buildingUnitEstateIds) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //判断是否关联房产（房产一定要关联）
        if (buildingUnitEstateIds ==null || buildingUnitEstateIds.length<=0){
            map.put("message","添加业主信息失败，请关联至少一栋楼栋单元房产信息");
            map.put("status",false);
            return map;
        }

        //校验重复
        //根据业主手机号查询是否已有业主信息
        UserResident userResident1 = userResidentDao.findByTel(userResident.getTel());
        if (userResident1 != null){
            map.put("message","业主手机号已存在");
            map.put("status",false);
            return map;
        }

        //根据业主证件号码查询是否已有业主信息
        UserResident userResident2 = userResidentDao.findByIdNumber(userResident.getIdNumber());
        if (userResident2 != null){
            map.put("message","业主证件号码已存在");
            map.put("status",false);
            return map;
        }

        try {
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
                //更新房产状态 1.入住
                CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();
                cpmBuildingUnitEstate.setId(buildingUnitEstateId);
                cpmBuildingUnitEstate.setStatus(1);
                int j = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
                if (i <= 0 || j<=0){
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
                    if (update<=0){
                        throw new RuntimeException("关联车位信息失败");
                    }
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
        map.put("message","添加业主信息成功");
        map.put("status",true);
        return map;
    }



    @Override
    public List<UserResident> findByBuildingUnitEstateId(Integer buildingUnitEstateId) {
        return userResidentDao.findByBuildingUnitEstateId(buildingUnitEstateId);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询住户所拥有的房产
        List<CpmBuildingUnitEstate> cpmBuildingUnitEstateList = cpmBuildingUnitEstateDao.findByResidentId(id);
        ArrayList<Object> cpmBuildingUnitEstateIdList = new ArrayList<>();
        //遍历查询出房产对应的单元和楼栋
        for (CpmBuildingUnitEstate cpmBuildingUnitEstate : cpmBuildingUnitEstateList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(cpmBuildingUnitEstate.getBuildingUnitId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            cpmBuildingUnitEstateIdList.add(cpmBuilding.getId()+"-"+cpmBuildingUnit.getId()+"-"+cpmBuildingUnitEstate.getId());
        }
        //查询业主所有的车位，判断是否有车位
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByResidentId(id);
        ArrayList<Object> cpmParkingSpaceIdList = new ArrayList<>();
        //遍历查询所有的车位id
        for (CpmParkingSpace cpmParkingSpace : cpmParkingSpaceList) {
            cpmParkingSpaceIdList.add(cpmParkingSpace.getId());
        }

        //查询业主关联亲属信息
        List<VoRelatives> voRelativesList = userResidentDao.findRelativesById(id);

        map.put("voRelativesList",voRelativesList);
        map.put("cpmParkingSpaceIdList",cpmParkingSpaceIdList);
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",cpmBuildingUnitEstateIdList);
        return map;
    }

    @Override
    public Map<String, Object> findRelativesById(Integer id) {
        map = new HashMap<>();
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询业主关联亲属信息
        List<VoRelatives> voRelativesList = userResidentDao.findRelativesById(id);
        map.put("userResident",userResident);
        map.put("voRelativesList",voRelativesList);
        return map;
    }

    @Override
    public Map<String, Object> findEstateById(Integer id) {
        map = new HashMap<>();
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询住户所拥有的房产
        List<CpmBuildingUnitEstate> cpmBuildingUnitEstateList = cpmBuildingUnitEstateDao.findByResidentId(id);
        ArrayList<Object> cpmBuildingUnitEstateIdList = new ArrayList<>();
        //遍历查询出房产对应的单元和楼栋
        for (CpmBuildingUnitEstate cpmBuildingUnitEstate : cpmBuildingUnitEstateList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(cpmBuildingUnitEstate.getBuildingUnitId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            cpmBuildingUnitEstateIdList.add(cpmBuilding.getId()+"-"+cpmBuildingUnit.getId()+"-"+cpmBuildingUnitEstate.getId());
        }
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",cpmBuildingUnitEstateIdList);
        return map;
    }

    @Override
    public Map<String, Object> findParkingSpaceById(Integer id) {
        map = new HashMap<>();
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询业主所有的车位，判断是否有车位
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByResidentId(id);
        ArrayList<Object> cpmParkingSpaceIdList = new ArrayList<>();
        //遍历查询所有的车位id
        for (CpmParkingSpace cpmParkingSpace : cpmParkingSpaceList) {
            cpmParkingSpaceIdList.add(cpmParkingSpace.getId());
        }
        map.put("cpmParkingSpaceIdList",cpmParkingSpaceIdList);
        map.put("userResident",userResident);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(id);
                if (byResidentId != null && byResidentId.size()>0){
                    throw new RuntimeException("存在业主有房产，无法删除");
                }
                List<CpmParkingSpace> byResidentId1 = cpmParkingSpaceDao.findByResidentId(id);
                if (byResidentId1 != null && byResidentId1.size()>0){
                    throw new RuntimeException("存在业主有车位，无法删除");
                }
                //先删除业主对应的亲属信息
                //根据业主id查询亲属信息
                List<VoRelatives> relativesById = userResidentDao.findRelativesById(id);
                if (relativesById != null){
                    for (VoRelatives voRelatives : relativesById) {
                        //删除业主亲属关联信息
                        int delete = userResidentDao.deleteByResidentIdAndRelativesId(new ResidentIdAndRelativesId(id, voRelatives.getId()));
                        if (delete<=0){
                            throw new RuntimeException("存在业主亲属关联信息删除失败");
                        }
                        //删除亲属信息
                        int delete1 = userResidentDao.delete(voRelatives.getId());
                        if (delete1<=0){
                            throw new RuntimeException("存在亲属信息删除失败");
                        }
                    }
                }

                //删除业主信息
                int delete = userResidentDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除业主失败");
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

        map.put("message","批量删除业主成功");
        map.put("status",true);
        return map;
    }


    @Override
    @Transactional
    public Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelatives) {
        map = new HashMap<>();
        //校验重复
        //根据业主手机号查询是否已有业主信息
        UserResident userResident1 = userResidentDao.findByTel(residentAndRelatives.getUserResident().getTel());
        if (userResident1 != null){
            //如果输入id与查询到的id不一致，则修改了业主手机号信息，并且业主手机号重复
            if (!userResident1.getId().equals(residentAndRelatives.getUserResident().getId())){
                map.put("message","业主手机号已存在");
                map.put("status",false);
                return map;
            }
        }

        //根据业主证件号码查询是否已有业主信息
        UserResident userResident2 = userResidentDao.findByIdNumber(residentAndRelatives.getUserResident().getIdNumber());
        if (userResident2 != null){
            //如果输入id与查询到的id不一致，则修改了业主手机号信息，并且业主手机号重复
            if (!userResident2.getId().equals(residentAndRelatives.getUserResident().getId())){
                map.put("message","业主证件号码已存在");
                map.put("status",false);
                return map;
            }
        }

        try {
            //修改业主信息
            int update = userResidentDao.update(residentAndRelatives.getUserResident());
            if (update <= 0){
                throw new RuntimeException("修改业主信息失败");
            }

            //先删除业主的关联亲属
            List<VoRelatives> relativesById = userResidentDao.findRelativesById(residentAndRelatives.getUserResident().getId());
            if (relativesById != null){
                for (VoRelatives voRelatives : relativesById) {
                    int delete = userResidentDao.deleteByResidentIdAndRelativesId(new ResidentIdAndRelativesId(residentAndRelatives.getUserResident().getId(),voRelatives.getId()));
                    if (delete <= 0){
                        throw new RuntimeException("修改业主关联亲属信息失败");
                    }
                }
            }
//        再添加业主的关联亲属
            if (residentAndRelatives.getUserRelatives() != null){
                for (UserResident userRelative : residentAndRelatives.getUserRelatives()) {
                    //添加亲属信息
                    userResidentDao.insert(userRelative);
                    //添加业主亲属关联信息
                    UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
                    userResidentRelatives.setRelativesId(userRelative.getId());
                    userResidentRelatives.setResidentId(residentAndRelatives.getUserResident().getId());
                    userResidentRelatives.setIdentity(userRelative.getIdentity());
                    int insertResidentRelatives = userResidentDao.insertResidentRelatives(userResidentRelatives);
                    if (insertResidentRelatives <=0){
                        throw new RuntimeException("修改业主关联亲属信息失败");
                    }
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

        map.put("message","修改业主关联亲属信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateEstate(ResidentAndEstateIds residentAndEstateIds) {

        map = new HashMap<>();
        try {
            //先删除业主的关联房产
            List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(residentAndEstateIds.getUserResident().getId());
            if (byResidentId != null){
                for (CpmBuildingUnitEstate cpmBuildingUnitEstate : byResidentId) {
                    int delete = userResidentDao.deleteByResidentIdAndEstateId(new ResidentIdAndEstateId(residentAndEstateIds.getUserResident().getId(), cpmBuildingUnitEstate.getId()));
                    if (delete <=0){
                        throw new RuntimeException("修改业主关联房产信息失败");
                    }
                }
            }

            //再添加业主的关联房产
            if (residentAndEstateIds.getEstateIds() != null){
                for (Integer estateId : residentAndEstateIds.getEstateIds()) {
                    CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                    cpmResidentEstate.setResidentId(residentAndEstateIds.getUserResident().getId());
                    cpmResidentEstate.setBuildingUnitEstateId(estateId);
                    int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
                    if (i<=0){
                        throw new RuntimeException("修改业主关联房产信息失败");
                    }
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

        map.put("message","修改业主关联房产信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateParkingSpace(ResidentAndParkingSpaceIds residentAndParkingSpaceIds) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        try {
            //先删除业主的关联车位
            List<CpmParkingSpace> byResidentId = cpmParkingSpaceDao.findByResidentId(residentAndParkingSpaceIds.getUserResident().getId());
            if (byResidentId != null){
                for (CpmParkingSpace cpmParkingSpace : byResidentId) {
                    //将使用者这栏置为空（将车位变为空置状态）
                    cpmParkingSpace.setResidentId(null);
                    int update = cpmParkingSpaceDao.update(cpmParkingSpace);
                    if (update <= 0){
                        throw new RuntimeException("修改业主关联车位信息失败");
                    }
                }
            }
            //再添加业主的关联车位
            if (residentAndParkingSpaceIds.getCpmParkingSpaceIds() != null){
                for (Integer cpmParkingSpaceId : residentAndParkingSpaceIds.getCpmParkingSpaceIds()) {
                    CpmParkingSpace cpmParkingSpace = cpmParkingSpaceDao.findById(cpmParkingSpaceId);
                    cpmParkingSpace.setModifyDate(new Date());
                    cpmParkingSpace.setModifyId(sysUser.getId());
                    cpmParkingSpace.setResidentId(residentAndParkingSpaceIds.getUserResident().getId());
                    int update = cpmParkingSpaceDao.update(cpmParkingSpace);
                    if (update <= 0){
                        throw new RuntimeException("修改业主关联车位信息失败");
                    }
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

        map.put("message","修改业主关联车位信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoFindAll> findResidentAll() {
        return userResidentDao.findResidentAll();
    }

    @Override
    public List<VoFindAll> findAll() {
        return userResidentDao.findAll();
    }


}
