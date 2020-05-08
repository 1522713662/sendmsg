package com.gree.scada.util;

import com.gree.scada.config.VerifyThread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.gree.scada.util.Sha1Util.SHA1;

/**
 * @program: WeChat
 * @CladdName SignatureUtil.java
 * @description: 签名算法
 * @author: 260340
 * @create: 2020-05-07 14:37
 **/
public class SignatureUtil {

    private static String create_nonce_str() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取签名
     * @return map(noncestr,timestamp,signature)
     */
    public static Map<String, String> getSignature(){

        Map<String,String> map =  new HashMap<>();
        String noncestr = create_nonce_str();
        String timestamp = create_timestamp();

        map.put("noncestr",noncestr);
        map.put("timestamp",timestamp);
        //URL取值？？？？
        String url="http://www.WEIXIN.com/add.html";

        String str = "jsapi_ticket="+ VerifyThread.jsapiTicket.getTicket() +
                "&noncestr="+noncestr+ "&timestamp="+timestamp+"&url="+url;


        String signature =SHA1(str);
        System.out.println("参数："+str+"\n签名："+signature);

        map.put("signature",signature);
        return map;
    }
}
