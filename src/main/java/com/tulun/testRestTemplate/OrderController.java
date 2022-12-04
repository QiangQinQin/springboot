package com.tulun.testRestTemplate;

import io.lettuce.core.GeoCoordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

  /*
  RestTemplate远程调用的请求参数都被打包成了json格式，
  所以远程接口的  接收参数 一定要添加 @RequestBody，
  否则是无法成功传输的！
  * */
//    @PostMapping("/create")
//    public CommonResult2 create(@RequestBody Payment payment){
//        return paymentService.create(payment);
//    }


    //   传一个实体，调用远程接口将实体  持久化到数据库中
    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        log.info(payment.toString());
        //  参数分别为   请求地址、请求参数、返回类型
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/hello", payment, CommonResult.class);
        return entity.getBody();
    }

//    请求一个实体信息  http://localhost:8080/consumer/payment/get/1
    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") long id) {
        log.info("consumer-Payment被调用");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return entity.getBody();
    }

//    http://localhost:8080/consumer/rpc
    @RequestMapping("/rpc")
    public String callHello() {
        log.info("callHello被调用");
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/hello" , String.class);
        return entity.getBody();
    }
}
