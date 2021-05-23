package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesPlanDao;
import com.api.manage.service.butlerService.SysFacilitiesPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.butlerService.SearchFacilitiesPlan;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFacilitiesPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysFacilitiesPlanServiceImpl implements SysFacilitiesPlanService {
    private static Map<String,Object> map = null;
    @Resource
    SysFacilitiesPlanDao sysFacilitiesPlanDao;

    @Override
    public List<VoFacilitiesPlan> list(SearchFacilitiesPlan searchFacilitiesPlan) {
        return sysFacilitiesPlanDao.list(searchFacilitiesPlan);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(FacilitiesPlan facilitiesPlan) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //添加检查计划
            facilitiesPlan.setCreateId(sysUser.getId());
            facilitiesPlan.setCreateDate(new Date());
            facilitiesPlan.setStatus(1);//默认1.开启
            facilitiesPlan.setIsDelete(1);//默认1.非删
            facilitiesPlan.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));//填入计划编号

            int insert = sysFacilitiesPlanDao.insertPlan(facilitiesPlan);
            if (insert <=0){
                throw new RuntimeException("添加检查计划失败");
            }

            //添加检查执行情况
            FacilitiesExecute facilitiesExecute = new FacilitiesExecute();

            facilitiesExecute.setStatus(1);//默认，1.待完成
            facilitiesExecute.setBeginDate(facilitiesPlan.getPlanBeginDate()); //填入执行记录计划当次检查开始时间
            facilitiesExecute.setSort(1);//默认，新添加的排序为1
            facilitiesExecute.setFacilitiesPlanId(facilitiesPlan.getId());//填入设施/设备巡检计划主键id

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(facilitiesPlan.getPlanBeginDate());
            calendar.add(Calendar.MINUTE,facilitiesPlan.getSpaceTime());
            Date time = calendar.getTime();
            facilitiesExecute.setEndDate(time);//填入执行记录计划当次检查结束时间

            int insert2 = sysFacilitiesPlanDao.insertExecute(facilitiesExecute);
            if (insert2 <= 0){
                throw new RuntimeException("添加检查执行情况失败");
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

        map.put("message","添加检查计划成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysFacilitiesPlanDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除计划失败");
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
        map.put("message","删除计划成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> stop(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysFacilitiesPlanDao.stop(id);
                if (update <= 0){
                    throw new RuntimeException("停用计划失败");
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
        map.put("message","停用计划成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> open(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //判断是否需要添加检查执行情况信息
                //查询最新的一次的检查状态
                FacilitiesExecute execute = sysFacilitiesPlanDao.findNewPlan(id);

                //根据检查计划主键id 查询 检查计划情况(删除也能查到)
                FacilitiesPlan plan = sysFacilitiesPlanDao.findById2(id);
                if (plan == null){
                    throw new RuntimeException("该检查计划不存在");
                }

                if (execute.getStatus() != 1){
                    //当最新的一次的检查状态不为1.待完成，证明开启计划需要新添加一条执行记录
                    //添加下一条巡检计划
                    FacilitiesExecute execute2 = new FacilitiesExecute();
                    execute2.setFacilitiesPlanId(execute.getFacilitiesPlanId());//填入检查计划主键id
                    execute2.setStatus(1);//添加默认,1.待完成

                    Calendar calendar = Calendar.getInstance();
                    Date time = execute.getBeginDate();
                    while (time.getTime() < new Date().getTime()){ //获取离当前时间最近的检查计划开始时间，当检查计划开始时间大于等于当前时间，跳出当前循环
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
                                throw new RuntimeException("数据异常");
                        }
                        time = calendar.getTime();
                    }
                    execute2.setBeginDate(time); //填入计划当次检查开始时间

                    calendar.setTime(time);
                    calendar.add(Calendar.MINUTE,plan.getSpaceTime());
                    Date time2 = calendar.getTime();
                    execute2.setEndDate(time2); //填入计划当次检查结束时间

                    //根据检查计划主键id查询检查执行数量
                    int count2 = sysFacilitiesPlanDao.countExecuteNumByPlanId(execute.getFacilitiesPlanId());
                    execute2.setSort(count2+1); //填入排序默认为1

                    int insert2 = sysFacilitiesPlanDao.insertExecute(execute2);
                    if (insert2 <=0){
                        map.put("message","添加第一次执行检查信息失败");
                    }
                }

                int update = sysFacilitiesPlanDao.open(id);
                if (update <= 0){
                    throw new RuntimeException("开启计划失败");
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
        map.put("message","开启计划成功");
        map.put("status",true);
        return map;
    }
}
