package com.gezi_rehberim.place_service.kafka.producer;

import com.gezi_rehberim.place_service.dto.response.place.CreatePlaceResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceProducer {

    private final KafkaTemplate<String, CreatePlaceResponse> kafkaTemplate;

    public SearchServiceProducer(KafkaTemplate<String, CreatePlaceResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public void sendMessage(CreatePlaceResponse message) {
        kafkaTemplate.send(defaultTopic, message);
        System.out.println("Sistem Çalışıyor Denemesi : " + message);
    }
}
