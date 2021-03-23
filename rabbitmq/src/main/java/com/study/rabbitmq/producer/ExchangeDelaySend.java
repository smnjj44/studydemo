package com.study.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmq.utils.ConnectionUtil;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author simonliang
 * @className ExchangeDelaySend
 * @description 延迟队列
 * @date 2021/3/15 4:02 下午
 */
public class ExchangeDelaySend {
    private final static String QUEUE_NAME_A = "test_queue_work_delay_a";
    private final static String QUEUE_NAME_B = "test_queue_work_delay_b";
    private final static String EXCHANGE_NAME_A = "test_exchange_delay_a";
    private final static String EXCHANGE_NAME_B = "test_exchange_delay_b";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        Map<String, Object> queConfig = new HashMap<String, Object>();
        queConfig.put("x-message-ttl", 10000);
        queConfig.put("x-dead-letter-exchange",EXCHANGE_NAME_B);
        channel.queueDeclare(QUEUE_NAME_A, false, false, false, queConfig);
        channel.queueDeclare(QUEUE_NAME_B, false, false, false, null);


        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME_A, "fanout");
        channel.exchangeDeclare(EXCHANGE_NAME_B, "fanout");



        // 消息内容
        for (int i = 0; i < 100; i++) {
            String message = "我是" + i +"的消息,"+ LocalTime.now().toString();
            channel.basicPublish(EXCHANGE_NAME_A, "", null, message.getBytes());
            System.out.println(" [x] Send '" + message + "'");
        }
        channel.close();
        connection.close();

    }
}
