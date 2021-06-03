package com.api.manage.controller;

import com.api.util.webSocket.WebSocketService;
//import net.sf.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

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

//        //爬取医药网列表页面
//        Document doc = Jsoup.connect("https://www.chsi.com.cn/jyzx").get();
//        Element body = doc.body();
//        System.out.println(body);
//        Elements select = body.select(".content-l .news-list .news-title a");
//        //创建map存储器
//        HashMap<String, Object> map = new HashMap<>();
//        for (Element element : select) {
//            String href = element.attr("href");
//            String text = element.text();
//            //存进map中
//            map.put(text,href);
//        }
//
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            String mapKey = entry.getKey();
//            Object mapValue = entry.getValue();
//            System.out.println(mapKey+":"+mapValue);
//            //爬取医药网详情页
//            Document doc2 = Jsoup.connect("https://www.chsi.com.cn"+mapValue).get();
//            Element body2 = doc2.body();
//            Elements select2 = body2.select(".content-l");
//            String text = select2.text();
//            System.out.println(text);
//            map.put(mapKey,text);
//        }
//        System.out.println(map);

        log.info("这个测试log日志");
        return false;
    }
}
