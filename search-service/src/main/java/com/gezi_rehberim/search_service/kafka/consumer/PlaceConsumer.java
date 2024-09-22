package com.gezi_rehberim.search_service.kafka.consumer;

import com.gezi_rehberim.search_service.document.Place;
import com.gezi_rehberim.search_service.service.abstracts.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceConsumer {

    private final PlaceService placeService;
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void createConsumer(ConsumerRecord<String, Place> payload) {
        placeService.createPlace(payload.value());
        System.out.println("Consumer tarafından mesaj alındı  : " + payload.value());
    }
}
