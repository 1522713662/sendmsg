package com.gree.scada.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive")
public class ReceiveMessageController {

    /*@RequestMapping(value = "/getWeChatInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public String receive(@RequestParam String f){
        if (f.equals("0")){
            return "收到";
        }
        return "未收到";
    }*/
}
