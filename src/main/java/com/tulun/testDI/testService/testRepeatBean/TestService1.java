package com.tulun.testDI.testService.testRepeatBean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

////@Resource(name="testService1Repeat")
//@Service(value = "testService1Repeat")
//@Service

@Resource
@Primary
public class TestService1 {
    public void test1() {
    }
}