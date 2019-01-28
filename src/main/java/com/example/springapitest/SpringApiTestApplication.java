package com.example.springapitest;

import com.example.springapitest.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class SpringApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiTestApplication.class, args);
    }

}

