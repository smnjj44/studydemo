package com.study.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.study.rabbitmq.utils.ConnectionUtil;

/**
 * @author Simon
 * @version 1.0.0
 * @Description  channel相当于通道电线 角色：producer queue chanel consumer
 *              (work模式)轮询分发-每个消费者从队列都拿到同样数目的数据 不受每个消费者速度影响
 *              (work模式)公平分发-多劳多得
 * @ClassName RoundRobinRecv2
 * @date 2020.06.23 15:34
 */
public class RoundRobinRecv2 {    private final static String QUEUE_NAME = "q_test_01";

    /**
     * channel.basicQos(1);channel.basicConsume(QUEUE_NAME, false, consumer);channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
     * 配置好注解的这几个可以开启公平模式 哪个队列basicAck返回一个响应就推送一个，所以谁处理得多就推送得多
     * @param argv
     * @throws Exception
     */
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        // 同一时刻服务器只会发一条消息给消费者
        // channel.basicQos(1);
        // channel.basicConsume(QUEUE_NAME, false, consumer);


        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(100);
            //开启这行 表示使用手动确认模式
            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
