package com.gree.scada.controller;

import com.gree.scada.config.VerifyThread;
import com.gree.scada.entity.common.ResultEntity;
import com.gree.scada.util.SignatureUtil;
import com.gree.scada.util.auth;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @program: WeChat
 * @CladdName paramController.java
 * @description: token传递
 * @author: 260340
 * @create: 2020-04-30 13:49
 **/

@RestController
@RequestMapping("/param")
@CrossOrigin
public class paramController {

    @PostMapping("/getSignature")
    public ResultEntity getSignature(@RequestParam String url) throws UnsupportedEncodingException {return ResultEntity.success(SignatureUtil.getSignature(url)); }

    @GetMapping("/getCode")
    public ResultEntity getCode() throws UnsupportedEncodingException {
        return ResultEntity.success(auth.getCode());
    }






}
