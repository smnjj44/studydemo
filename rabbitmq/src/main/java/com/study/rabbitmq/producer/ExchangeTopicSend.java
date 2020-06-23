package com.study.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmq.utils.ConnectionUtil;

/**
 * @author Simon
 * @version 1.0.0
 * @Description 主题模式（通配符模式） au.#可以匹配到au.1.2 au.1，
 * au.*只能匹配到au.1 au2，
 * 一个星星一位数 一个井号代表着通配
 * @ClassName ExchangeTopicSend
 * @date 2020.06.23 16:58
 */
public class ExchangeTopicSend {
    //如果exchange没有绑定队列则会报异常
    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange 默认是持久化保存在硬盘 可以为了加快速度放在内存 但是挂了就丢失数据
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "Hellow World";
        channel.basicPublish(EXCHANGE_NAME, "routekey.1.2.3", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");


        channel.close();
        connection.close();
    }
}
