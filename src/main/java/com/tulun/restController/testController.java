package com.tulun.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QiangQin
 * * @date 2022/11/15
 */
@RestController
@RequestMapping(path="/demo")
public class testController {

//    http://localhost:8080/demo/map
    @RequestMapping(path="/map",method= RequestMethod.GET)
    public Map<String,String> map(){
         Map<String,String> map=new HashMap<>();
         map.put("key","value");
         return map;
    }

}
