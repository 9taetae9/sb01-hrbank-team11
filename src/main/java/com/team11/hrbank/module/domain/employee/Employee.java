package com.team11.hrbank.module.domain.employee;

import com.team11.hrbank.Department;
import com.team11.hrbank.File;
import com.team11.hrbank.module.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

  @NotNull
  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @NotNull
  @Column(name = "email", nullable = false)
  private String email;

  @NotNull
  @Column(name = "employee_number", nullable = false, length = 25)
  private String employeeNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.RESTRICT)
  @JoinColumn(name = "department_id")
  private Department department;

  @NotNull
  @Column(name = "\"position\"", nullable = false, length = 50)
  private String position;

  @NotNull
  @Column(name = "hire_date", nullable = false)
  private Instant hireDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "profile_image_id")
  private File profileImage;

  @ColumnDefault("'ACTIVE'")
  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private EmployeeStatus status;
}