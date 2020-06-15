package com.gree.scada.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.WeChatData;
import com.gree.scada.entity.request.ReceiveTaskCardPo;
import com.gree.scada.service.impl.ReceiveMessageServiceImpl;
import com.gree.scada.util.ReplyMsgUtil;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/weChat")
public class ReceiveMessageController {

    @Autowired
    ReceiveMessageServiceImpl receiveMessageService;

    /**
     * 验证url
     * @param request
     * @param resp
     */
    @GetMapping
    public void verifyURL(HttpServletRequest request, HttpServletResponse resp){
        //1.准备校验参数
        // 微信加密签名
        String msgSignature = request.getParameter("msg_signature");
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
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WeChatData.token, WeChatData.encodingAESKey,WeChatData.corpid);
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
     * 接收消息,事件请求
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping
    public void receiveMsg(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解析出xml数据
        String respMessage = ReplyMsgUtil.reply(request);
        System.out.println(respMessage);
        JSONObject jsonObject = ReplyMsgUtil.xmlStrToObj(respMessage);

        String type = jsonObject.getString("Event");
        if (type.equals("taskcard_click") ){
            ReceiveTaskCardPo receiveTaskCardPo = JSONArray.parseObject(String.valueOf(jsonObject), ReceiveTaskCardPo.class);
            //ReceiveTaskCardPo receiveTaskCardPo = ReplyMsgUtil.xmlStrToPo(respMessage,ReceiveTaskCardPo.class);
            System.out.println("接收响应"+receiveTaskCardPo);
            receiveMessageService.judgeState(receiveTaskCardPo);
        }
    }

}
