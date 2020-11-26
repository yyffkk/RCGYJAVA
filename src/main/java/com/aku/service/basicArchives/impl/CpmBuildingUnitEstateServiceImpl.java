package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.*;
import com.aku.model.system.SysUser;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.service.basicArchives.CpmBuildingUnitEstateService;
import com.aku.vo.basicArchives.VoFindAll;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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

        //校验重复
        //根据楼栋单元房产房间号查询是否已有房产信息
        CpmBuildingUnitEstate cpmBuildingUnitEstate1 = cpmBuildingUnitEstateDao.findByRoomNumber(cpmBuildingUnitEstate.getRoomNumber());
        if (cpmBuildingUnitEstate1 != null){
            map.put("message","房间号已存在");
            map.put("status",false);
            return map;
        }

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
    public Map<String, Object> insert(List<UserResident> userResidentList, CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //校验重复
        //根据楼栋单元房产房间号查询是否已有房产信息
        CpmBuildingUnitEstate cpmBuildingUnitEstate1 = cpmBuildingUnitEstateDao.findByRoomNumber(cpmBuildingUnitEstate.getRoomNumber());
        if (cpmBuildingUnitEstate1 != null){
            map.put("message","房间号已存在");
            map.put("status",false);
            return map;
        }

        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        //添加楼宇单元房产信息
        int insert1 = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert1>0){
            //判断是否有业主信息需要添加
            if (userResidentList!=null){
                //添加业主信息
                insertUserResident(new EstateAndResidentList(cpmBuildingUnitEstate,userResidentList));
            }
        }else {
            map.put("message","添加楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    //添加业主信息
    private void insertUserResident(EstateAndResidentList estateAndResidentList) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        for (UserResident userResident : estateAndResidentList.getResidentList()) {
            //添加业主房产关联数据
            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
            cpmResidentEstate.setBuildingUnitEstateId(estateAndResidentList.getEstate().getId());
            //根据业主手机号和证件号码查询是否已有业主信息
            UserResident userResident1 = userResidentDao.findByTelAndIdNumber(userResident);
            //判断是否有该业主信息
            if (userResident1 != null){
                //有则直接关联业主房产信息
                //添加业主id
                cpmResidentEstate.setResidentId(userResident1.getId());
                int insert2 = userResidentDao.insertResidentEstate(cpmResidentEstate);
                if (insert2>0){
                    map.put("message","添加楼栋单元房产信息成功,已关联成功业主信息");
                    map.put("status",true);
                }else {
                    throw new RuntimeException("添加业主房产关联表失败");
                }
            }else {
                //没有则添加该业主信息
                //校验重复
                //根据业主手机号查询是否已有业主信息
                UserResident userResident3 = userResidentDao.findByTel(userResident.getTel());
                if (userResident3 != null){
                    throw new RuntimeException("业主手机号已存在");
                }

                //根据业主证件号码查询是否已有业主信息
                UserResident userResident2 = userResidentDao.findByIdNumber(userResident.getIdNumber());
                if (userResident2 != null){
                    throw new RuntimeException("业主证件号码已存在");
                }
                //添加业主数据
                userResident.setCreateId(sysUser.getId());
                userResident.setCreateDate(new Date());
                userResident.setType(RESIDENT_TYPE);
                //添加业主信息
                int insert = userResidentDao.insert(userResident);
                if (insert >0 ){
                    //再添加业主房产关联信息
                    cpmResidentEstate.setResidentId(userResident.getId());
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
            }
        }
    }

    @Override
    public CpmBuildingUnitEstate findById(Integer id) {
        return cpmBuildingUnitEstateDao.findById(id);
    }

    @Override
    public Map<String, Object> delete(Integer id) {

        //查询是否有关联业主信息
        List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(id);
        if (byBuildingUnitEstateId != null && byBuildingUnitEstateId.size()>0){
            map.put("message","删除失败，请先解除关联业主信息");
            map.put("status",false);
            return map;
        }
        //假删除房产信息
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

    @Override
    @Transactional
    public Map<String, Object> update(EstateAndResidentList estateAndResident) {

        //校验重复
        //根据楼栋单元房产房间号查询是否已有房产信息
        CpmBuildingUnitEstate cpmBuildingUnitEstate1 = cpmBuildingUnitEstateDao.findByRoomNumber(estateAndResident.getEstate().getRoomNumber());
        if (cpmBuildingUnitEstate1 != null){
            //如果输入id与查询到的id不一致，则修改了房间号信息，并且房间号重复
            if (!cpmBuildingUnitEstate1.getId().equals(estateAndResident.getEstate().getId())){
                map.put("message","房间号已存在");
                map.put("status",false);
                return map;
            }
        }

        boolean flag =true;
        //修改房屋信息
        int update = cpmBuildingUnitEstateDao.update(estateAndResident.getEstate());
        if (update <= 0){
            flag = false;
        }

        //---修改关联业主信息---
        //根据楼栋单元房产Id查询楼栋单元房产信息
        List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(estateAndResident.getEstate().getId());
        if (byBuildingUnitEstateId != null){
            for (UserResident userResident : byBuildingUnitEstateId) {
                //先删除所有该房产的业主关联信息
                int delete = userResidentDao.deleteByResidentIdAndEstateId(new ResidentIdAndEstateId(userResident.getId(), estateAndResident.getEstate().getId()));
                if (delete<=0){
                    flag = false;
                }
            }
        }
//        再添加业主关联信息
        if (estateAndResident.getResidentList()!=null){
            //添加业主信息
            insertUserResident(estateAndResident);
        }

//        //最后查询出没有房产的业主,改为旧业主
//        if (byBuildingUnitEstateId != null){
//            for (UserResident userResident : byBuildingUnitEstateId) {
//                List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(userResident.getId());
//                if (byResidentId == null || byResidentId.size()==0){
//                    //业主类型改为旧业主
//                    UserResident userResident1 = new UserResident();
//                    userResident1.setId(userResident.getId());
//                    userResident1.setType(4);
//                    int update1 = userResidentDao.update(userResident1);
//                    if (update1 <= 0){
//                        flag =false;
//                    }
//                }
//            }
//        }


        if (flag){
            map.put("message","修改房产信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改房产信息失败");
        }
        return map;
    }

    @Override
    public List<VoFindAll> findByBuildingUnitId(Integer id) {
        return cpmBuildingUnitEstateDao.findByBuildingUnitId(id);
    }



    @Override
    public Map<String, Object> importBuildingUnitEstate(MultipartFile file) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            //一共有多少sheet，然后遍历
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                //...
                //获取sheet中一共有多少行，遍历行（注意第一行是标题）
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//                Employee employee;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    //...
                    //获取每一行有多少单元格，遍历单元格
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//                    employee = new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        //...
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
