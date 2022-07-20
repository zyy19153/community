package com.nowcoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Hide on bush
 * @since 2022/7/20 - 17:08
 */
@Component
public class EventProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    // 处理事件
    public void fireEvent(Event event) {
        // 将事件发送到指定的主题
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}