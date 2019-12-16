package com.ljh;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * MyConifg
 *
 * @author NL-PC001
 * created on 2019/12/16 14:56
 */
@Configuration
public class MyConfig {
    
    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
        
        Settings settings = Settings.builder()
                .put("cluster.name", "wali")
                .build();
        
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        
        return client;
    }
}
