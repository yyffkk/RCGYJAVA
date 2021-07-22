package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerFacilitiesCheckDao;
import com.api.butlerApp.service.jurisdiction.ButlerFacilitiesCheckService;
import com.api.manage.dao.butlerService.SysFacilitiesPlanDao;
import com.api.manage.dao.message.ManageSysMessageDao;
import com.api.model.businessManagement.SysOrganization;
import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.message.ManageSysMessage;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerFacilitiesCheckServiceImpl implements ButlerFacilitiesCheckService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerFacilitiesCheckDao butlerFacilitiesCheckDao;
    @Resource
    SysFacilitiesPlanDao sysFacilitiesPlanDao;
    @Resource
    ManageSysMessageDao manageSysMessageDao;

    @Override
    public List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch) {
        List<ButlerFacilitiesCheckVo> list = butlerFacilitiesCheckDao.list(butlerFacilitiesCheckSearch);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (ButlerFacilitiesCheckVo butlerFacilitiesCheckVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysFacilitiesExecute", butlerFacilitiesCheckVo.getId(), "checkImg");
                butlerFacilitiesCheckVo.setImgList(imgByDate);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> submitCheck(FacilitiesExecute facilitiesExecute, Integer id, String name, Integer organizationId) {
        map = new HashMap<>();
        try {
            //根据设施设备检查记录主键id查询设施设备检查记录信息
            FacilitiesExecute facilitiesExecute2 = butlerFacilitiesCheckDao.findById(facilitiesExecute.getId());
            if (facilitiesExecute2.getStatus() != 1){//1.待完成
                throw new RuntimeException("该状态不可提交报告");
            }

            if (new Date().getTime() < facilitiesExecute2.getBeginDate().getTime()){
                throw new RuntimeException("该检查还未开始");
            }

            if (new Date().getTime() > facilitiesExecute2.getEndDate().getTime()){
                throw new RuntimeException("该检查已超时");
            }

            facilitiesExecute.setStatus(2);//2.已完成
            facilitiesExecute.setCheckDate(new Date());//填入检查时间

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(facilitiesExecute.getImgUrls(),"sysFacilitiesExecute", facilitiesExecute.getId(), "checkImg","600",30,20);

            int update = butlerFacilitiesCheckDao.submitCheck(facilitiesExecute);
            if (update <= 0){
                throw new RuntimeException("提交失败");
            }


            //根据设施设备检查记录主键id查询设施/设备管理计划信息
            FacilitiesPlan facilitiesPlan = butlerFacilitiesCheckDao.findPlanById(facilitiesExecute.getId());

            //根据组织id查询组织信息
            SysOrganization sysOrganization = manageSysMessageDao.findOrganizationByOrganizationId(organizationId);

            //添加后台消息列表
            ManageSysMessage manageSysMessage = new ManageSysMessage();
            manageSysMessage.setContent(sysOrganization.getName()+" "+name+" 提交了检查报告，请确认");
            manageSysMessage.setType(8);//8.设施/设备管理
            manageSysMessage.setRelationId(facilitiesExecute2.getId());//填入设施/设备管理主键id
            manageSysMessage.setReceiverAccountId(facilitiesPlan.getCreateId());//填入接收人
            manageSysMessage.setSenderId(id);//填入发送人id
            manageSysMessage.setSenderType(1);//1.管家
            manageSysMessage.setSendStatus(1);//1.发送成功（未读）
            manageSysMessage.setSendDate(new Date());
            int insert4 = manageSysMessageDao.insert(manageSysMessage);
            if (insert4 <= 0){
                throw new RuntimeException("后台消息列表发送失败");
            }

            //添加下一条检查记录
            //根据检查计划主键id 查询 检查计划情况
            FacilitiesPlan plan = sysFacilitiesPlanDao.findById(facilitiesExecute2.getFacilitiesPlanId());
            if (plan != null && plan.getStatus() ==1){//未被删除，并启用
                //添加下一条检查计划
                FacilitiesExecute execute3 = new FacilitiesExecute();
                execute3.setFacilitiesPlanId(facilitiesExecute2.getFacilitiesPlanId());//填入检查计划主键id
                execute3.setStatus(1);//添加默认，1.待完成
                Date time = facilitiesExecute2.getBeginDate();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(time);
                switch (plan.getCheckRateType()){
                    case 1:
                        calendar.add(Calendar.DAY_OF_MONTH,1);
                        break;
                    case 2:
                        calendar.add(Calendar.DAY_OF_MONTH,7);
                        break;
                    case 3:
                        calendar.add(Calendar.MONTH,1);
                        break;
                    default:
                        throw new RuntimeException("数据异常,巡检执行情况主键id:"+facilitiesExecute2.getId());
                }
                time = calendar.getTime();
                execute3.setBeginDate(time); //填入计划当次检查开始时间

                calendar.setTime(time);
                calendar.add(Calendar.MINUTE,plan.getSpaceTime());
                Date time2 = calendar.getTime();
                execute3.setEndDate(time2); //填入计划当次检查结束时间

                //根据检查计划主键id查询检查执行数量
                int count2 = sysFacilitiesPlanDao.countExecuteNumByPlanId(facilitiesExecute2.getFacilitiesPlanId());
                execute3.setSort(count2+1); //填入排序默认为1
                int insert2 = sysFacilitiesPlanDao.insertExecute(execute3);
                if (insert2 <=0){
                    throw new RuntimeException ("添加执行检查信息失败,检查执行情况主键id:"+execute3.getId());
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

        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }
}
