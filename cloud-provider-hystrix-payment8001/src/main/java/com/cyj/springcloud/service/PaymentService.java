package com.cyj.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().toString() + ",paymentInfo_ok,id:" + id + ",^_^哈哈";
    }
    public String paymentInfo_timeout(Integer id) {
        int timeNumber=3;
       try {
           TimeUnit.SECONDS.sleep(timeNumber);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        return "线程池：" + Thread.currentThread().toString() + ",paymentInfo_timeout,id:" + id + ",^_^哈哈"+",耗时(秒):"+timeNumber;
    }
}
