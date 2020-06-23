package com.study.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmq.utils.ConnectionUtil;

/**
 * @author Simon
 * @version 1.0.0
 * @Description 路由模式 相当于给消息打上标志
 * @ClassName ExchangeDirectSend
 * @date 2020.06.23 16:28
 */
public class ExchangeDirectSend {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange 默认是持久化保存在硬盘 可以为了加快速度放在内存 但是挂了就丢失数据
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 消息内容
        String message = "我是1的消息";
        channel.basicPublish(EXCHANGE_NAME, "1", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        message = "我是2的消息";
        channel.basicPublish(EXCHANGE_NAME, "2", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
