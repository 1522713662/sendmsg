package com.gree.scada.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: WeChat
 * @CladdName auth.java
 * @description: 获取网页授权
 * @author: 260340
 * @create: 2020-06-10 09:50
 **/
public class auth {

    public static String getCode() throws UnsupportedEncodingException {

        Map<String,String> map = new HashMap<>();
        map.put("appid","ww189b700b23807b80");
        String u = URLDecoder.decode("http://scada.gree-wire.com:8081/#/infoDefine","UTF-8");
        map.put("redirect_uri",u);
        map.put("response_type","code");
        map.put("scope","snsapi_base");
        map.put("state","abcd");
        HttpEntity requestEntity = new HttpEntity(JSONObject.toJSONString(map), RestTemplateUtil.getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect\n";
        String s = restTemplate.postForObject(url,requestEntity, String.class);
        System.out.println("code:"+s);
        //JSONObject jsonObject = RestTemplateUtil.doPost(url, map);
        return s;
    }

}
