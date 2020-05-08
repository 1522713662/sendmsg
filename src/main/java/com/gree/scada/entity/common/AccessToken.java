package com.gree.scada.entity.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.WeChatData;
import com.gree.scada.util.RestTemplateUtil;
import lombok.Data;

/**
 * @program: WeChat
 * @CladdName AccessToken.java
 * @description:
 * @author: 260340
 * @create: 2020-04-17 14:51
 **/
@Data
public class AccessToken {

    private String token;
    private Integer expires_in;
    private String errmsg;
    private String errcode;


    /**
     * 获取access_token
     */
    public static AccessToken getAccessToken(){
        String url= WeChatData.TOKEN_URL.replace("CORPID", WeChatData.corpid).replace("CORPSECRET", WeChatData.corpsecret);
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        AccessToken accessToken = JSONArray.parseObject(String.valueOf(jsonObject), AccessToken.class);
        accessToken.setToken(jsonObject.getString("access_token"));
        return accessToken;
    }
}
