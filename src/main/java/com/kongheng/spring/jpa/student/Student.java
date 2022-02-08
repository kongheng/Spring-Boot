package com.kongheng.spring.jpa.student;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
  private Long id;
  private String name;
  private String email;
  private LocalDate dob;
  private Integer age;
}
