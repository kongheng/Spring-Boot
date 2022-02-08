package com.kongheng.spring.jpa.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping(path = "/students")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }
}
