package com.study.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmq.utils.ConnectionUtil;

/**
 * @author Simon
 * @version 1.0.0
 * @Description 轮询、公平模式生产者
 * @ClassName RoundRobinSend
 * @date 2020.06.22 16:33
 */
public class RoundRobinSend {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception {
            // 获取到连接以及mq通道
            Connection connection = ConnectionUtil.getConnection();
            // 从连接中创建通道
            Channel channel = connection.createChannel();

            // 声明（创建）队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // 消息内容
        for (int i = 0; i < 100; i++) {
            String message = "我是"+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
            //关闭通道和连接
            channel.close();
            connection.close();

    }
}
