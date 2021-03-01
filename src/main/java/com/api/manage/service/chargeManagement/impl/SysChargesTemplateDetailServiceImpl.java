package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysChargesTemplateDetailDao;
import com.api.model.chargeManagement.SearchChargesTemplateDetail;
import com.api.model.chargeManagement.SysChargesTemplateAdditionalCost;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.chargeManagement.SysChargesTemplateDetailService;
import com.api.util.ExcelUtil;
import com.api.vo.chargeManagement.VoChargesTemplateAdditionalCost;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SysChargesTemplateDetailServiceImpl implements SysChargesTemplateDetailService {
    private static Map<String,Object> map = null;
    @Resource
    SysChargesTemplateDetailDao sysChargesTemplateDetailDao;

    @Override
    public List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail) {
        List<VoChargesTemplateDetail> list = sysChargesTemplateDetailDao.list(searchChargesTemplateDetail);
        if (list != null && list.size() >0){
            for (VoChargesTemplateDetail templateDetail : list) {
                List<VoChargesTemplateAdditionalCost> additionalCostList = sysChargesTemplateDetailDao.findAdditionalCostById(templateDetail.getId());
                templateDetail.setAdditionalCostList(additionalCostList);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysChargesTemplateDetail sysChargesTemplateDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            sysChargesTemplateDetail.setCreateId(sysUser.getId());
            //填入创建时间
            sysChargesTemplateDetail.setCreateDate(new Date());
            //新添加的默认为未启用
            sysChargesTemplateDetail.setStatus(0);
            //添加物业收费标准明细信息
            int insert = sysChargesTemplateDetailDao.insert(sysChargesTemplateDetail);
            if (insert <= 0) {
                throw new RuntimeException("添加物业收费标准明细信息失败");
            }
            if (sysChargesTemplateDetail.getAdditionalCostList() != null && sysChargesTemplateDetail.getAdditionalCostList().size()>0){
                for (SysChargesTemplateAdditionalCost additionalCost : sysChargesTemplateDetail.getAdditionalCostList()) {
                    additionalCost.setChargesTemplateDetailId(sysChargesTemplateDetail.getId());
                    //添加物业收费标准附加费用
                    int insert2 = sysChargesTemplateDetailDao.insertAdditionCost(additionalCost);
                    if (insert2 <= 0) {
                        throw new RuntimeException("添加物业收费标准附加费用失败");
                    }
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
        map.put("message","添加物业收费标准明细信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String,Object> findById(Integer id) {
        map = new HashMap<>();
        VoFindByIdChargesTemplateDetail byId = sysChargesTemplateDetailDao.findById(id);
        if (byId != null){
            List<VoChargesTemplateAdditionalCost> additionalCostById = sysChargesTemplateDetailDao.findAdditionalCostById(byId.getId());
            byId.setAdditionalCostList(additionalCostById);
        }
        map.put("byId",byId);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysChargesTemplateDetail sysChargesTemplateDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入修改人
            sysChargesTemplateDetail.setModifyId(sysUser.getId());
            //填入修改日期
            sysChargesTemplateDetail.setModifyDate(new Date());
            //更新物业收费标准明细信息
            int update = sysChargesTemplateDetailDao.update(sysChargesTemplateDetail);
            if (update <= 0){
                throw new RuntimeException("更新物业收费标准明细信息失败");
            }

            //更新物业收费标准附加费用
            //先根据物业收费标准明细主键id,删除收费标准附加费用
            sysChargesTemplateDetailDao.deleteAdditionalCost(sysChargesTemplateDetail.getId());
            //再添加收费标准附加费用
            List<SysChargesTemplateAdditionalCost> additionalCostList = sysChargesTemplateDetail.getAdditionalCostList();
            if (additionalCostList != null && additionalCostList.size()>0){
                for (SysChargesTemplateAdditionalCost additionalCost : additionalCostList) {
                    additionalCost.setChargesTemplateDetailId(sysChargesTemplateDetail.getId());
                    //再添加收费标准附加费用
                    int insert = sysChargesTemplateDetailDao.insertAdditionCost(additionalCost);
                    if (insert <= 0){
                        throw new RuntimeException("更新物业收费标准附加费用失败");
                    }
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
        map.put("message","更新物业收费标准明细信息成功");
        map.put("stats",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据物业收费标准明细主键id查询状态
                int status = sysChargesTemplateDetailDao.findStatusByChargesTemplateDetailId(id);
                //如果已启用则无法删除
                if (status == 1){
                    throw new RuntimeException("该费用已启用,无法删除");
                }
                ArrayList<Integer> chargesTemplateDetailIds = new ArrayList<>();
                chargesTemplateDetailIds.add(id);
                //查询日常缴费是否存在关联收费标准明细
                int count1 = sysChargesTemplateDetailDao.findDailyPaymentIsRelation(chargesTemplateDetailIds);
                if (count1 > 0){
                    throw new RuntimeException("已关联日常缴费信息,删除失败");
                }
                //查询押金管理是否存在关联收费标准明细
                int count2 = sysChargesTemplateDetailDao.findDepositManagementIsRelation(chargesTemplateDetailIds);
                if (count2 >0){
                    throw new RuntimeException("已关联押金管理信息,删除失败");
                }
                //根据物业收费标准明细主键id,删除收费标准附加费用
                sysChargesTemplateDetailDao.deleteAdditionalCost(id);
                //根据物业收费标准明细主键id 删除物业收费标准明细信息
                int delete = sysChargesTemplateDetailDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除物业收费标准明细信息失败");
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
        map.put("message","删除物业收费标准明细信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response,Integer chargesTemplateId) {
        //获取数据
        SearchChargesTemplateDetail searchChargesTemplateDetail = new SearchChargesTemplateDetail();
        searchChargesTemplateDetail.setChargesTemplateId(chargesTemplateId);
        List<VoChargesTemplateDetail> voChargesTemplateDetailList = sysChargesTemplateDetailDao.list(searchChargesTemplateDetail);

        //excel标题
        String[] title = {"序号","费用名称","计费单价/单位","附加/固定费用","状态","创建人","更新时间"};

        //excel文件名
        String fileName = "收费标准管理表"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "收费标准管理表";


        //初始化内容容器1
        String[][] content = new String[voChargesTemplateDetailList.size()][];
        for (int i = 0; i < voChargesTemplateDetailList.size(); i++) {
            //初始化内容容器2
            content[i] = new String[title.length];
            //获取 当前物业收费标准明细Vo
            VoChargesTemplateDetail voChargesTemplateDetail = voChargesTemplateDetailList.get(i);
            //传入序号
            content[i][0] = String.valueOf(i+1);
            //传入费用名称
            content[i][1] = voChargesTemplateDetail.getName();

            //传入计费单价/单位
            //查询计费单位显示名称
            String typeShowName = sysChargesTemplateDetailDao.findTypeShowNameByShowValue(voChargesTemplateDetail.getType());
            content[i][2] = voChargesTemplateDetail.getUnitPrice().toString()+typeShowName;

            //传入附加/固定费用
            List<VoChargesTemplateAdditionalCost> additionalCostList = sysChargesTemplateDetailDao.findAdditionalCostById(voChargesTemplateDetail.getId());
            if (additionalCostList != null && additionalCostList.size()>0){
                content[i][3] = "";
                for (VoChargesTemplateAdditionalCost additionalCost : additionalCostList) {
                    content[i][3] += additionalCost.getName()+":"+additionalCost.getCost()+"/r/n";
                }
            }else {
                content[i][3] = "/";
            }
            //传入状态
            //查询状态显示名称
            String statusShowName = sysChargesTemplateDetailDao.findStatusShowNameByShowValue(voChargesTemplateDetail.getStatus());
            content[i][4] = statusShowName;
            //传入创建人
            content[i][5] = voChargesTemplateDetail.getCreateName();
            //传入更新时间
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String format = formatter.format(voChargesTemplateDetail.getModifyDate());
            content[i][6] = format;
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        //根据物业收费标准明细主键id查询物业收费标准明细信息（1.启用，0.未启用）
        VoFindByIdChargesTemplateDetail byId = sysChargesTemplateDetailDao.findById(id);
        try {
            if (byId.getStatus() == 1){
                //禁用
                //判断是否为报事报修（唯一）和装修押金（唯一），如果是则无法禁用
                if (byId.getMarker() == 2 || byId.getMarker() == 3){
                    throw new RuntimeException("该费用类型无法禁用，请先启用其他相同类型的费用");
                }
                int update = sysChargesTemplateDetailDao.disable(id);
                if (update <= 0){
                    throw new RuntimeException("禁用收费标准明细失败");
                }
            }else {
                //启用
                //判断是否为报事报修（唯一）和装修押金（唯一），如果是则先禁用同一个模版的其他的相同类型的物业收费标准模版
                if (byId.getMarker() == 2 || byId.getMarker() == 3){
                    //先禁用同一个模版的其他的相同类型的物业收费标准模版
                    sysChargesTemplateDetailDao.disableAll(byId);
                }
                //根据物业收费标准明细主键id启用物业收费标准模版
                int update2 = sysChargesTemplateDetailDao.enable(id);
                if (update2 <= 0){
                    throw new RuntimeException("启用收费标准明细失败");
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
        if (byId.getStatus() == 1){
            map.put("message","禁用收费标准明细成功");
        }else {
            map.put("message","启用收费标准明细成功");
        }
        map.put("status",true);
        return map;
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
