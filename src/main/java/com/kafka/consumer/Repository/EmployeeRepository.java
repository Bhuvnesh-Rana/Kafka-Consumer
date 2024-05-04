package com.kafka.consumer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.consumer.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
