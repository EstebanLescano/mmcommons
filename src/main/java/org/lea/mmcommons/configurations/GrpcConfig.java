package org.lea.mmcommons.configurations;

import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Value("${grpc.mmuser.host}")
    private String host;

    @Value("${grpc.mmuser.port}")
    private int port;

    @Bean
    public ManagedChannel mmuserChannel() {
        return NettyChannelBuilder.forAddress(host, port)
                .usePlaintext() // En producción, usa TLS
                .build();
    }
}
