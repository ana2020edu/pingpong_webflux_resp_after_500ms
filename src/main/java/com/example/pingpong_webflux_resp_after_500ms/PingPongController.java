package com.example.pingpong_webflux_resp_after_500ms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class PingPongController {

    @GetMapping("/ping")
    public Mono<String> ping() throws InterruptedException {
        // Thread.sleep(500); // This is blocking call! java.lang.Thread.sleep
        return Mono.just("pong")
                .delaySubscription(Duration.ofMillis(500));
    }

}
