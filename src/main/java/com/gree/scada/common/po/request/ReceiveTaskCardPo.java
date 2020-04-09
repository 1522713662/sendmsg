package com.gree.scada.common.po.request;

import lombok.Data;

@Data
public class ReceiveTaskCardPo {

    private String ToUserName;

    private String FromUserName;

    private String CreateTime;

    private String MsgType;

    private String Event;

    private String EventKey;

    private String TaskId;

    private Integer AgentId;

}
