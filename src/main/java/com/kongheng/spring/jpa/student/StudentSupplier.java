package com.kongheng.spring.jpa.student;

import static com.kongheng.spring.jpa.student.StudentResource.anna;
import static com.kongheng.spring.jpa.student.StudentResource.jame;
import static com.kongheng.spring.jpa.student.StudentResource.mariam;

import java.util.List;
import java.util.function.Supplier;

public class StudentSupplier {
  public static Supplier<List<Student>> students = () -> List.of(
      mariam,
      anna,
      jame
  );
}
