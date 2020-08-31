package com.cyj.springcloud.controller;

import com.cyj.springcloud.entities.CommonResult;
import com.cyj.springcloud.entities.Payment;
import com.cyj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController// @RestController=@Controller+@ResponseBody
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
                 int result = paymentService.create(payment);
              log.info("*****插入结果：" + result);
              if (result > 0){
                  return new CommonResult(200, "插入数据库成功,ServerPort:"+serverPort, result);
                  }
                  return new CommonResult(444, "插入数据库失败", null);
            }
    @GetMapping(value = "/payment/get/{id}")    //写操作POST  读get    还有pull等等
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

               Payment payment = paymentService.getPaymentById(id);
               log.info("*****查询结果：" + payment);
               if (payment != null) {
                       return new CommonResult(200, "查询数据库成功,ServerPort: "+serverPort, payment);
                  } else {
                        return new CommonResult(444, "查询ID:" + id + ",没有对应记录", null);
                   }
             }
}
