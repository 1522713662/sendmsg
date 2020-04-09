package com.gree.scada.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.common.po.request.ReceiveTaskCardPo;
import com.gree.scada.common.po.response.TaskCardPo;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import net.sf.json.xml.XMLSerializer;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @program: WeChat
 * @CladdName ReplyMsgUtil.java
 * @description: 被动消息回复工具
 * @author: 260340
 * @create: 2020-04-08 15:04
 **/
public class ReplyMsgUtil {

    /**
     * 接收消息事件请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static JSONObject getPostData(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解析出xml数据
        String respMessage = ReplyMsgUtil.reply(request);
        JSONObject jsonObject= JSONObject.parseObject(respMessage);
        System.out.println(jsonObject);
        return jsonObject;
    }


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
            //1.获取加密的请求消息：使用输入流获得加密请求消息postData
            ServletInputStream in = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tempStr = "";   //作为输出字符串的临时串，用于判断是否读取完毕
            while (null != (tempStr = reader.readLine())) {
                postData += tempStr;
            }
                WXBizMsgCrypt wxcpt = null;
                try {
                    wxcpt = new WXBizMsgCrypt("token", "ENCODING_AES_KEY", "CPROPID");
                    result = xmlToObj(wxcpt.DecryptMsg(msgSignature, timeStamp, nonce, postData));
                } catch (AesException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * xml字符串转 JSONObject
     *
     * @param xml
     * @return
     */
    public static String xmlToObj(String xml){
        XMLSerializer xmlSerializer = new XMLSerializer();
        String resultStr = xmlSerializer.read(xml).toString();
        System.out.println(resultStr);
        return resultStr;
    }

    /**
     * json转对象
     *
     * @param jsonObject
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T  jsonToPo(JSONObject jsonObject,Class<T> tClass){
        //ReceiveTaskCardPo receiveTaskCardPo = new ReceiveTaskCardPo();
        T po = (T) JSON.toJavaObject(jsonObject, tClass);
        return po;

    }

}
