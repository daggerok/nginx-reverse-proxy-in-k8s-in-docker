package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.accepted;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class WebApp {

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route().POST("/{name}", request -> accepted().body(
                Mono.just(singletonMap("hola", request.pathVariable("name"))), Map.class))
                      .build()
                      .andRoute(path("/**"),
                                request -> ok().body(Mono.justOrEmpty(singletonMap("hello", "world")),
                                                     Map.class));
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
