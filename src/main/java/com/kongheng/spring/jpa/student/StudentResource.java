package com.kongheng.spring.jpa.student;

import java.time.LocalDate;
import java.time.Month;

public class StudentResource {
  public static Student mariam = Student.builder()
      .id(1L)
      .name("Mariam")
      .email("mariam.jamal@gmail.com")
      .dob(LocalDate.of(2000, Month.JANUARY, 5))
      .age(21)
      .build();
  public static Student anna = Student.builder()
      .id(2L)
      .name("Anna")
      .email("anna.smith@gmail.com")
      .dob(LocalDate.of(2005, Month.SEPTEMBER, 5))
      .age(21)
      .build();
  public static final Student jame = Student.builder()
      .id(3L)
      .name("Jame")
      .email("jame.bone@gmail.com")
      .dob(LocalDate.of(1995, Month.APRIL, 7))
      .age(26)
      .build();
}
