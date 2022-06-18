package com.kongheng.spring.jpa;

import com.kongheng.spring.jpa.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
