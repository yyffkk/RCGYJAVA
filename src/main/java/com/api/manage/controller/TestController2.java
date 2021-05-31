package com.api.manage.controller;

import com.api.util.webSocket.WebSocketService;
//import net.sf.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("manage/test2")
public class TestController2 {
    @GetMapping("/test2")
    public Boolean test2(HttpServletRequest request) throws IOException {
//        WebSocketService ws = new WebSocketService();
//        JSONObject jo = new JSONObject();
//        jo.put("message", "这是后台返回的消息！");
//        jo.put("To","All");
//        ws.onMessage(jo.toString());
//        ws.broadcast("这是后台返回的消息");

        Document document = Jsoup.connect("https://www.baidu.com/").get();
        System.out.println(document);

        log.info("这个测试log日志");
        return false;
    }
}
