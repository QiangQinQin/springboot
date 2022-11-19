package com.tulun;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 */
//todo:@value  @Bean测试resdis  @Autowired 和 @Resource
//@Service
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"classpath:Application.yml"})
@SpringBootTest(classes = HelloApplication.class)
@Slf4j
public class redisTest
{
    //https://blog.csdn.net/cheers_bin/article/details/125637817   https://www.cnblogs.com/wangrong1/p/12187674.html
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;// <1>

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Resource
//    private RedisTemplate RedisTemplate;
//

    @Test
    public void test() throws Exception {
        System.out.println("hello ");
        if(stringRedisTemplate.hasKey("test")){
            stringRedisTemplate.opsForValue().increment("test",1L); //ERR value is not an integer or out of range
        }else{
            stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
            stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
            stringRedisTemplate.opsForValue().set("test", "1");
        }
        System.out.println( stringRedisTemplate.opsForValue().get("test"));
    }

    @Test
    public void testLog() throws Exception {
        String out = "test1111";
        log.info("idass:{}", out);
        log.error("idass:{}", out);
        log.warn("idass:{}", out);
    }
}
