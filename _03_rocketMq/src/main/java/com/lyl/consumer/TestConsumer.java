package com.lyl.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Desc:
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/02/06
 */

public class TestConsumer {
    public static void main(String[] args) throws Exception {
        // 创建消费者实例，并设置消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup1");
        // 设置 Name Server 地址，此处为示例，实际使用时请替换为真实的 Name Server 地址
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅指定的主题和标签（* 表示所有标签）
        consumer.subscribe("localSystem", "*");

        // 注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(msg);
                    System.out.println("Received message: " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者
        consumer.start();
        System.out.println("Consumer started.");
    }
}
