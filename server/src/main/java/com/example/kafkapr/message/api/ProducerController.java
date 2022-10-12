package com.example.kafkapr.message.api;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    @Value("${spring.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate kafkaTemplate;

    @GetMapping("/partition/1")
    public void partition1(@RequestParam String content) {
        kafkaTemplate.send(topicName, 0, "0", content);
    }

    @GetMapping("/partition/2")
    public void partition2(@RequestParam String content) {
        kafkaTemplate.send(topicName, 1, "1", content);
    }

    @GetMapping("/partition/3")
    public void partition3(@RequestParam String content) {
        kafkaTemplate.send("test2", content);
    }



}
