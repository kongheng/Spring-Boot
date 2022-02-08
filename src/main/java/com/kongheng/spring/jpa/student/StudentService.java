package com.kongheng.spring.jpa.student;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  public List<Student> getStudents() {
    return StudentSupplier.students.get();
  }
}
