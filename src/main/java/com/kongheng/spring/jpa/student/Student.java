package com.kongheng.spring.jpa.student;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Student")
@Table(
    name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames = "email")
    }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
      columnDefinition = "TEXT"
  )
  private String email;
  @Column(
      name = "dob",
      nullable = false
  )
  private LocalDate dob;
  @Column(
      name = "age",
      nullable = false
  )
  @Transient
  private Integer age;
}
