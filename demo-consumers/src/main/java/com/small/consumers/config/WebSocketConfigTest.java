package com.small.consumers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/*@Configuration
@EnableWebSocket
public class WebSocketConfigTest implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(marcoHandler(), "/webSocket/**").setAllowedOrigins("http://localhost:9003");
    }

    @Bean
    public WebSocketHandler marcoHandler() {
        return  new MyHandler();
    }

}*/
