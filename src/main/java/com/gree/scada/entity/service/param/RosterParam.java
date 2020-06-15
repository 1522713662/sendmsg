package com.gree.scada.entity.service.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: WeChat
 * @CladdName Roster.java
 * @description: 值班人员表
 * @author: 260340
 * @create: 2020-06-11 18:56
 **/
@Data
public class RosterParam {

    private String userid;


    private String name;


    private String mobile;


    private String department;
    //private List<Integer> department;


    private String position;


    private Integer status;


    private Integer work;


    private String machine;


    private Integer active;


}
