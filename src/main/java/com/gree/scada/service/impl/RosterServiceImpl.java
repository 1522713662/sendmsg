package com.gree.scada.service.impl;

import com.gree.scada.entity.service.Roster;
import com.gree.scada.entity.service.param.RosterParam;
import com.gree.scada.repository.service.RosterReppsitory;
import com.gree.scada.service.RosterService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: WeChat
 * @CladdName RosterServiceImpl.java
 * @description: 值班信息实现
 * @author: 260340
 * @create: 2020-06-11 19:19
 **/
@Service
public class RosterServiceImpl implements RosterService {

    @Autowired
    RosterReppsitory rosterReppsitory;


    //保存值班 人员信息
    @Override
    public Roster saveRosterInfo(RosterParam param) {

        Roster roster = new Roster();
        //BeanUtils.copyProperties(param,roster);
        //需要判断人员是否存在，取最晚扫描时间人员信息
        return roster;
       //return rosterReppsitory.save(roster);
    }
}
