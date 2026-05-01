package com.raulcrespo.ecommerce.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.raulcrespo.ecommerce.pedidos.client")
public class ClientsConfig {
}
