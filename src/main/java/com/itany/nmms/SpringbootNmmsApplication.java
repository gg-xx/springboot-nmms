package com.itany.nmms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itany.nmms.dao")
public class SpringbootNmmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNmmsApplication.class, args);
    }

}
