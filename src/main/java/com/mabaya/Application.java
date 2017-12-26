package com.mabaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.mabaya")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
