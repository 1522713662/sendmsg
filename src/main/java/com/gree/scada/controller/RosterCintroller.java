package com.gree.scada.controller;

import com.gree.scada.entity.common.ResultEntity;
import com.gree.scada.entity.service.Roster;
import com.gree.scada.entity.service.param.RosterParam;
import com.gree.scada.repository.service.RosterReppsitory;
import com.gree.scada.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: WeChat
 * @CladdName RosterCintroller.java
 * @description: 值班人员
 * @author: 260340
 * @create: 2020-06-11 19:37
 **/
@RestController
@CrossOrigin
@RequestMapping("/roster")
public class RosterCintroller {

    @Autowired
    RosterService rosterService;

    @PostMapping("/create")
    public ResultEntity create(@RequestBody RosterParam param){
        return ResultEntity.success(rosterService.saveRosterInfo(param));
    }




}
