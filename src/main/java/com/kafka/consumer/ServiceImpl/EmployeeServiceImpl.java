package com.kafka.consumer.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.DTO.EmployeeDto;
import com.kafka.consumer.Entity.Employee;
import com.kafka.consumer.Repository.EmployeeRepository;
import com.kafka.consumer.Service.EmployeeService;
import com.kafka.consumer.Utils.KafkaConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public EmployeeDto listener(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);
        return employeeDto;
    }
    
}
