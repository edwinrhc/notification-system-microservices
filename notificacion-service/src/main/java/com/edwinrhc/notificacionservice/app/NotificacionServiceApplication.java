package com.edwinrhc.notificacionservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient ya no es necesario en las últimas versiones de Spring Cloud
public class NotificacionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionServiceApplication.class, args);
    }

}
