package com.cyj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_routh_cyj",
                r -> r.path("/bilibili")
                        .uri("https://www.bilibili.com/video/BV18E411x7eT?p=70")).build();
        return  routes.build();
        //网关配置，通过访问localhost:9527/bilibili端口就可以访问到这个uri地址
    }

}
