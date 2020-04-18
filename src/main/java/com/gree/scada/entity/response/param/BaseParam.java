/*
package com.gree.scada.entity.response.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

*/
/**
 * @program: WeChat
 * @CladdName BaseParam.java
 * @description: 消息基础类
 * @author: 260340
 * @create: 2020-04-10 10:28
 **//*

@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseParam implements Serializable {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "send_time" , nullable = false)
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String sendTime;

    @Column(name = "end_time" , nullable = false)
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String endTime;

    @Column(name = "status")
    private Integer status;
}
*/
