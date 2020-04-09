package com.gree.scada.util;

import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @program: WeChat
 * @CladdName WeiXinServlet.java
 * @description: 微信服务器
 * @author: 260340
 * @create: 2020-04-08 14:29
 **/
public class WeiXinServlet extends HttpServlet {

    /**
     * 验证url,回调消息请求
     * @param request
     * @param resp
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse resp){
        String requestUrl = request.getRequestURL().toString();// 得到请求的URL地址
        //一、校验URL
        //1.准备校验参数
        // 微信加密签名
        String msgSignature = request.getParameter("signature");
        // 时间戳
        String timeStamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echoStr = request.getParameter("echostr");

        PrintWriter out=null;
        try {
            //2.校验url
            //2.1 创建加解密类
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt("TOKEN","ENCODING_AES_KEY","corpid");
            //2.2进行url校验
            //不抛异常就说明校验成功
            String sEchoStr= wxcpt.VerifyURL(msgSignature, timeStamp, nonce,echoStr);
            //2.3若校验成功，则原样返回 echoStr
            out = resp.getWriter();
            out.print(sEchoStr);
        } catch (AesException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
                out = null;                      //释放资源
            }
        }
    }

    /**
     * 接收消息事件请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解析出xml数据
        String respMessage = ReplyMsgUtil.reply(request);
        //将解析出的数据做判断是否再次推送


        //响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }


}
