package com.kongheng.spring.jpa;

import com.kongheng.spring.jpa.model.Student;
import com.kongheng.spring.jpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> studentRepository.save(
				Student.builder()
				.firstName("Long")
				.lastName("Kongheng")
				.email("kongheng.long@gmail.com")
				.age(26)
				.build()
		);
	}

}
