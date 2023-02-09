package com.tulun;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

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


//    教程： https://www.cnblogs.com/kitor/p/11235762.html
    @Test
    public void testHttpClient() throws IOException {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明get请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=java");
        //3.发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.判断状态码
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        //5.关闭资源
        response.close();
        httpClient.close();
    }

}
