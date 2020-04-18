package com.gree.scada.entity.response.param;

import com.gree.scada.config.WeChatData;
import lombok.Data;

/**
 * @program: WeChat
 * @CladdName TaskCardPo.java
 * @description: 任务卡片信息
 * @author: 260340
 * @create: 2020-03-28 15:25
 **/
@Data
public class TaskCardPoParam {
    // 否 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
    private String touser;
    // 否 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
    private String toparty;
    // 否 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
    private String totag;
    private String agentid = WeChatData.agentid;
    private String msgtype = "taskcard";
    private TaskCard taskcard;
}
