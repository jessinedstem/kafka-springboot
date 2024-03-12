package com.example.edstem.Kafkasprinbootrealtime.KafkaService;

import com.example.edstem.Kafkasprinbootrealtime.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics = "javaguides_json", groupId = "my-group")
    public void consume(User user){
LOGGER.info(String.format("Json message recieved ->%s", user.toString()));
    }
}
