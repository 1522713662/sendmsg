package com.gree.scada.config;

/**
 * @program: WeChat
 * @CladdName TokenThread.java
 * @description: 获取token线程
 * @author: 260340
 * @create: 2020-04-17 14:48
 **/
public class TokenThread implements Runnable {

    public static AccessToken accessToken = null;

    public void run() {
        while (true) {
            try {
                accessToken = AccessToken.getAccessToken();
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
