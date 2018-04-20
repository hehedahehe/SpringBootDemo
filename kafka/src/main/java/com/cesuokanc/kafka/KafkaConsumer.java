package com.cesuokanc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
 * @desc
 * @author lirb
 * @datetime 2018/4/7,15:41
 */
@Slf4j
@Component
public class KafkaConsumer {
    /**
     * 监听test主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"test"})
    public void consumer(String message){
        log.info("test topic message : {}", message);
    }
}
