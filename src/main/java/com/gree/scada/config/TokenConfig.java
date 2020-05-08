package com.gree.scada.config;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.util.RestTemplateUtil;
import lombok.Data;

/**
 * @program: scada_weixin
 * @CladdName TokenConfig.java
 * @description: 获取WeChat的 access_token
 * @author: 260340
 * @create: 2020-03-21 15:45
 **/

@Data
//@PropertySource("classpath:application.properties")
public class TokenConfig {

    /**
     * 企业ID
     */

    public String scorpid;

    /**
     * 应用凭证秘钥
     */
    public String scorpsecret;

    /**
     * access_token
     */
    public String token;

    private static TokenConfig tokenConfig;

    public static TokenConfig getInstance(){

        if (tokenConfig == null){
            tokenConfig = new TokenConfig();
            tokenConfig.token =tokenConfig.getAccessToken();
        }
        return tokenConfig;
    }




    /**
     * 获取access_token
     */
    private String getAccessToken(){
        String url= WeChatData.TOKEN_URL.replace("CORPID", WeChatData.corpid).replace("CORPSECRET", WeChatData.corpsecret);
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        System.out.println("token："+jsonObject);
        String access_token = jsonObject.getString("access_token");
        return access_token;
}


}