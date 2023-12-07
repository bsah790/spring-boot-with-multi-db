package com.example.demo.mariadb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Column(name = "ADDRESS")
    private String address;
}
