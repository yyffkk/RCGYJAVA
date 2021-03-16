package com.api.butlerApp.controller.test;

import com.api.model.timer.MyTimerTask;
import com.api.util.JiguangUtil;
import com.api.util.UploadUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

@RestController
@RequestMapping("/test3")
public class Test3Controller {

    @GetMapping("/test2")
    public void test() throws InterruptedException {
        System.out.println("test");
        Timer timer = new Timer();
        MyTimerTask myTask = new MyTimerTask("哈哈");
        timer.schedule(myTask,2000L,1000L);
        //使用puge 打印当前已取消的任务数
        System.out.println("current canceled task number is "+timer.purge());
        //休眠5秒
        Thread.sleep(5000);
        myTask.cancel();//task的cancel方法
        System.out.println("current canceled task number is "+timer.purge());
    }
}
