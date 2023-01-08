package com.tulun.testDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author QiangQin
 * * @date 2023/1/7
 */
public class testDIRedisTemplate {
//        @Autowired
//    private StringRedisTemplate stringRedisTemplate;
////    一个类，但实例有2个
//    @Autowired  // 来自spring ； 默认按name,即bean名称    required()表示注入时  该bean必须存在
//    private StringRedisTemplate stringRedisTemplate2;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    //    @Resource(name = "stringRedisTemplate2")
//    一个类，但实例有2个
    @Resource  // 来自JDK   name  和 type; 默认按type即类名
    private StringRedisTemplate stringRedisTemplate2;
}
