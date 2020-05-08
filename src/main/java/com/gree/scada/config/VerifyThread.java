package com.gree.scada.config;

import com.gree.scada.entity.common.AccessToken;
import com.gree.scada.entity.common.JsapiTicket;

/**
 * @program: WeChat
 * @CladdName VerifyThread.java
 * @description: 获取线程
 * @author: 260340
 * @create: 2020-04-17 14:48
 **/
public class VerifyThread implements Runnable {

    public static AccessToken accessToken = null;
    public static JsapiTicket jsapiTicket = null;


    public void run() {
        while (true) {
            try {
                accessToken = AccessToken.getAccessToken();
                jsapiTicket = JsapiTicket.getJsapiTicket();
                if (null != accessToken) {
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpires_in() - 200) * 1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    e.printStackTrace();
                }
            }
        }
    }
}
