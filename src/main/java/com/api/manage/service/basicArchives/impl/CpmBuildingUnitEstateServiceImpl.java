package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.CpmBuildingUnitDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.model.basicArchives.*;
import com.api.model.businessManagement.SysUser;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.vo.basicArchives.VoFindAll;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<VoCpmBuildingUnitEstate> list(SearchCpmBuildingUnitEstate searchCpmBuildingUnitEstate) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchCpmBuildingUnitEstate.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchCpmBuildingUnitEstate.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchCpmBuildingUnitEstate.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchCpmBuildingUnitEstate.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchCpmBuildingUnitEstate.setRoomNumber(split[2]);
            }
        }

        return cpmBuildingUnitEstateDao.list(searchCpmBuildingUnitEstate);
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
            map.put("message","房间名称已存在");
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
            map.put("message","房屋名称已存在");
            map.put("status",false);
            return map;
        }

        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);


        //添加楼宇单元房产信息
        int insert1 = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert1>0){
            try {
                //判断是否有业主信息需要添加
                if (userResidentList!=null){
                    //添加业主信息
                    insertUserResident(new EstateAndResidentList(cpmBuildingUnitEstate,userResidentList));
                }else {
                    throw new RuntimeException("请设置房屋状态为未售或填入业主信息");
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
            userResident.setType(1);
            //添加业主房产关联数据
            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
            cpmResidentEstate.setBuildingUnitEstateId(estateAndResidentList.getEstate().getId());
            //根据业主手机号和证件号码查询是否已有业主信息
            UserResident userResident1 = userResidentDao.findByTelAndIdNumber(userResident);
            //判断是否有该业主信息
            if (userResident1 != null){
                //有则直接关联业主房产信息
                //查询是否存在此关联
                CpmResidentEstate cpmBuildingUnitEstate = userResidentDao.findByEstateIdAndResidentId(new ResidentIdAndEstateId(userResident1.getId(),estateAndResidentList.getEstate().getId()));
                if (cpmBuildingUnitEstate != null){
                    throw new RuntimeException("填入业主信息重复");
                }else {
                    //添加业主id
                    cpmResidentEstate.setResidentId(userResident1.getId());
                    int insert2 = userResidentDao.insertResidentEstate(cpmResidentEstate);
                    if (insert2>0){
                        map.put("message","添加楼栋单元房产信息成功,已关联成功业主信息");
                        map.put("status",true);
                    }else {
                        throw new RuntimeException("添加业主房产关联表失败");
                    }
                }
            }else {
                //没有则添加该业主信息
                //校验重复
                //根据业主手机号查询是否已有业主信息
                UserResident userResident3 = userResidentDao.findByTel(userResident.getTel());
                if (userResident3 != null){
                    throw new RuntimeException("业主手机号已存在或重复");
                }

                //根据业主证件号码查询是否已有业主信息
                UserResident userResident2 = userResidentDao.findByIdNumber(userResident.getIdNumber());
                if (userResident2 != null){
                    throw new RuntimeException("业主证件号码已存在或重复");
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
        CpmBuildingUnitEstate byId = cpmBuildingUnitEstateDao.findById(id);
        if (byId != null){
            //根据楼栋单元id查询楼栋单元信息
            CpmBuildingUnit byId1 = cpmBuildingUnitDao.findById(byId.getBuildingUnitId());
            //填入楼栋id
            byId.setBuildingId(byId1.getBuildingId());
        }
        return byId;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        //捕获异常，用于回滚
        try {
            for (int id : ids) {
                //先查询是否有关联业主信息
                List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(id);
                if (byBuildingUnitEstateId != null && byBuildingUnitEstateId.size()>0){
                    throw new RuntimeException("批量删除失败，请先解除关联业主信息");
                }

                //再假删除房产信息
                int delete = cpmBuildingUnitEstateDao.delete(id);
                if (delete<=0){
                    //如果，delete为0抛出异常
                    throw new RuntimeException("批量删除楼栋单元房产信息失败");
                }
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
        map.put("message","批量删除楼栋单元房产信息成功");
        map.put("status",true);
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

        try {
            //修改房屋信息
            int update = cpmBuildingUnitEstateDao.update(estateAndResident.getEstate());
            if (update <= 0){
                throw new RuntimeException("修改房屋信息失败");
            }

            //---修改关联业主信息---
            try {
                //根据楼栋单元房产Id查询楼栋单元房产信息
                List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(estateAndResident.getEstate().getId());
                if (byBuildingUnitEstateId != null){
                    for (UserResident userResident : byBuildingUnitEstateId) {
                        //先删除所有该房产的业主关联信息
                        int delete = userResidentDao.deleteByResidentIdAndEstateId(new ResidentIdAndEstateId(userResident.getId(), estateAndResident.getEstate().getId()));
                        if (delete<=0){
                            throw new RuntimeException("存在业主房产关联信息删除失败");
                        }
                    }
                }
                //再添加业主关联信息
                if (estateAndResident.getResidentList()!=null){
                    //添加业主信息
                    insertUserResident(estateAndResident);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("修改关联业主信息失败");
            }

//        //最后查询出没有房产的业主,改为非小区人员
//        if (byBuildingUnitEstateId != null){
//            for (UserResident userResident : byBuildingUnitEstateId) {
//                List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(userResident.getId());
//                if (byResidentId == null || byResidentId.size()==0){
//                    //业主类型改为非小区人员
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




        map.put("message","修改房产信息成功");
        map.put("status",true);
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

    @Override
    public List<VoFindAll> findByBuildingId(Integer buildingId) {
        return cpmBuildingUnitEstateDao.findByBuildingId(buildingId);
    }
}
