package com.gree.scada.repository.service;

import com.gree.scada.entity.service.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: WeChat
 * @CladdName RosterReppsitory.java
 * @description: 当次值班信息
 * @author: 260340
 * @create: 2020-06-11 19:09
 **/
public interface RosterReppsitory extends JpaRepository<Roster,Integer> {
    

}
