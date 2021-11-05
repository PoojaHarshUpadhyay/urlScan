package com.urlscan.urlscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class UrlscanApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlscanApplication.class, args);
    }

}
