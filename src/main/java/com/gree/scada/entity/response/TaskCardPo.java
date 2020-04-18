package com.gree.scada.entity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: WeChat
 * @CladdName TaskCardPo.java
 * @description: 任务卡片信息
 * @author: 260340
 * @create: 2020-03-28 15:25
 **/
@Data
@Entity
@Table(name = "push_message",schema = "weixin")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EntityListeners(AuditingEntityListener.class)
public class TaskCardPo implements Serializable {

    private static final long serialVersionUID = 1L;


    //@GenericGenerator(name = "idGenerator", strategy = "uuid")
    //@GeneratedValue(generator = "idGenerator")
    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 否 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
    @Column(name = "touser")
    private String touser;

    // 否 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
    @Column(name = "toparty")
    private String toparty;

    // 否 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
    @Column(name = "totag")
    private String totag;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "operator")
    private String operator;

    @Column(name = "task_id", nullable = false)
    private String taskId ;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "send_time")
    private Timestamp sendTime;

    @Column(name = "end_time")
    @LastModifiedDate
    private Timestamp endTime;

    @Column(name = "status", nullable = false)
    private Integer status;

    //间隔时间
    @Column(name = "mttf")
    private Integer mttf;

    @Column(name = "laster")
    private String laster;

    /*@Transient
    private TaskCard taskcard;*/

   /* @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Data getSendTime() {
        return sendTime;
    }

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }*/
}
