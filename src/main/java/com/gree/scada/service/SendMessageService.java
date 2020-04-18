package com.gree.scada.service;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.entity.response.TaskCardPo;

/**
 * @program: WeChat
 * @CladdName SendMessageService.java
 * @description:
 * @author: 260340
 * @create: 2020-04-13 11:36
 **/
public interface SendMessageService {
    void sendTaskCard(String toUser,String description);
    void firstPush(JSONObject jsonObject);
    void pushAgain(TaskCardPo po);









}
