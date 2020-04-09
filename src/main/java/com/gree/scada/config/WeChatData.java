package com.gree.scada.config;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class WeChatData {


    public static String corpid = "";
    public static String corpsecret = "";
    public static String agentid = "";
    public static String TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
    public static String SEND_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
    public static String task_id = UUID.randomUUID().toString();


    public void initProperties() {

        Properties properties = new Properties();

        InputStream in = getClass().getResourceAsStream("/application.properties");

        try {
            properties.load(new BufferedInputStream(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        corpid = properties.getProperty("corpid");
        corpsecret = properties.getProperty("corpsecret");
        agentid = properties.getProperty("agentid");
    }

}
