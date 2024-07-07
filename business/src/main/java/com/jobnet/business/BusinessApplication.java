package com.jobnet.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.jobnet.business",
        "com.jobnet.common.configs",
        "com.jobnet.common.advice",
        "com.jobnet.common.s3",
        "com.jobnet.common.utils",
        "com.jobnet.common.redis"
})
@EnableFeignClients("com.jobnet.clients")
public class BusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
