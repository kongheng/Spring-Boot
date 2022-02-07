package com.kongheng.spring.jpa.Model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "Student")
@Data
@AllArgsConstructor
public class Student {
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = SEQUENCE,
      generator = "student_sequence"
  )
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
}
