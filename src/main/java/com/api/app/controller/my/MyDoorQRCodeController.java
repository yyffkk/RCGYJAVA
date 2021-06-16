package com.api.app.controller.my;

import com.api.manage.service.butlerService.SysDoorQRCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * app 门禁二维码
 */
@RestController
@RequestMapping("app/user/doorQRCode")
public class MyDoorQRCodeController {
    @Resource
    SysDoorQRCodeService sysDoorQRCodeService;
    /**
     * 获取设备二维码
     * @param startTime 生效时间戳
     * @param endTime 失效时间戳
     * @return map
     */
    @GetMapping("/getQrCode")
    public Map<String,Object> getQrCode(Date startTime, Date endTime,String tel){
        return sysDoorQRCodeService.getQrCode(startTime,endTime, tel);
    }
}
