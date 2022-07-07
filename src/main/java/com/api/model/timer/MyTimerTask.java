package com.api.model.timer;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public MyTimerTask(String taskName) {
        this.taskName = taskName;
    }

    public MyTimerTask() {
    }

    @Override
    public void run() {
        Date date = new Date();
        System.out.println("定时任务调度,当前执行的任务是"+"taskName"+"-"+date);
    }
}
