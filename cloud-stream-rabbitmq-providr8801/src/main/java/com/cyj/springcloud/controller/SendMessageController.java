package com.cyj.springcloud.controller;

import com.cyj.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
