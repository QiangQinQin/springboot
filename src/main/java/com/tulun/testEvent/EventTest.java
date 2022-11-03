package com.tulun.testEvent;
 
import org.springframework.context.ApplicationEvent;

// 事件本身
public class EventTest extends ApplicationEvent {
 
    private final int age;
 
    public EventTest(Object source, int age) {
        super(source);
        this.age = age;
    }
 
    public int getAge() {
        return age;
    }
}