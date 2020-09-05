package com.nextsky.junitdemo.area;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RestController
public class HomeController {
    @GetMapping("/demo-rest")
    public String demoRestCall(){
        String response = WebClient.builder()
                .build()
                .get()
                .uri("http://localhost:8082/comment/list")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}
