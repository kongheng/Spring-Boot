package com.kongheng.spring.jpa.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Autowired
  private StudentService studentService;

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> studentService.saveAll(StudentSupplier.students.get());
  }
}
