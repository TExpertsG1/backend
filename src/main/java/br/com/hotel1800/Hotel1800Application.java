package br.com.hotel1800;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Hotel1800Application {

    public static void main(String[] args) {
        SpringApplication.run(Hotel1800Application.class, args);
    }

}