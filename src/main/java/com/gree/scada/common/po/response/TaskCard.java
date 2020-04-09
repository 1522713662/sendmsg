package com.gree.scada.common.po.response;

import com.gree.scada.common.po.response.Btn;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @program: WeChat
 * @CladdName TaskCard.java
 * @description: 任务卡片
 * @author: 260340
 * @create: 2020-03-28 14:55
 **/
@Data
public class TaskCard{
    private String title;
    private String description;
    private String task_id = UUID.randomUUID().toString();
    //private List<JsonObject> btn;
    private List<Btn> btn;
}
