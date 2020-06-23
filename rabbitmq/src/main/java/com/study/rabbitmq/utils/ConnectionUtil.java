package com.study.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Simon
 * @version 1.0.0
 * @Description
 * @ClassName ConnectionUtil
 * @date 2020.06.18 17:38
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("101.132.75.51");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("testhost");
        factory.setUsername("simon");
        factory.setPassword("123456a");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
