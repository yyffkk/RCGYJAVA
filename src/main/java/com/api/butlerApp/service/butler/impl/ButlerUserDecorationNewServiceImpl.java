package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerUserDecorationNewDao;
import com.api.butlerApp.service.butler.ButlerUserDecorationNewService;
import com.api.model.app.AppUserDecorationNew;
import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.model.butlerApp.ButlerUserDecorationNewCheck;
import com.api.vo.butlerApp.ButlerUserDecorationNewCheckVo;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerUserDecorationNewServiceImpl implements ButlerUserDecorationNewService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerUserDecorationNewDao butlerUserDecorationNewDao;

    @Override
    public List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch) {
        List<ButlerUserDecorationNewVo> list = butlerUserDecorationNewDao.list(butlerUserDecorationNewSearch);
        if (list != null && list.size()>0){
            for (ButlerUserDecorationNewVo butlerUserDecorationNewVo : list) {
                //根据新版装修主键id 查询 完工检查记录
                List<ButlerUserDecorationNewCheckVo> checkVoList = butlerUserDecorationNewDao.findCheckDetailById(butlerUserDecorationNewVo.getId());
                butlerUserDecorationNewVo.setCheckVoList(checkVoList);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> submitReport(ButlerUserDecorationNewCheck butlerUserDecorationNewCheck, Integer id) {
        map = new HashMap<>();

        try {
            int status = butlerUserDecorationNewDao.findStatusById(butlerUserDecorationNewCheck.getDecorationNewId());
            if (status != 6){
                throw new RuntimeException("该状态不可提交检查");
            }

            butlerUserDecorationNewCheck.setCreateId(id);
            butlerUserDecorationNewCheck.setCreateDate(new Date());

            //添加检查记录
            int insert = butlerUserDecorationNewDao.submitReport(butlerUserDecorationNewCheck);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }

            AppUserDecorationNew appUserDecorationNew = new AppUserDecorationNew();
            appUserDecorationNew.setId(butlerUserDecorationNewCheck.getDecorationNewId());//填入主键id
            appUserDecorationNew.setIsQualified(butlerUserDecorationNewCheck.getIsQualified());//填入最后一次完工检查是否合格，1.合格,0.不合格

            //如果合格则填入装修实际结束时间
            if (butlerUserDecorationNewCheck.getIsQualified() == 1){//1.合格
                appUserDecorationNew.setActualEnd(new Date());
                appUserDecorationNew.setStatus(7);//检查通过
            }else if (butlerUserDecorationNewCheck.getIsQualified() == 0){//0.不合格
                appUserDecorationNew.setActualEnd(null);
                appUserDecorationNew.setStatus(8);//检查不通过
            }else {
                throw new RuntimeException("填入数据有误");
            }

            //修改检查状态和最后一次完工检查是否合格（1.合格，0.不合格）及装修实际结束时间
            int update = butlerUserDecorationNewDao.updateLastCheckInfo(appUserDecorationNew);
            if (update <= 0){
                throw new RuntimeException("修改最后一次完工检查信息失败");
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
