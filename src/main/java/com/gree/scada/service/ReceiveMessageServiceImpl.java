package com.gree.scada.service;

import com.gree.scada.entity.request.ReceiveTaskCardPo;
import com.gree.scada.entity.response.TaskCardPo;
import com.gree.scada.repository.TaskCardPoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: WeChat
 * @CladdName ReceiveMessage.java
 * @description: 接收回调消息
 * @author: 260340
 * @create: 2020-04-08 14:10
 **/
@Service
public class ReceiveMessageServiceImpl {

    @Autowired
    TaskCardPoRepository taskCardPoRepository;


    /**
     * 接收事件消息设置状态值
     */
    public void judgeState(ReceiveTaskCardPo po){
        TaskCardPo taskCardPo = taskCardPoRepository.findOneByTaskId(po.getTaskId());
        if ( taskCardPo !=null){
            taskCardPo.setStatus(0);
            taskCardPo.setOperator(po.getFromUserName());
            //taskCardPo.setEndTime(po.getCreateTime());
            taskCardPoRepository.save(taskCardPo);
            System.out.println("保存修改"+taskCardPo);
        }
    }




}
