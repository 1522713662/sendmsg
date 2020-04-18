package com.gree.scada.repository;

import com.gree.scada.entity.response.TaskCardPo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: WeChat
 * @CladdName TaskCardPoRepository.java
 * @description:
 * @author: 260340
 * @create: 2020-04-10 15:25
 **/


//@Repository
public interface TaskCardPoRepository extends JpaRepository<TaskCardPo, ID> {

    @Query(value = "select status FROM push_message where task_id = ?1",nativeQuery = true)
    Integer getStatusByTaskId(String taskId);

    @Query(value = "select * FROM push_message where task_id = ?1", nativeQuery = true)
    TaskCardPo findOneByTaskId(String taskId);

    @Query(value = "select * from push_message where status = 1 and send_time <= DATE_SUB(CURRENT_TIME,interval mttf minute) ",nativeQuery = true)
    List<TaskCardPo> check();
}
