package com.study.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.study.rabbitmq.utils.ConnectionUtil;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


/**
 * @author simonliang
 * @className DelayRecv
 * @description
 * @date 2021/3/15 4:22 下午
 */
public class DelayRecv {

    private final static String QUEUE_NAME_A = "test_queue_work_delay_a";
    private final static String QUEUE_NAME_B = "test_queue_work_delay_b";
    private final static String EXCHANGE_NAME_A = "test_exchange_delay_a";
    private final static String EXCHANGE_NAME_B = "test_exchange_delay_b";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME_A, "fanout");
        channel.exchangeDeclare(EXCHANGE_NAME_B, "fanout");

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME_A, EXCHANGE_NAME_A, "");
        channel.queueBind(QUEUE_NAME_B, EXCHANGE_NAME_B, "");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME_B, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'," + LocalTime.now().toString());
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
