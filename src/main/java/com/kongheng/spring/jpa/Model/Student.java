package com.kongheng.spring.jpa.Model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
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
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "first_name",
      nullable = false,
      columnDefinition = "TEXT"
  )
  private String firstName;
  @Column(
      name = "last_name",
      nullable = false,
      columnDefinition = "TEXT"
  )
  private String lastName;
  @Column(
      name = "email",
      nullable = false,
      columnDefinition = "TEXT",
      unique = true
  )
  private String email;
  @Column(
      name = "age",
      nullable = false
  )
  private Integer age;
}
