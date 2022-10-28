package com.api.app.controller.share_h5;

import com.api.app.service.butler.AppVisitorInviteService;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.manage.service.basicArchives.CpmBuildingUnitService;
import com.api.manage.service.butlerService.SysDoorQRCodeService;
import com.api.manage.service.system.UploadService;
import com.api.model.app.AppUserQRVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.vo.basicArchives.VoFindAll;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * app访客邀请h5分享接口
 */
@RestController
@RequestMapping("app/share/visitorApplication")
public class ShareVisitorInviteController {
    @Resource
    AppVisitorInviteService appVisitorInviteService;
    @Resource
    UploadService uploadService;
    @Resource
    CpmBuildingService cpmBuildingService;
    @Resource
    CpmBuildingUnitService cpmBuildingUnitService;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;
    @Resource
    SysDoorQRCodeService sysDoorQRCodeService;

    /**
     * 根据分享连接编号查询访客信息（H5页面接口）
     * @param code 分享连接编号
     * @return map
     */
    @GetMapping("/findByUrlCode")
    public Map<String,Object> findByUrlCode(String code){
        return appVisitorInviteService.findByUrlCode(code);
    }

    /**
     * 上传访客邀请自拍照(H5页面)
     * @param fileStr 上传文件base64编码
     * @return map
     */
    @PostMapping("/uploadH5Visit")
    public Map<String,Object> uploadH5Visit(@RequestBody String fileStr){
        return uploadService.uploadH5Visit(fileStr);
    }

    /**
     * 提交访客信息(H5页面)
     * @param visitorsInviteSubmit 访客邀请提交信息(H5提交model)
     * @return map
     */
    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody AppUserVisitorsInviteSubmit visitorsInviteSubmit){
        //处理预计到访时间开始 和 预计到访时间结束
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            visitorsInviteSubmit.setVisitDateStart(simpleDateFormat.parse(DateFormatUtils.format(visitorsInviteSubmit.getVisitDateStart(),"yyyy-MM-dd 00:00:00")));
            visitorsInviteSubmit.setVisitDateEnd(simpleDateFormat.parse(DateFormatUtils.format(visitorsInviteSubmit.getVisitDateStart(),"yyyy-MM-dd 23:59:59")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return appVisitorInviteService.submit(visitorsInviteSubmit);
    }

    /**
     * 提交访客信息（扫码二维码后提交的数据,H5页面）
     * @param qrVisitorsInviteSubmit 访客邀请提交信息QR(扫码二维码后，H5提交model)
     * @return map
     */
    @PostMapping("/QRSubmit")
    public Map<String,Object> QRSubmit(@RequestBody AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit){
        //处理预计到访时间开始 和 预计到访时间结束
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            qrVisitorsInviteSubmit.setVisitDateStart(simpleDateFormat.parse(DateFormatUtils.format(qrVisitorsInviteSubmit.getVisitDateStart(),"yyyy-MM-dd 00:00:00")));
            qrVisitorsInviteSubmit.setVisitDateEnd(simpleDateFormat.parse(DateFormatUtils.format(qrVisitorsInviteSubmit.getVisitDateStart(),"yyyy-MM-dd 23:59:59")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return appVisitorInviteService.QRSubmit(qrVisitorsInviteSubmit);
    }

    /**
     * 查询所有楼栋id和name(H5页面)
     * @return List<VoFindAll>
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return cpmBuildingService.findAll();
    }

    /**
     * 根据楼栋id查询对应的单元id和name(H5页面)
     * @param id 楼栋id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingId")
    public List<VoFindAll> findByBuildingId(Integer id){
        return cpmBuildingUnitService.findByBuildingId(id);
    }

    /**
     * 根据单元id查询对应的房产id和name(H5页面)
     * @param id 楼栋单元id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingUnitId")
    public List<VoFindAll> findByBuildingUnitId(Integer id){
        return cpmBuildingUnitEstateService.findByBuildingUnitId(id);
    }

    /**
     * 获取设备二维码（H5页面）
     * @param startTime 生效时间戳
     * @param endTime 失效时间戳
     * @param tel 访客手机号
     * @return map
     */
    @GetMapping("/getHtmlCode")
    public Map<String,Object> getHtmlCode( Date startTime, Date endTime, String tel){
        return sysDoorQRCodeService.getHtmlCode(startTime,endTime, tel);
    }

}
