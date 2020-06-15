package com.gree.scada.scheduler;

import com.gree.scada.entity.response.TaskCardPo;
import com.gree.scada.repository.TaskCardPoRepository;
import com.gree.scada.repository.service.RosterReppsitory;
import com.gree.scada.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: WeChat
 * @CladdName PushCheck.java
 * @description: 推送消息再次推送检查
 * @author: 260340
 * @create: 2020-04-13 17:18
 **/

@Component
public class PushCheck {

    @Autowired
    TaskCardPoRepository taskCardPoRepository;

    @Autowired
    SendMessageService sendMessageService;



    /**
     * 检查是否再次 推送消息
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void check(){
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        List<TaskCardPo> check = taskCardPoRepository.check();
        if (!check.isEmpty()){
            for (TaskCardPo taskCardPo :check){
                sendMessageService.pushAgain(taskCardPo);
            }
        }
    }
}
