package com.tulun;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 */
//todo:@value  @Bean测试resdis
//@Service
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"classpath:Application.yml"})
@SpringBootTest(classes = HelloApplication.class)
public class redisTest
{
//    @Resource  //https://blog.csdn.net/cheers_bin/article/details/125637817   https://www.cnblogs.com/wangrong1/p/12187674.html
//    private RedisTemplate<String,Object> redisTemplate;// <1>
//
//    @Resource
//    private StringRedisTemplate StringRedisTemplate;
//
    @Autowired
    private RedisTemplate redisTemplate;
//
    @Test
    public void test() throws Exception {
        System.out.println("hello");
        redisTemplate.opsForValue().set("student:1", "kirito"); // <2>
        System.out.println( redisTemplate.opsForValue().get("student:1"));
//        Assertions.assertThat(redisTemplate.opsForValue().get("student:1")).isEqualTo("kirito");
    }
}
