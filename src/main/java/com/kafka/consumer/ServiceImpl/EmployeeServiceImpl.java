package com.kafka.consumer.ServiceImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.DTO.EmployeeDto;
import com.kafka.consumer.Service.EmployeeService;
import com.kafka.consumer.Utils.KafkaConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public EmployeeDto listener(EmployeeDto employeeDto) {
        //emprepo.save(employeeDto);    //will accept entity type data... have to copy properties.
        return employeeDto;
    }
    
}
