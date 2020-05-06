package com.study.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://github.com/ctripcorp/apollo/wiki/Quick-Start
 * https://www.jianshu.com/p/23d695af7e80
 */
@EnableApolloConfig
@SpringBootApplication
public class ApolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}

}
