package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer managerId;
    private String department;
}
