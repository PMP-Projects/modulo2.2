package br.com.fatec.modulo2_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableRetry
@EnableCaching
@EnableWebSecurity
@EnableMethodSecurity
@SpringBootApplication
public class Modulo21Application {
    public static void main(String[] args) {
        SpringApplication.run(Modulo21Application.class, args);
    }
}