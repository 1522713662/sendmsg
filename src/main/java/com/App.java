package com;


import com.gree.scada.config.VerifyThread;
import com.gree.scada.config.WeChatData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.gree.scada.*"})
@EnableJpaAuditing
@EnableScheduling
public class App {
    public static void main(String[] args) {
        WeChatData weChatData = new WeChatData();
        weChatData.initProperties();
        new Thread(new VerifyThread()).start();
        SpringApplication.run(App.class,args);
    }
}
