package com.kongheng.spring.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "Student")
@Data
@AllArgsConstructor
public class Student {
  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
}
