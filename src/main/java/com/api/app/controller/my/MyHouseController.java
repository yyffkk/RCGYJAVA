package com.api.app.controller.my;

import com.api.app.service.my.MyHouseService;
import com.api.model.alipay.SysLeaseRentOrder;
import com.api.model.app.AppLeaseSubmitAudit;
import com.api.model.app.AppLeaseValidContract;
import com.api.model.app.SearchAppLeaseRent;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SysLease;
import com.api.model.my.MyHouse;
import com.api.vo.app.AppLeaseRentVo;
import com.api.vo.app.AppLeaseVo;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的房屋
 */
@RestController
@RequestMapping("app/user/myHouse")
public class MyHouseController {
    @Resource
    MyHouseService myHouseService;



    /**
     * 查询用户所有拥有的房屋信息
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/houseList")
    public Map<String,Object> houseList(Integer id){
        return myHouseService.houseList(id);
    }


    /**
     * 查询所有的房屋审核信息
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/examineList")
    public Map<String,Object> examineList(Integer id){
        return myHouseService.examineList(id);
    }

    /**
     * 房屋认证(新增房屋)
     * @param myHouse 房产认证model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/authentication")
    public Map<String,Object> authentication(@RequestBody MyHouse myHouse, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户type
        Integer type = Integer.valueOf(request.getParameter("type"));
        //填入用户id
        myHouse.setResidentId(id);
        return myHouseService.authentication(myHouse,type);
    }


    /**
     * 再次认证回显数据
     * @param estateExamineId 房产审核表主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer estateExamineId){
        return myHouseService.findById(estateExamineId);
    }

    /**
     * 假删除审核信息
     * @param voIds 审核主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds voIds, HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        return myHouseService.falseDelete(voIds.getIds(),residentId);
    }


    /**
     * 修改选中的房产id
     * @param examineId 房产id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/changeSelectExamineId")
    public Map<String,Object> changeSelectExamineId(Integer examineId,Integer id){
        return myHouseService.changeSelectExamineId(examineId,id);
    }


    /**
     * 租赁认证
     * @param userResident 住户信息表
     * @return map
     */
    @PostMapping("/leaseCertification")
    public Map<String,Object> leaseCertification(@RequestBody UserResident userResident){
        return myHouseService.leaseCertification(userResident);
    }


    /**
     * 租赁认证信息回显
     * @param tel 用户的手机号
     * @return map
     */
    @GetMapping("/leaseEcho")
    public Map<String,Object> leaseEcho(String tel){
        return myHouseService.leaseEcho(tel);
    }

    /**
     * 查询所有的租赁信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param tel 用户手机号
     * @return map
     */
    @GetMapping("/leaseList")
    public Map<String,Object> leaseList(int pageNum,int size,String tel){
        PageHelper.startPage(pageNum,size);
        List<AppLeaseVo> appLeaseVoList =myHouseService.leaseList(tel);
        PageInfo<AppLeaseVo> pageInfo = new PageInfo<>(appLeaseVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据租赁主键id查询租赁信息
     * @param leaseId 租赁主键id
     * @return map
     */
    @GetMapping("/leaseFindById")
    public Map<String,Object> leaseFindById(Integer leaseId){
        return myHouseService.leaseFindById(leaseId);
    }

    /**
     * 提交个人租赁信息生成预览合同（续签也用这个）
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/submitPersonalLeaseInfo")
    public Map<String,Object> submitPersonalLeaseInfo(@RequestBody SysLease sysLease){
        return myHouseService.submitPersonalLeaseInfo(sysLease);
    }

    /**
     * 生成合同
     * @param appLeaseValidContract app租赁有效合同model
     * @return map
     */
    @PostMapping("/generateValidContract")
    public Map<String,Object> generateValidContract(@RequestBody AppLeaseValidContract appLeaseValidContract){
        return myHouseService.generateValidContract(appLeaseValidContract);
    }


    /**
     * 提交租赁审核信息
     * @param appLeaseSubmitAudit app 提交审核model
     * @return map
     */
    @PostMapping("/submitAudit")
    public Map<String,Object> submitAudit(@RequestBody AppLeaseSubmitAudit appLeaseSubmitAudit){
        return myHouseService.submitAudit(appLeaseSubmitAudit);
    }

    /**
     * 提交终止申请
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/submitTerminateApplication")
    public Map<String,Object> submitTerminateApplication(@RequestBody SysLease sysLease){
        return myHouseService.submitTerminateApplication(sysLease);
    }

    /**
     * app 房屋租赁-剩余需结清租金支付(当剩余需结清租金 小于等于 0 时调用)
     * @param sysLeaseRentOrder 房屋租赁主键id sysLeaseId 付款金额 payPrice
     * @return map
     */
    @PostMapping("/leaseRentOrderAlipay")
    public Map<String,Object> leaseRentOrderAlipay(@RequestBody SysLeaseRentOrder sysLeaseRentOrder){
        return myHouseService.leaseRentOrderAlipay(sysLeaseRentOrder);
    }

    /**
     * 保证金退还申请
     * @param sysLeaseId 租赁信息主键id
     * @return map
     */
    @GetMapping("/depositRefundApplication")
    public Map<String,Object> depositRefundApplication(Integer sysLeaseId){
        return myHouseService.depositRefundApplication(sysLeaseId);
    }

    /**
     * 查询所有的缴费查询（包含搜索条件）
     * @param searchAppLeaseRent app 租赁租金账单 搜索条件
     * @return map
     */
    @GetMapping("/findLeaseRentList")
    public Map<String,Object> findLeaseRentList(SearchAppLeaseRent searchAppLeaseRent){
        PageHelper.startPage(searchAppLeaseRent.getPageNum(),searchAppLeaseRent.getSize());
        List<AppLeaseRentVo> appLeaseRentVos =myHouseService.findLeaseRentList(searchAppLeaseRent);
        PageInfo<AppLeaseRentVo> pageInfo = new PageInfo<>(appLeaseRentVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
