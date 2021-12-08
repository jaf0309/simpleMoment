package com.simplemoment.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 聊天服务提供者
 *
 * @author simplemoment
 * @date 2020/12/7
 */
@SpringBootApplication
public class ChatProviderApplication {

    public static void main(String[] args) {
        new SpringApplication(ChatProviderApplication.class).run(args);
    }

}