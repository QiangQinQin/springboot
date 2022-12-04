package com.tulun.testAnnotation.myAnnotation;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//服务层
@Service
public class TestService {
    @MyAnn
    public Map test(){
        Map<String,String>  map=new HashMap<>();
        map.put("t1","我是在Service设置的值");
        return map;
    }
}
