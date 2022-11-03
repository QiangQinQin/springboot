package com.tulun.testEvent;
 
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
   接受事件的对象
 方式1：  使用onApplicationEvent方法
 */
@Component
public class EventTestListener implements ApplicationListener<EventTest> {
    @Override
    public void onApplicationEvent(EventTest event) {
        System.out.println("onApplicationEvent中监听到 Age为" + event.getAge() + "岁。");
    }
}