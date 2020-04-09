package com.gree.scada.config;


import com.gree.scada.common.model.SendMessage;
import org.junit.Test;


public class ConfigTest {


    @Test
    public void test(){
        System.out.println("test");
    }


    @Test
    public void config(){
        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        System.out.println(TokenConfig.getInstance().token);
    }

    @Test
    public void send1(){
        SendMessage s = new SendMessage();
        s.sendTaskCard("@all","生产消息","温度高");
    }




}
