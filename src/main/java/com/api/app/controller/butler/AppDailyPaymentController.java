package com.api.app.controller.butler;

import com.api.app.service.butler.AppDailyPaymentService;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.vo.app.AppDailyPaymentVo;
import com.api.vo.app.AppPaymentRecordVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app生活缴费信息
 */
@RestController
@RequestMapping("app/user/dailyPayment")
public class AppDailyPaymentController {
    @Resource
    AppDailyPaymentService appDailyPaymentService;

    /**
     * 查询生活缴费信息list
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param estateId 用户房产id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer estateId){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,size);
        List<AppDailyPaymentVo> appDailyPaymentVos =appDailyPaymentService.list(estateId);
        PageInfo<AppDailyPaymentVo> pageInfo = new PageInfo<>(appDailyPaymentVos);
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * app 生活缴费 缴费（该接口已舍弃，转支付宝支付）
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/pay")
    public Map<String,Object> pay(@RequestBody AppDailyPaymentOrder appDailyPaymentOrder, HttpServletRequest request){
        //从request获取用户姓名
        String name = request.getParameter("name");
        //从request获取用户联系电话
        String tel = request.getParameter("tel");
        appDailyPaymentOrder.setName(name);
        appDailyPaymentOrder.setTel(tel);
        return appDailyPaymentService.pay(appDailyPaymentOrder);
    }

    /**
     * 查询当前用户的房屋是否缴费
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/findEstateIsPayment")
    public Map<String,Object> findEstateIsPayment(Integer id){
        return appDailyPaymentService.findEstateIsPayment(id);
    }


    /**
     * 缴费记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/paymentRecord")
    public Map<String,Object> paymentRecord(int pageNum,int size,Integer id){
        //根据住户id查询房产id集合
        List<Integer> estateIds = appDailyPaymentService.findEstateIdByResidentId(id);
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,size);
        List<AppPaymentRecordVo> appPaymentRecordVos = appDailyPaymentService.paymentRecord(estateIds);
        PageInfo<AppPaymentRecordVo> pageInfo = new PageInfo<>(appPaymentRecordVos);
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据房产id查询对应的预付款充值金额
     * @param estateId 房产id
     * @return map
     */
    @GetMapping("/findAdvancePaymentPriceByEstateId")
    public Map<String,Object> findAdvancePaymentPriceByEstateId(Integer estateId){
        return appDailyPaymentService.findAdvancePaymentPriceByEstateId(estateId);
    }



}
