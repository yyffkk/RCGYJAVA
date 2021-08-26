package com.api.manage.controller;


import com.api.util.Base64Util;
import com.api.util.EmojiUtils;
import com.api.util.IdWorker;
import com.api.util.LiLinSignGetHmac;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import org.json.JSONObject;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("manage/test")
public class TestController   {
//    @RequiresPermissions(value = {"0201"})
    @GetMapping("/test")
    public String test() throws Exception {

//        String signature ="{\"clientId\":\"70d274b536f930b70314c2d01243ddd3\",\"method\":\"addFaceRecognize\",\"timestamp\":\"1619170441585\",\"nonce\":\"9838a707-156b-429a-b9e1-355f5a20f324\",\"data\":{\"neighNo\":\"450127500001\",\"deviceSn\":\"45012750000102010501\",\"phoneNumber\":15068133808,\"startTime\":1619280000000,\"endTime\":1619366399000,\"photoUrl\":\"http://test.akuhotel.com:8804/static/img/h5/visit/641043db8d9944cb975eeeddcc8089ab.jpeg\",\"floorType\":2}}";
//
//        String s = LiLinSignGetHmac.genHMAC(signature, "18d4873936e0e42ac3510402dee8611c");
//        String imgUrl = "/img/22.png";
//        //传入真实路径（没有文件服务器的情况，用项目目录下的static）
//        // 获取项目同级目录，传入static中
//        String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
//        File file = new File(realPath+imgUrl);
//        InputStream inputStream = new FileInputStream(file);
//        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
//
        try {
                //getkey 获取密钥
                String json = "{\"username\":\"nnrcgy\",\"userpwd\":\"rcgy.123\",\"code\" :\"BBA57BFB-53AC-4C39-B736-735EA11D2E51\"}";
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30000, TimeUnit.MILLISECONDS)
                        .readTimeout(30000, TimeUnit.MILLISECONDS)
                        .build();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = FormBody.create(mediaType, json);
                Request request = new Request.Builder()
                        .url("http://42p4v31138.zicp.vip/api/server/getkey")
                        .post(requestBody)
                        .build();
                Response execute = client.newCall(request).execute();
                if (execute.isSuccessful()) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        //获取返回值
                        String result = body.string();
                        log.info("返回值:"+result);
                        JSONObject jsonObject = new JSONObject(result);
                        JSONObject httpData = (JSONObject) jsonObject.get("HttpData");
                        String code = String.valueOf(httpData.get("code"));
                        JSONObject data = (JSONObject) httpData.get("data");
                        String appKey = String.valueOf(data.get("appkey"));
                        String infoKey = String.valueOf(data.get("infokey"));
                        String authorization = appKey + "-" + infoKey; //拼接密钥 【authorization = appKey-infoKey】
                        log.info(authorization);
                        //=====判断返回是否成功
                        if ("200".equals(code)){
                            log.info("返回成功");
                            return "true";
                        }else {
                            log.info("返回失败");
                            throw new RuntimeException(String.valueOf(httpData.get("message")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
//        return s;
    }
}
