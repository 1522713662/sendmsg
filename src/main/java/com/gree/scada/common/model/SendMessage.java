package com.gree.scada.common.model;

import com.gree.scada.common.po.response.Btn;
import com.gree.scada.common.po.response.TaskCard;
import com.gree.scada.common.po.response.TaskCardPo;
import com.gree.scada.util.RestTemplateUtil;
import com.gree.scada.config.TokenConfig;
import com.gree.scada.config.WeChatData;

import java.util.ArrayList;
import java.util.List;
public class SendMessage {



    /**
     * 模板——发送应用消息(任务卡片)
     * @param toUser
     * @param title
     * @param description
     */
    public void sendTaskCard(String toUser,String title,String description){
        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        TaskCard taskCard = new TaskCard();
        List<Btn> btn = new ArrayList<>();
        btn.add(new Btn());
        taskCard.setBtn(btn);
        taskCard.setTitle(title);
        taskCard.setDescription(description);
        TaskCardPo po = new TaskCardPo();
        po.setTaskcard(taskCard);
        po.setTouser(toUser);
        //拼接请求url
        String url=WeChatData.SEND_URL.replace("ACCESS_TOKEN", TokenConfig.getInstance().token);
        RestTemplateUtil.doPost(url,po);
    }


}
