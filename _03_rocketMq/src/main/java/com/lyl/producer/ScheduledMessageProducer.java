package com.lyl.producer;

import com.lyl.enums.DelayLevelEnum;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * Desc:
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/02/08 08:41:32
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {
        // Instantiate a producer to send scheduled messages
        DefaultMQProducer producer = new DefaultMQProducer("localSystem-producer-group");
        // Launch producer
        producer.setSendMsgTimeout(15000);
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("localSystem", ("Hello scheduled message " + i).getBytes());
            // This message will be delivered to consumer 10 seconds later.
            message.setDelayTimeLevel(DelayLevelEnum.LEVEL_3.getLevel());
            // Send the message
            SendResult sendResult = producer.send(message);
            System.out.println("Send result: " + sendResult);
        }

        // Shutdown producer after use.
        producer.shutdown();
    }

}
