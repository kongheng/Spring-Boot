package com.kongheng.spring.jpa.student;

import com.kongheng.spring.jpa.repository.StudentRepository;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getStudents() {
    return studentRepository.findAll().stream()
        .map(this::mapStudent)
        .collect(Collectors.toList());
  }

  private Student mapStudent(Student student) {
    return Student.builder()
        .id(student.getId())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .dob(student.getDob())
        .age(Period.between(student.getDob(), LocalDate.now()).getYears())
        .build();
  }

  public void saveAll(List<Student> students) {
    studentRepository.saveAll(students);
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("Email taken");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      throw new IllegalStateException("Student with id " + studentId + "does not exists");
    }
    studentRepository.deleteById(studentId);
  }
}
