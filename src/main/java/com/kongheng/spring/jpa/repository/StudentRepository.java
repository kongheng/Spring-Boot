package com.kongheng.spring.jpa.repository;

import com.kongheng.spring.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
