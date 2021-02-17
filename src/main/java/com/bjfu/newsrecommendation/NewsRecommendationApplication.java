package com.bjfu.newsrecommendation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.bjfu.newsrecommendation.mapper")
@SpringBootApplication
public class NewsRecommendationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsRecommendationApplication.class, args);
    }

}
