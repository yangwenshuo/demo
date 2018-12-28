package com.stt.schedule;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {


    //任务调度只需要在方法上加一个这个注解,然后就可以执行了
    //在启动类也需要加个注解
//    @Scheduled(fixedRate = 1000)
    public void testTask(){
        System.out.println("雷霆半月斩");
    }
}
