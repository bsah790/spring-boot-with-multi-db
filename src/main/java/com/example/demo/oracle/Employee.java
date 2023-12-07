package com.example.demo.oracle;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @Column(name = "EMP_ID")
    private Integer empId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "DEPARTMENT")
    private String DEPARTMENT;
}
