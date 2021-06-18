package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysPaperDao;
import com.api.manage.service.chargeManagement.SysPaperService;
import com.api.model.businessManagement.SysUser;
import com.api.model.chargeManagement.SearchPaper;
import com.api.model.chargeManagement.SysPaper;
import com.api.vo.chargeManagement.SysPaperVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysPaperServiceImpl implements SysPaperService {
    private static Map<String,Object> map = null;
    @Resource
    SysPaperDao sysPaperDao;

    @Override
    public List<SysPaperVo> list(SearchPaper searchPaper) {
        return sysPaperDao.list(searchPaper);
    }

    @Override
    public Map<String, Object> insert(SysPaper sysPaper) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysPaper.setCreateId(sysUser.getId());
        sysPaper.setCreateDate(new Date());
        sysPaper.setStatus(1);//默认填入1.未领用
        int insert = 0;
        if (sysPaper.getInvoiceTitleType() == 1){//1.企业单位
            insert = sysPaperDao.insertEnterprise(sysPaper);
        }else if (sysPaper.getInvoiceTitleType() == 2){//2.个人
            insert = sysPaperDao.insertPersonal(sysPaper);
        }else {
            map.put("message","抬头类型有误");
            map.put("status",false);
        }

        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> recipients(SysPaper sysPaper) {
        map = new HashMap<>();
        //根据票据主键id查询票据信息
        SysPaperVo sysPaperVo = sysPaperDao.findById(sysPaper.getId());
        if (sysPaperVo.getStatus() ==2){//2.已领用
            map.put("message","开票编号为:"+sysPaperVo.getCode()+"的票据已被领用");
            map.put("status",false);
            return map;
        }

        sysPaper.setRecipientsDate(new Date());
        sysPaper.setStatus(2);//2.已领用
        int update = sysPaperDao.recipients(sysPaper);
        if (update >0){
            map.put("message","领用成功");
            map.put("status",true);
        }else {
            map.put("message","领用失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据票据主键id查询票据信息
                SysPaperVo sysPaperVo = sysPaperDao.findById(id);
                if (sysPaperVo.getStatus() ==2){//2.已领用
                    throw new RuntimeException("开票编号为:"+sysPaperVo.getCode()+"的票据已被领用");
                }

                //根据票据主键id删除票据信息
                int delete = sysPaperDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除票据失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
