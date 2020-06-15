package com.gree.scada.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @program: WeChat
 * @CladdName Roster.java
 * @description: 值班人员表
 * @author: 260340
 * @create: 2020-06-11 18:56
 **/
@Data
@Entity
public class Roster implements Serializable {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userid;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    //@ElementCollection
    @Column(name = "department")
    private String department;
    //private List<Integer> department;

    @Column(name = "position")
    private String position;

    @Column(name = "status")
    private Integer status;

    @Column(name = "work")
    private Integer work;

    @Column(name = "machine")
    private String machine;

    @Column(name = "active")
    private Integer active;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Timestamp create_time;

}
