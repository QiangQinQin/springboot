package com.tulun.testAnnotation.myAnnotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//控制层
@RestController
public class Test2 {
    private Logger logger= LoggerFactory.getLogger(Test2.class);

    @Autowired
    private TestService testService;
    //  http://localhost:8080/test
    @GetMapping("/test")
    public String test(String id){
        Map<String,String> s=testService.test();
        logger.info("控制层输出：{}",s.get("s1"));
        return "sccess";
    }
}