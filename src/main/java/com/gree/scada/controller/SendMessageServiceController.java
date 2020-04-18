package com.gree.scada.controller;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.service.SendMessageService;
import com.gree.scada.service.SendMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: WeChat
 * @CladdName SendMessageController.java
 * @description: 自动推送报警消息
 * @author: 260340
 * @create: 2020-04-10 11:27
 **/
@RestController
@RequestMapping("/weChat_send")
public class SendMessageServiceController {

    @Autowired
    SendMessageService sendMessageService;
    @GetMapping
    public void sendMsg(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser","260340");
        jsonObject.put("description","温度高");
        jsonObject.put("mttf",20);
        jsonObject.put("laster","260340");
        sendMessageService.firstPush(jsonObject);
    }

    /*@GetMapping("/test")
    public String test(){
                String s = UUID.randomUUID().toString();
                return s;

    }*/


}
