package com.example.demo;

import com.example.demo.mariadb.User;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource dataSource1;

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource dataSource2;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1);
		String query ="select * from employee";
		List<Employee> empList = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Employee.class));
		empList.forEach(System.out::println);

		JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource2);
		String query1 ="SELECT * FROM USER";
		List<User> userList = jdbcTemplate1.query(query1, BeanPropertyRowMapper.newInstance(User.class));
		userList.forEach(System.out::println);
	}
}
