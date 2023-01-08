package com.tulun.testDI.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class TestService2 {

    /*
    Annotation-specified bean name 'testService1' for bean class [com.tulun.testDI.testService.testRepeatBean.TestService1] conflicts with existing, non-compatible bean definition of same name and class [com.tulun.testDI.testService.TestService1]
   这种情况是因为spring的@Service方法不允许出现相同的类名，因为spring会将类名的第一个字母转换成小写，作为bean的名称，比如：testService1，
   而默认情况下bean名称必须是唯一的。

    * */
    @Autowired
    private TestService1 testService1;

    public void test2() {
    }
}