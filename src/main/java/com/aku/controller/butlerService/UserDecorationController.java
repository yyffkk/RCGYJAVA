package com.aku.controller.butlerService;

import com.aku.model.butlerService.QRCodeContent;
import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.service.butlerService.UserDecorationService;
import com.aku.util.GetIpAndPort;
import com.aku.util.QRCodeUtil;
import com.aku.vo.butlerService.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDecoration")
public class UserDecorationController {
    @Resource
    UserDecorationService userDecorationService;

    /**
     * 查询装修信息（包含条件搜索）
     * @param searchUserDecoration 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserDecoration searchUserDecoration){
        PageHelper.startPage(searchUserDecoration.getPageNum(),searchUserDecoration.getSize());
        List<VoUserDecoration> voUserDecorationList =userDecorationService.list(searchUserDecoration);
        PageInfo<VoUserDecoration> pageInfo = new PageInfo<>(voUserDecorationList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 生成二维码
     * @param qrCodeContent 二维码参数
     * @return map （二维码路径）
     */
    @PostMapping("/createQRCode")
    public Map<String,Object> insert(@RequestBody QRCodeContent qrCodeContent){
        Map<String,Object> map = new HashMap<>();
        try {
            //二维码内容
            //https://mobile.baidu.com/item?docid=27624327&source=s1001
            String text = "http://www.baidu.com?qrCodeContent="+qrCodeContent;
            //不含Logo，不指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  needCompress：是否压缩LOGO
            //QRCodeUtil.encode(text, null, "e:\\", true);
            //含Logo，不指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  needCompress：是否压缩LOGO
            //QRCodeUtil.encode(text, "e:\\csdn.jpg", "e:\\", true);
            //含Logo，指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  fileName：二维码文件名  needCompress：是否压缩LOGO
            QRCodeUtil.encode(text, "src/main/resources/static/img/logo/QRCode.png", "src/main/resources/static/img/QRCode", "qrcode", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("imgUrl","二维码生成失败");
            return map;
        }
        map.put("imgUrl","/img/QRCode/qrcode.jpg");
        return map;
    }

    /**
     * 装修人员情况list
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/decorationPersonnelList")
    public Map<String,Object> decorationPersonnelList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserDecorationPersonnel> voUserDecorationPersonnelList = userDecorationService.decorationPersonnelList(id);
        PageInfo<VoUserDecorationPersonnel> pageInfo = new PageInfo<>(voUserDecorationPersonnelList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 显示所有门禁卡信息
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/userAccessCardList")
    public Map<String,Object> userAccessCardList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserAccessCard> voUserAccessCardList = userDecorationService.userAccessCardList(id);
        PageInfo<VoUserAccessCard> pageInfo = new PageInfo<>(voUserAccessCardList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有跟踪检查记录
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    public Map<String,Object> decorationTrackRecordList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationService.decorationTrackRecordList(id);
        PageInfo<VoUserDecorationTrackRecord> pageInfo = new PageInfo<>(voUserDecorationTrackRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
