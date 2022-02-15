package com.kongheng.spring.jpa.security;

import static com.kongheng.spring.jpa.security.ApplicationUserPermission.COURSE_READ;
import static com.kongheng.spring.jpa.security.ApplicationUserPermission.COURSE_WRITE;
import static com.kongheng.spring.jpa.security.ApplicationUserPermission.STUDENT_READ;
import static com.kongheng.spring.jpa.security.ApplicationUserPermission.STUDENT_WRITE;

import com.google.common.collect.Sets;
import java.util.Set;

public enum ApplicationUserRole {
  STUDENT(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

  private final Set<ApplicationUserPermission> permissions;


  ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }
}
