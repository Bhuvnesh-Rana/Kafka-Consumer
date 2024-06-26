package com.kafka.consumer.Configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafka.consumer.DTO.EmployeeDto;
import com.kafka.consumer.Utils.KafkaConstants;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    
    public ConsumerFactory<String, EmployeeDto> consumerFactory(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(EmployeeDto.class,false));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EmployeeDto> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, EmployeeDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
