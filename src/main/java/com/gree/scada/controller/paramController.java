package com.gree.scada.controller;

import com.gree.scada.config.VerifyThread;
import com.gree.scada.entity.common.ResultEntity;
import com.gree.scada.util.SignatureUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: WeChat
 * @CladdName paramController.java
 * @description: token传递
 * @author: 260340
 * @create: 2020-04-30 13:49
 **/

@RestController
@RequestMapping("/param")
public class paramController {

    @GetMapping("/getToken")
    public ResultEntity gettoken(){
    return ResultEntity.success(VerifyThread.accessToken.getToken());
    }

    @GetMapping("/getTicket")
    public ResultEntity getTicket(){
        return ResultEntity.success(VerifyThread.jsapiTicket.getTicket());
    }


    //@GetMapping("")
    public ResultEntity getSignature(){return ResultEntity.success(SignatureUtil.getSignature()); }
}
