package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysDoorQRCodeService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SysDoorQRCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
}
