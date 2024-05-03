package com.kafka.consumer.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    
    private String name;
    private LocalDate dob;
    private String company;
    private String employeeId;
}
