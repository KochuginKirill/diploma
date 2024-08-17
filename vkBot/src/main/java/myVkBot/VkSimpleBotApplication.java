package myVkBot;

import myVkBot.service.WebStoreRestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VkSimpleBotApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(VkSimpleBotApplication.class, args);
        WebStoreRestService service = ctx.getBean(WebStoreRestService.class);
        System.out.println(service.findAll());

    }
}