package com.tulun;

import com.tulun.testAnnotation.TestGetValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
@MapperScan("com.tulun.mapper") //使用注解 批量扫描所有的mapper接口 （会自动生成接口的代理对象）     或者 去mapper里每一个接口前面添加一个@mapper注解
@EnableCaching
public class HelloApplication
{
    public static void main( String[] args ) throws ClassNotFoundException {
        SpringApplication.run(HelloApplication.class, args);

       /*
       获取注解[@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackageClasses=[], exclude=[], proxyBeanMethods=true, excludeName=[], scanBasePackages=[]), @org.springframework.context.annotation.Configuration(value=, proxyBeanMethods=true), @org.mybatis.spring.annotation.MapperScan(sqlSessionFactoryRef=, sqlSessionTemplateRef=, lazyInitialization=, annotationClass=interface java.lang.annotation.Annotation, basePackageClasses=[], nameGenerator=interface org.springframework.beans.factory.support.BeanNameGenerator, markerInterface=class java.lang.Class, basePackages=[], value=[com.tulun.mapper], factoryBean=class org.mybatis.spring.mapper.MapperFactoryBean, defaultScope=)]
       * */
//        System.out.println("获取注解"+Arrays.toString(new HelloApplication().getClass().getAnnotations()) );

    }

//    @Autowired
//    private  TestGetValue testGetValue;
//
//    @Autowired
//   private Environment environment;
//
//    @Bean
//    public  void  testGetKey(){
////         方式1：
//        System.out.println("test获取@Value的值： "+testGetValue.getTestKey());
//
////        方式2：
//        System.out.println("通过environment获取@Value的值"+environment.getProperty("test.key"));
//    }

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    // 工程启动，初始化bean,就会执行test里的 redis操作
//    @Bean
//    public void test() throws Exception {
//        System.out.println("hello ");
//        if (stringRedisTemplate.hasKey("test")) {
//            stringRedisTemplate.opsForValue().increment("test", 1L); //ERR value is not an integer or out of range
//        }
//    }
}
