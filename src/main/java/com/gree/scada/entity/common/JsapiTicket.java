package com.gree.scada.entity.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.WeChatData;
import com.gree.scada.util.RestTemplateUtil;
import lombok.Data;

import static com.gree.scada.config.VerifyThread.accessToken;

/**
 * @program: WeChat
 * @description: JsapiTicket
 * @author: 260340
 * @create: 2020-04-30 14:34
 **/
@Data
public class JsapiTicket {
    private String ticket;
    private Integer expires_in;
    private String errmsg;
    private String errcode;

    /**
     * 获取JsapiTicket
     */
    public static JsapiTicket getJsapiTicket(){
        String url= WeChatData.JSTICKET_URL.replace("ACCESS_TOKEN", accessToken.getToken());
        JSONObject jsonObject = RestTemplateUtil.doGet(url);
        JsapiTicket jsapiTicket = JSONArray.parseObject(String.valueOf(jsonObject), JsapiTicket.class);
        return jsapiTicket;
    }
}
