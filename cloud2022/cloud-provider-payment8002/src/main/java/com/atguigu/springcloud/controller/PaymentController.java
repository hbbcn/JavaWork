package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 *@ClassName PaymentController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/1/23 23:21
 *@Version 1.0
 */
@RestController
@Slf4j
public class PaymentController{

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);


        System.out.println(payment);
        System.out.println("******");
        log.info("******插入结果：" + result);

        if (result > 0){
            return  new CommonResult(200,"插入数据库成功,serverPort:" + serverPort,result);

        }else {
            return new CommonResult(404, "插入数据库失败");
        }


    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id ){

        Payment payment = paymentService.getPaymentById(id);


        log.info("******查询结果8002：" + payment);
        if (payment != null){
            return  new CommonResult(200,"查询成功,serverPort:" + serverPort,payment);

        }else {
            return new CommonResult(404, "没有对应记录 查询ID" +id );
        }

    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}

