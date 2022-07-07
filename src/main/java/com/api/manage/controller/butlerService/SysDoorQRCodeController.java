package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysDoorQRCodeService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchDoorQRCode;
import com.api.model.butlerService.SysDoorQRCode;
import com.api.vo.butlerService.VoDispatchList;
import com.api.vo.butlerService.VoDoorQRCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门禁二维码
 */
@RestController
@RequestMapping("manage/doorQRCode")
public class SysDoorQRCodeController {
    @Resource
    SysDoorQRCodeService sysDoorQRCodeService;

    /**
     * 查询设备二维码
     * @param searchDoorQRCode 门禁二维码 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchDoorQRCode searchDoorQRCode){
        PageHelper.startPage(searchDoorQRCode.getPageNum(),searchDoorQRCode.getSize());
        List<VoDoorQRCode> voDoorQRCodeList = sysDoorQRCodeService.list(searchDoorQRCode);
        PageInfo<VoDoorQRCode> pageInfo = new PageInfo<>(voDoorQRCodeList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加设备二维码
     * @param sysDoorQRCode 门禁二维码model
     * @return map
     */
    @PostMapping("/addQrCode")
    public Map<String,Object> addQrCode(@RequestBody SysDoorQRCode sysDoorQRCode){
        return sysDoorQRCodeService.addQrCode(sysDoorQRCode);
    }


    /**
     * 获取设备二维码
     * @param startTime 生效时间戳
     * @param endTime 失效时间戳
     * @return map
     */
    @GetMapping("/getQrCode")
    public Map<String,Object> getQrCode(Date startTime,Date endTime,String tel){
        return sysDoorQRCodeService.getQrCode(startTime,endTime,tel);
    }


    /**
     * 删除设备二维码
     * @param sysDoorQRCode 门禁二维码model
     * @return map
     */
    @PostMapping("/removeQrCode")
    public Map<String,Object> removeQrCode(@RequestBody SysDoorQRCode sysDoorQRCode){
        return sysDoorQRCodeService.removeQrCode(sysDoorQRCode);
    }
}
