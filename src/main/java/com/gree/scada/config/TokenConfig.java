package com.gree.scada.config;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.util.RestTemplateUtil;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

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
    @PostConstruct
    private String getAccessToken(){
        RestTemplate restTemplate = new RestTemplate();
        String url= WeChatData.TOKEN_URL.replace("CORPID", "ww189b700b23807b80").replace("CORPSECRET", "uFJ4UBY0RNiYcMRJNZ6c8NJ0Ko8ZnsiKxPVoLFdlVjc");
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        String access_token = jsonObject.getString("access_token");
        return access_token;
}


}