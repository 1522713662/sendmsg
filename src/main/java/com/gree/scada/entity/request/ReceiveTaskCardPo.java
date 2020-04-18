package com.gree.scada.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReceiveTaskCardPo {

    private String ToUserName;

    private String FromUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp CreateTime;

    private String MsgType;

    private String Event;

    private String EventKey;

    private String TaskId;

    private Integer AgentId;

}
