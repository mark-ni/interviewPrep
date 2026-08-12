package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public RestClient githubClient() {
        return RestClient.builder()
                .baseUrl("https://api.github.com")
                .build();
    }

    @Bean
    public RestClient countryClient() {
        return RestClient.builder()
                .baseUrl("https://api.restcountries.com/countries/v5")
                .build();
    }
}
