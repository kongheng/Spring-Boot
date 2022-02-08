package com.kongheng.spring.jpa.student;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class StudentResource {
  public static Student mariam = Student.builder()
      .firstName("Mariam")
      .lastName("Jamal")
      .email("mariam.jamal@gmail.com")
      .dob(LocalDate.of(2000, Month.JANUARY, 5))
      .age(Period.between(LocalDate.of(2000, Month.JANUARY, 5), LocalDate.now()).getYears())
      .build();
  public static Student anna = Student.builder()
      .firstName("Anna")
      .lastName("Smith")
      .email("anna.smith@gmail.com")
      .dob(LocalDate.of(2005, Month.SEPTEMBER, 5))
      .age(Period.between(LocalDate.of(2005, Month.SEPTEMBER, 5), LocalDate.now()).getYears())
      .build();
  public static final Student jame = Student.builder()
      .firstName("Jame")
      .lastName("Bone")
      .email("jame.bone@gmail.com")
      .dob(LocalDate.of(1995, Month.APRIL, 7))
      .age(Period.between(LocalDate.of(1995, Month.APRIL, 7), LocalDate.now()).getYears())
      .build();
}
