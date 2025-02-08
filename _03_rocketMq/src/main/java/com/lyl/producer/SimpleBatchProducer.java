package com.lyl.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:需要注意的是批量消息的大小不能超过 1MiB（否则需要自行分割），其次同一批 batch 中 topic 必须相同。
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/02/08 09:00:04
 */
public class SimpleBatchProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("localSystem-producer-group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        String topic = "localSystem";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
        messages.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
        messages.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));

        SendResult sendResult = producer.send(messages);
        System.out.println("Send result: " + sendResult);

        producer.shutdown();
    }
}
