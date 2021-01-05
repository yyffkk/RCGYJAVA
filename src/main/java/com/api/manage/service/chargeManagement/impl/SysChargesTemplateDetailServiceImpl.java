package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysChargesTemplateDetailDao;
import com.api.model.chargeManagement.SearchChargesTemplateDetail;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.model.system.SysUser;
import com.api.manage.service.chargeManagement.SysChargesTemplateDetailService;
import com.api.util.ExcelUtil;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysChargesTemplateDetailServiceImpl implements SysChargesTemplateDetailService {
    private static Map<String,Object> map = null;
    @Resource
    SysChargesTemplateDetailDao sysChargesTemplateDetailDao;

    @Override
    public List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail) {
        return sysChargesTemplateDetailDao.list(searchChargesTemplateDetail);
    }

    @Override
    public Map<String, Object> insert(SysChargesTemplateDetail sysChargesTemplateDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        sysChargesTemplateDetail.setCreateId(sysUser.getId());
        //填入创建时间
        sysChargesTemplateDetail.setCreateDate(new Date());
        //添加标记符 1.日常缴费
        sysChargesTemplateDetail.setMarker(1);
        //添加物业收费标准明细信息
        int insert = sysChargesTemplateDetailDao.insert(sysChargesTemplateDetail);
        if (insert >0) {
            map.put("message","添加物业收费标准明细信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加物业收费标准明细信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdChargesTemplateDetail findById(Integer id) {
        return sysChargesTemplateDetailDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysChargesTemplateDetail sysChargesTemplateDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        sysChargesTemplateDetail.setModifyId(sysUser.getId());
        //填入修改日期
        sysChargesTemplateDetail.setModifyDate(new Date());
        //更新物业收费标准明细信息
        int update = sysChargesTemplateDetailDao.update(sysChargesTemplateDetail);
        if (update >0){
            map.put("message","更新物业收费标准明细信息成功");
            map.put("stats",true);
        }else {
            map.put("message","更新物业收费标准明细信息失败");
            map.put("stats",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length>0){
                for (int id : ids) {
                    //根据物业收费标准明细主键id 删除物业收费标准明细信息
                    int delete = sysChargesTemplateDetailDao.delete(id);
                    if (delete <= 0){
                        throw new RuntimeException("删除物业收费标准明细信息失败");
                    }
                }
            }else {
                throw new RuntimeException("请选择至少一项");
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
            if (voChargesTemplateDetail.getOtherFee() != null){
                content[i][3] = voChargesTemplateDetail.getOtherFee().toString();
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