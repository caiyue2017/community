package com.whynotyue.community.event;

import com.alibaba.fastjson.JSONObject;
import com.whynotyue.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/*
@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 触发事件
    public void fireEvent(Event event) {
        // 将事件发送到指定的主题
        // event 转换为 JSON，进行传输
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
*/
