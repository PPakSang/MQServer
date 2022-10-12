package com.example.kafkamq.message;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProcessor {

    private final SimpMessagingTemplate template;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.kafka.topic-name}")
    private String topicName;


    @KafkaListener(topics = "${spring.kafka.topic-name}", groupId = "1", containerFactory = "kafkaListenerContainerFactory"
            , topicPartitions = @TopicPartition(topic = "${spring.kafka.topic-name}", partitions = {"0"}))
    public void listen(ConsumerRecord consumerRecord) throws Exception {
        logger.info("listening partition0");
        template.convertAndSend("/topic/test", consumerRecord.value());
    }

    @KafkaListener(topics = "${spring.kafka.topic-name}", groupId = "1", containerFactory = "kafkaListenerContainerFactory"
            , topicPartitions = @TopicPartition(topic = "${spring.kafka.topic-name}", partitions = {"1"}))
    public void listen2(ConsumerRecord consumerRecord) throws Exception {
        logger.info("listening partition1");
        template.convertAndSend("/topic/test", consumerRecord.value());
    }
}
