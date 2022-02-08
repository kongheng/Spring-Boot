package com.kongheng.spring.jpa.student;

import com.kongheng.spring.jpa.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getStudents() {
    return StudentSupplier.students.get();
  }

  public void saveAll(List<Student> students) {
    studentRepository.saveAll(students);
  }
}
