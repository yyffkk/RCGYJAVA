package com.api.manage.controller.chargeManagement;


import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.manage.service.chargeManagement.SysExpenseBillService;
import com.api.model.chargeManagement.SearchExpenseBill;
import com.api.model.chargeManagement.SearchExpenseBillDetail;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoExpenseBillDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 费用账单（账单管理）
 */
@RestController
@RequestMapping("manage/expenseBill")
public class SysExpenseBillController   {
    @Resource
    SysExpenseBillService sysExpenseBillService;

    /**
     * 查询所有的费用账单信息 （包含条件搜索）
     * @param searchExpenseBill 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public Map<String,Object> list(SearchExpenseBill searchExpenseBill){
        PageHelper.startPage(searchExpenseBill.getPageNum(),searchExpenseBill.getSize());
        List<VoExpenseBill> voExpenseBillList = sysExpenseBillService.list(searchExpenseBill);
        PageInfo<VoExpenseBill> pageInfo = new PageInfo<>(voExpenseBillList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询费用账单的所有详情信息
     * @param searchExpenseBillDetail 费用账单详情搜索条件
     * @return map
     */
    @GetMapping("/detailList")
    public Map<String,Object> detailList(SearchExpenseBillDetail searchExpenseBillDetail){
        PageHelper.startPage(searchExpenseBillDetail.getPageNum(),searchExpenseBillDetail.getSize());
        List<VoExpenseBillDetail> voDailyPaymentList = sysExpenseBillService.detailList(searchExpenseBillDetail);
        PageInfo<VoExpenseBillDetail> pageInfo = new PageInfo<>(voDailyPaymentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 导出费用账单报表（导出EXCEL）
     * @param request request请求
     * @param response response请求
     * @param searchExpenseBill 费用账单搜索条件
     */
    @GetMapping("/export")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public void export(HttpServletRequest request, HttpServletResponse response, SearchExpenseBill searchExpenseBill){
        //查询导出数据
        PageHelper.startPage(searchExpenseBill.getPageNum(),searchExpenseBill.getSize());
        List<VoExpenseBill> voExpenseBillList = sysExpenseBillService.list(searchExpenseBill);
        PageInfo<VoExpenseBill> pageInfo = new PageInfo<>(voExpenseBillList);
        //导出excel
        sysExpenseBillService.export(request,response,pageInfo.getList());
    }


    /**
     * 费用账单退款接口
     * @return map
     */
    @RequiresPermissions(value = {"0408","04"},logical = Logical.AND)
    public Map<String,Object> refund(){
        return null;
    }


}
