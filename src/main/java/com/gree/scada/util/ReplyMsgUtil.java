package com.gree.scada.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.WeChatData;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import net.sf.json.xml.XMLSerializer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @program: WeChat
 * @CladdName ReplyMsgUtil.java
 * @description: 被动消息回复工具
 * @author: 260340
 * @create: 2020-04-08 15:04
 **/
public class ReplyMsgUtil {

    /**
     * @desc ：获取回复消息并解密
     *
     * @param request
     * @return
     *   String 解密后xml字符串
     */
    public static String reply( HttpServletRequest request ) {
        String result= "";
        String postData= "";
        //解密：从request中获取消息明文
        String msgSignature = request.getParameter("msg_signature"); // 微信加密签名
        String timeStamp = request.getParameter("timestamp");   // 时间戳
        String nonce = request.getParameter("nonce");          // 随机数
        try {
            //获取加密的请求消息：使用输入流获得加密请求消息postData
            ServletInputStream in = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tempStr = "";   //作为输出字符串的临时串，用于判断是否读取完毕
            while (null != (tempStr = reader.readLine())) {
                postData += tempStr;
            }
                WXBizMsgCrypt wxcpt = null;
                try {
                    wxcpt = new WXBizMsgCrypt(WeChatData.token, WeChatData.encodingAESKey,WeChatData.corpid);
                    result = wxcpt.DecryptMsg(msgSignature, timeStamp, nonce, postData);

                } catch (AesException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * xmlStr串转 JSONObject
     *
     * @param xml
     * @return
     */
    public static JSONObject xmlStrToObj(String xml){
        XMLSerializer xmlSerializer = new XMLSerializer();
        String resultStr = xmlSerializer.read(xml).toString();
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        System.out.println(jsonObject);
        return jsonObject;
    }


    /**
     * xmlStr串转 java po
     *
     * @param xml
     * @return
     */
    public static<T> T xmlStrToPo(String xml,Class<T> tClass){
        XMLSerializer xmlSerializer = new XMLSerializer();
        String resultStr = xmlSerializer.read(xml).toString();
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        System.out.println(resultStr);
        T po = JSONArray.parseObject(String.valueOf(jsonObject), tClass);
        return po;
    }


}
