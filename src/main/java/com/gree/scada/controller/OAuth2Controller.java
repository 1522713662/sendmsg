package com.gree.scada.controller;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.VerifyThread;
import com.gree.scada.config.WeChatData;
import com.gree.scada.entity.common.ResultEntity;
import com.gree.scada.util.RestTemplateUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @program: WeChat
 * @CladdName OAuth2Controller.java
 * @description: OAuth2身份验证
 * @author: 260340
 * @create: 2020-06-10 15:04
 **/
@RestController
@RequestMapping("/oauth2")
@CrossOrigin
public class OAuth2Controller {

    @PostMapping(value = {"/oauth2Url"})
    public ResultEntity Oauth2API(HttpServletRequest request, @RequestParam String url) {
        String redirect_uri = "";
        System.out.println("传入URL："+url);
        redirect_uri = URLDecoder.decode(url);
        String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatData.corpid + "&redirect_uri=" + redirect_uri
                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        System.out.println("拼接url:"+oauth2Url);
        return ResultEntity.success(oauth2Url);
    }

    /**
     * 授权回调请求处理
     *
     * @return
     */
    @PostMapping(value = {"/oauth2me"})
    public ResultEntity oAuth2Url(HttpServletRequest request, @RequestParam String code) {
        JSONObject userInfo = null;
        // 调用获取access_token的接口
        String token = VerifyThread.accessToken.getToken();
        if (token != null) {
            // 调用获取用户信息的接口
            String userId = getUserIdByCode(token, code);
            if (userId != null) {
                userInfo = getUserInfoByUserId(token, userId);
            }
        }
        System.out.println("userInfo信息:"+userInfo);
        return ResultEntity.success(userInfo);
    }

    /**
     * 调用接口获取用户信息
     *
     * @param token
     * @param code
     * @return
     */
    public String getUserIdByCode(String token, String code) {

        System.out.println("传入code："+code);
        String userId =null;
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE".replace("ACCESS_TOKEN", token).replace("CODE", code);
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        if (jsonObject != null){
            userId = jsonObject.getString("UserId");
        }
        return userId;

    }


    public static JSONObject getUserInfoByUserId(String token, String userId) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID".replace("ACCESS_TOKEN", token).replace("USERID", userId);
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        return jsonObject;
    }
}
