package com.gree.scada.common.po.response;

import lombok.Data;

/**
 * @program: WeChat
 * @CladdName TaskCardPo.java
 * @description: 任务卡片信息
 * @author: 260340
 * @create: 2020-03-28 15:25
 **/
@Data
public class TaskCardPo{
    private String touser;
    private String totag;
    private String toparty;
    private String agentid = "1000015";
    private String msgtype = "taskcard";
    private TaskCard taskcard;
}
