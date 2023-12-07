package com.example.demo.controller;

import com.example.demo.mariadb.User;
import com.example.demo.mariadb.UserRepository;
import com.example.demo.oracle.Employee;
import com.example.demo.oracle.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
       List<Employee> empList =  repository.findAll();
       empList.forEach(System.out::println);
       return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> userList =  userRepository.findAll();
        userList.forEach(System.out::println);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "/employee/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee savesEmp = repository.save(emp);
        return new ResponseEntity<>(savesEmp, HttpStatus.OK);
    }

    @PostMapping(value = "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User SavedUser = userRepository.save(user);
        return new ResponseEntity<>(SavedUser, HttpStatus.OK);
    }
}
