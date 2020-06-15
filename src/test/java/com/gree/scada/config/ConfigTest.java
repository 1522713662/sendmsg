package com.gree.scada.config;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.entity.common.AccessToken;
import com.gree.scada.entity.response.TaskCardPo;
import com.gree.scada.entity.service.Roster;
import com.gree.scada.service.RosterService;
import com.gree.scada.service.impl.SendMessageServiceImpl;
import com.gree.scada.util.ReplyMsgUtil;
import org.junit.Test;


public class ConfigTest {

    SendMessageServiceImpl sendMessageService;

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

        String s = "{\"errcode\":0,\"access_token\":\"tCBRlvfyiAYWOcOEJydwy9Upnn3jDblq_CNKRq9hGxnh-NN2upCnjUh1-rSaW5B5XZnJdCHKoFuNGeQTVB1_YFBENzj6i5mttYmwCPbRzm0U-GUiI3M_YY_yi9K3qzVB4BkKVMASjLs-NNTcqDZ5v0_V4K6clFuUgVMxH-O9DNnTN9f7ieTw6fT0XISExzn33wkpiJBQBbtpmb4lpm3yAg\",\"errmsg\":\"ok\",\"expires_in\":7200}\n";
        JSONObject jsonObject = JSONObject.parseObject(s);
        AccessToken accessToken = JSONArray.toJavaObject(jsonObject, AccessToken.class);
        System.out.println(accessToken);
    }


    /*@Test
    public void testSend(){
        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser","260340");
        jsonObject.put("description","<font color=\"info\">绿色消息温度<br>过高呀</font>");
        jsonObject.put("mttf",20);
        jsonObject.put("laster","260340");
        sendMessageService.firstPush(jsonObject);
    }*/

    public static void main(String[] args) {

        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        String s = "<xml><ToUserName><![CDATA[ww189b700b23807b80]]></ToUserName><FromUserName><![CDATA[260340]]></FromUserName><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[taskcard_click]]></Event><CreateTime>1586588652</CreateTime><EventKey><![CDATA[key1]]></EventKey><TaskId><![CDATA[5d8152dd-681e-4eb8-ba15-adbe8f892f96]]></TaskId><AgentId>1000015</AgentId></xml>";
        TaskCardPo s1 = ReplyMsgUtil.xmlStrToPo(s, TaskCardPo.class);
        System.out.println(s1);
    }

    /*@Test
    public  void aaa() throws UnsupportedEncodingException {
        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        //String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect\n";
        System.out.println(auth.getCode());
    }
*/


    /*public void test1(){
        Roster roster = new Roster();
        roster.setMachine("100");
        roster.setMobile("110");
        roster.setUserid("quansa");

    }*/


}
