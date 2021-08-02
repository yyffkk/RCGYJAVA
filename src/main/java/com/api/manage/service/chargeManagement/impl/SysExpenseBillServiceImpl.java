package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysExpenseBillDao;
import com.api.manage.service.chargeManagement.SysExpenseBillService;
import com.api.model.chargeManagement.SearchExpenseBill;
import com.api.model.chargeManagement.SearchExpenseBillDetail;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoExpenseBillDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class SysExpenseBillServiceImpl implements SysExpenseBillService {
    @Resource
    SysExpenseBillDao sysExpenseBillDao;

    @Override
    public List<VoExpenseBill> list(SearchExpenseBill searchExpenseBill) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchExpenseBill.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchExpenseBill.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchExpenseBill.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchExpenseBill.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchExpenseBill.setRoomNumber(split[2]);
            }
        }
        List<VoExpenseBill> list = sysExpenseBillDao.list(searchExpenseBill);
        if (list != null && list.size() >0){
            for (VoExpenseBill voExpenseBill : list) {
                //根据房产主键id查询当前关联住户
                String associationResidentsName = sysExpenseBillDao.findAssociationResidentsByEstateId(voExpenseBill.getId());
                voExpenseBill.setAssociationResidentsName(associationResidentsName);
            }
        }
        return list;
    }

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, List<VoExpenseBill> voExpenseBillList) {
        //excel标题
        String[] title = {"序号","费用项目","交易号","房屋信息","缴费时间","计费开始时间","计费结束时间","费用金额","应收总计","状态","缴费人","缴费人联系方式","备注","创建人","更新时间"};

        //excel文件名
        String fileName = "费用账单"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "费用账单";


//        //初始化内容容器1
//        String[][] content = new String[voExpenseBillList.size()][];
//        for (int i = 0; i < voExpenseBillList.size(); i++) {
//            //初始化内容容器2
//            content[i] = new String[title.length];
//            //获取 当前物业收费标准明细Vo
//            VoExpenseBill voExpenseBill = voExpenseBillList.get(i);
//            //传入序号
//            content[i][0] = String.valueOf(i+1);
//            //传入费用项目
//            content[i][1] = voExpenseBill.getName();
//            //传入交易号
//            if (voExpenseBill.getOrderCode() != null){
//                content[i][2] = voExpenseBill.getOrderCode();
//            }else {
//                content[i][2] = "-";
//            }
//            //传入房屋信息
//            content[i][3] = voExpenseBill.getRoomName();
//            //传入缴费时间
//            if (voExpenseBill.getPayDate() != null){
//                content[i][4] = voExpenseBill.getPayDate();
//            }else {
//                content[i][4] = "-";
//            }
//            //传入计费开始时间
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
//            content[i][5] = formatter.format(voExpenseBill.getBeginDate());
//            //传入计费结束时间
//            content[i][6] = formatter.format(voExpenseBill.getEndDate());
//            //传入费用金额
//            content[i][7] = voExpenseBill.getCostPrice().toString();
//            //传入应收总计
//            content[i][8] = voExpenseBill.getTotalPrice().toString();
//            //传入状态
//            //查询状态显示名称
//            String statusShowName = sysExpenseBillDao.findStatusSNBySV(voExpenseBill.getStatus());
//            content[i][9] = statusShowName;
//            //传入缴费人
//            if (voExpenseBill.getPayName() != null){
//                content[i][10] = voExpenseBill.getPayName();
//            }else {
//                content[i][10] = "-";
//            }
//            //传入缴费人联系方式
//            if (voExpenseBill.getPayTel() != null){
//                content[i][11] = voExpenseBill.getPayTel();
//            }else {
//                content[i][11] = "-";
//            }
//            //备注
//            content[i][12] = voExpenseBill.getRemake();
//            //传入创建人
//            content[i][13] = voExpenseBill.getCreateName();
//            //传入更新时间
//            content[i][14] = formatter.format(voExpenseBill.getUpdateDate());
//        }
//
//        //创建HSSFWorkbook
//        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
//
//        //响应到客户端
//        try {
//            this.setResponseHeader(response, fileName);
//            OutputStream os = response.getOutputStream();
//            wb.write(os);
//            os.flush();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<VoExpenseBillDetail> detailList(SearchExpenseBillDetail searchExpenseBillDetail) {
        List<VoExpenseBillDetail> voExpenseBillDetails = sysExpenseBillDao.detailList(searchExpenseBillDetail);

        for (VoExpenseBillDetail voExpenseBillDetail : voExpenseBillDetails) {
            //查询缴费人名称
            String name = sysExpenseBillDao.findPayPeopleNameByBillId(voExpenseBillDetail.getId());
            voExpenseBillDetail.setPayPeopleName(name);
        }

        return voExpenseBillDetails;
    }


    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
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
