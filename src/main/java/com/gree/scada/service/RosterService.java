package com.gree.scada.service;

import com.gree.scada.entity.service.Roster;
import com.gree.scada.entity.service.param.RosterParam;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: WeChat
 * @CladdName RosterService.java
 * @description: 值班信息
 * @author: 260340
 * @create: 2020-06-11 19:16
 **/
public interface RosterService {

    Roster saveRosterInfo(RosterParam param);
}
