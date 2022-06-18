package com.kongheng.spring.jpa.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/management/api/student")
public class StudentManagementController {

  @Autowired
  private StudentService studentService;

  @GetMapping(path = "/list")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN, 'ROLE_ADMIN_TRAINEE')")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping("/register")
  @PreAuthorize("hasAuthority('student:write')")
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateStudent(Long studentId, @RequestBody Student student) {
    studentService.updateStudent(
        studentId,
        student.getFirstName(),
        student.getLastName(),
        student.getEmail());
  }
}
