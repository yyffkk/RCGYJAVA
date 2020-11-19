package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.CpmResidentEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.system.SysUser;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.service.basicArchives.CpmBuildingUnitEstateService;
import com.aku.vo.basicArchives.VoFindAll;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CpmBuildingUnitEstateServiceImpl implements CpmBuildingUnitEstateService {
    private final Map<String,Object> map = new HashMap<>();
    //设置业主类型，1业主
    private static final int RESIDENT_TYPE = 1;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    UserResidentDao userResidentDao;

    @Override
    public List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate) {
        return cpmBuildingUnitEstateDao.list(voCpmBuildingUnitEstate);
    }

    @Override
    public Map<String, Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        int insert = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert>0){
            map.put("message","添加楼栋单元房产信息成功，非关联业主");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋单元房产信息失败，非关联业主");
            map.put("status",false);
        }
        return map;

    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident, CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        //添加楼宇单元房产信息
        int insert1 = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert1>0){
            userResident.setCreateId(sysUser.getId());
            userResident.setCreateDate(new Date());
            userResident.setType(RESIDENT_TYPE);
            //添加业主信息
            int insert = userResidentDao.insert(userResident);
            if (insert >0 ){
                //添加业主房产关联数据
                CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                cpmResidentEstate.setResidentId(userResident.getId());
                cpmResidentEstate.setBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
                int insert2 = userResidentDao.insertResidentEstate(cpmResidentEstate);
                if (insert2>0){
                    map.put("message","添加楼栋单元房产信息成功,已关联添加成功业主信息");
                    map.put("status",true);
                }else {
                    throw new RuntimeException("添加业主房产关联表失败");
                }
            }else {
                throw new RuntimeException("添加业主信息失败");
            }
        }else {
            map.put("message","添加楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public CpmBuildingUnitEstate findById(Integer id) {
        return cpmBuildingUnitEstateDao.findById(id);
    }

    @Transactional
    @Override
    public Map<String, Object> updateOne(CpmBuildingUnitEstate cpmBuildingUnitEstate, UserResident userResident) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setModifyId(sysUser.getId());
        cpmBuildingUnitEstate.setModifyDate(new Date());

        //更新楼栋单元房产信息
        int update = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
        if (update >0){
            //添加关联业主信息
            userResident.setCreateId(sysUser.getId());
            userResident.setCreateDate(new Date());
//            userResident.setBuildingUnitEstateId(cpmBuildingUnitEstate.getId());

            int insert = userResidentDao.insert(userResident);
            if (insert>0){
                map.put("message","更新楼栋单元房产信息及添加关联业主成功");
                map.put("status",true);
            }else {
                throw new RuntimeException("更新楼栋单元房产信息成功，添加关联业主失败，回滚数据");
            }
        }else {
            map.put("message","更新楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateOne(CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setModifyId(sysUser.getId());
        cpmBuildingUnitEstate.setModifyDate(new Date());

        //更新楼栋单元房产信息
        int update = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
        if (update > 0){
            map.put("message","更新楼栋单元房产信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Transactional
    @Override
    public Map<String, Object> updateTwo(CpmBuildingUnitEstate cpmBuildingUnitEstate, UserResident userResident) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setModifyId(sysUser.getId());
        cpmBuildingUnitEstate.setModifyDate(new Date());

        //更新楼栋单元房产信息
        int update = cpmBuildingUnitEstateDao.update(cpmBuildingUnitEstate);
        if (update >0){
            //根据楼栋单元房产ID查询业主信息
            UserResident userResident1 = userResidentDao.findByBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
            if (userResident1 == null){
                throw new RuntimeException("更新楼栋单元房产信息成功，无业主信息，无法更新，数据错误，回滚数据");
            }
            //传入业主ID
            userResident.setId(userResident1.getId());

            //更新关联业主信息
            int update2 = userResidentDao.update(userResident);
            if (update2 > 0){
                map.put("message","更新楼栋单元房产信息及更新关联业主信息成功");
                map.put("status",true);
            }else {
                throw new RuntimeException("更新楼栋单元房产信息成功，更新关联业主信息失败，回滚数据");
            }
        }else {
            map.put("message","更新楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        int delete = cpmBuildingUnitEstateDao.delete(id);
        if (delete >0){
            map.put("message","删除楼栋单元房产信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoFindAll> findAll() {
        return cpmBuildingUnitEstateDao.findAll();
    }
}
