package com.gree.scada.config;


import com.gree.scada.entity.request.ReceiveTaskCardPo;
import com.gree.scada.entity.response.TaskCardPo;
import com.gree.scada.service.SendMessageServiceImpl;
import com.gree.scada.util.ReplyMsgUtil;
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
        SendMessageServiceImpl s = new SendMessageServiceImpl();
        s.sendTaskCard("260340","温度高");
    }

    public static void main(String[] args) {

        String s = "<xml><ToUserName><![CDATA[ww189b700b23807b80]]></ToUserName><FromUserName><![CDATA[260340]]></FromUserName><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[taskcard_click]]></Event><CreateTime>1586588652</CreateTime><EventKey><![CDATA[key1]]></EventKey><TaskId><![CDATA[5d8152dd-681e-4eb8-ba15-adbe8f892f96]]></TaskId><AgentId>1000015</AgentId></xml>";
        TaskCardPo s1 = ReplyMsgUtil.xmlStrToPo(s, TaskCardPo.class);
        System.out.println(s1);
    }




}
