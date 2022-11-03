package com.tulun.testEvent;
 
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/*
   接受事件的对象
 方式2：  使用@EventListenert方法
 */
@Component
public class EventTestListenerByAnnotation {
    @EventListener
    public void listener1(EventTest event) {
        System.out.println(" @EventListener中监听到 Age为" + event.getAge() + "岁。");
    }
}