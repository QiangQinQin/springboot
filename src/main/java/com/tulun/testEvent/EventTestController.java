package com.tulun.testEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 发布事件的对象
@RestController
@RequestMapping("/test")
public class EventTestController {
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/pub-event")   //http://localhost:8080/test/pub-event
    public void pub() {
        applicationContext.publishEvent(new EventTest(this, 4));
    }
}