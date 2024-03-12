package com.example.edstem.Kafkasprinbootrealtime.controller;

import com.example.edstem.Kafkasprinbootrealtime.KafkaService.JsonKafkaProducer;
import com.example.edstem.Kafkasprinbootrealtime.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class jsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    public jsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }
}
