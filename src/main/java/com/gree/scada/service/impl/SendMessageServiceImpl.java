package com.gree.scada.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.VerifyThread;
import com.gree.scada.config.WeChatData;
import com.gree.scada.entity.response.TaskCardPo;
import com.gree.scada.entity.response.param.Btn;
import com.gree.scada.entity.response.param.TaskCard;
import com.gree.scada.entity.response.param.TaskCardPoParam;
import com.gree.scada.repository.TaskCardPoRepository;
import com.gree.scada.service.SendMessageService;
import com.gree.scada.util.RestTemplateUtil;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SendMessageServiceImpl implements SendMessageService {


    @Autowired
    TaskCardPoRepository taskCardPoRepository;



    //第一次推送
    /**
     * 模板——发送应用消息(任务卡片)
     * @param jsonObject
     */
    @Override
    public void firstPush(JSONObject jsonObject ){
        String toUser = jsonObject.getString("touser");
        String description=jsonObject.getString("description");
        TaskCard taskCard = new TaskCard();
        List<Btn> btn = new ArrayList<>();
        btn.add(new Btn());
        taskCard.setBtn(btn);
        taskCard.setDescription(description);
        TaskCardPoParam po = new TaskCardPoParam();
        po.setTaskcard(taskCard);
        po.setTouser(toUser);
        //拼接请求url
        String url=WeChatData.SEND_URL.replace("ACCESS_TOKEN", VerifyThread.accessToken.getToken());
        //推送警告
        RestTemplateUtil.doPost(url, po);
        TaskCardPo taskCardPo = JSONArray.parseObject(String.valueOf(jsonObject), TaskCardPo.class);
        taskCardPo.setTaskId(taskCard.getTask_id());
        taskCardPo.setStatus(1);
        taskCardPoRepository.save(taskCardPo);

    }

    //再次推送
    @Override
    public void pushAgain(TaskCardPo findOne){
        TaskCard taskCard = new TaskCard();
        List<Btn> btn = new ArrayList<>();
        btn.add(new Btn());
        taskCard.setBtn(btn);
        taskCard.setDescription(findOne.getDescription());
        //taskCard.setTask_id(findOne.getTaskId());
        TaskCardPoParam po = new TaskCardPoParam();
        po.setTaskcard(taskCard);
        po.setTouser(findOne.getLaster());
        //拼接请求url
        String url=WeChatData.SEND_URL.replace("ACCESS_TOKEN", VerifyThread.accessToken.getToken());
        //再次推送警告
        RestTemplateUtil.doPost(url, po);
        findOne.setStatus(2);
        //重置第二次task_id
        findOne.setTaskId(taskCard.getTask_id());
        taskCardPoRepository.save(findOne);
    }
}
