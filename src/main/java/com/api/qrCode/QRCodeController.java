package com.api.qrCode;

import com.api.wx.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/qrCode")
public class QRCodeController {
    @Resource
    QRCodeServiceImpl qrCodeService;

    @PostMapping("/getQRCode")
    public Result<Boolean> getQRCode() throws Exception {
        return Result.success(qrCodeService.buildQRCode());
    }

    @PostMapping("/findRemark2")
    public Result<String> findRemark2(@RequestBody ResidentInformation residentInformation){
        return Result.success(qrCodeService.findRemark2(residentInformation));
    }

}
