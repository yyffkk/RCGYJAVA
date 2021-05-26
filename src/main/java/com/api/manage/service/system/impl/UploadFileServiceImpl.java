package com.api.manage.service.system.impl;

import com.api.manage.dao.system.UploadFileDao;
import com.api.manage.service.system.UploadFileService;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.businessManagement.SysUser;
import com.api.util.ExcelReadUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    private static Map<String,Object> map = null;
    @Resource
    UploadFileDao uploadFileDao;

    @Override
    @Transactional
    public Map<String,Object> UploadEstateFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();

                cpmBuildingUnitEstate.setBuildingUnitId(Integer.valueOf(user.get("楼宇单元导入编号").toString()));
                cpmBuildingUnitEstate.setRoomNumber(user.get("房间号").toString());
                cpmBuildingUnitEstate.setStatus(Integer.valueOf(user.get("房间状态").toString()));
                cpmBuildingUnitEstate.setType(Integer.valueOf(user.get("房间类型").toString()));
                cpmBuildingUnitEstate.setConstructionArea(new BigDecimal(user.get("建筑面积").toString()));
                cpmBuildingUnitEstate.setIndoorArea(new BigDecimal(user.get("室内面积").toString()));
                cpmBuildingUnitEstate.setDeviceNumber(user.get("对讲机设备号").toString());
                cpmBuildingUnitEstate.setIsDelete(1);//默认1.非删

                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                cpmBuildingUnitEstate.setCreateId(sysUser.getId());
                cpmBuildingUnitEstate.setCreateDate(new Date());

                //查询是否存在该单元导入编号
                CpmBuildingUnit unit = uploadFileDao.findByUnitId(cpmBuildingUnitEstate.getBuildingUnitId());
                if (unit == null){
                    throw new RuntimeException("该单元不存在");
                }


                //添加楼栋信息
                int ret = uploadFileDao.insertEstate(cpmBuildingUnitEstate);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }
}
