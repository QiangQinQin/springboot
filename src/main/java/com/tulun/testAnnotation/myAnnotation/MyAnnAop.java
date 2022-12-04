package com.tulun.testAnnotation.myAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class MyAnnAop {
    private Logger logger = LoggerFactory.getLogger(MyAnnAop.class);

//    定义切入点  其中  @annotation：用于匹配当前执行方法持有指定注解的方法，如  com.tulun.myAnnotation.TestService.test方法
    @Pointcut("@annotation(com.tulun.testAnnotation.myAnnotation.MyAnn)")
    public void ann() {
        System.out.println("进入 ann()" );
    }

// ann() 是方法名，即切入点
    @Before("ann()")
    public void before(JoinPoint joinPoint) {
        logger.info("打印：开始前");
    }

    @AfterReturning(value = "ann()", returning = "res")
    public Object dochange(JoinPoint joinPoint, Object res) {
        logger.info("AfterReturning通知开始-获取数据:{}", res);
        //获取数据
        Map<String, String> map = (Map<String, String>) res;
        //添加新值
        map.put("s1", "我是在AOP中添加的新值");
        return map;
    }
}