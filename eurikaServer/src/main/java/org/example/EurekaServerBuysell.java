package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class EurekaServerBuysell {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaServerBuysell.class);
    }
}