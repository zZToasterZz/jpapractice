package com.jpapractice.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpapractice.entity.Employee;
import com.jpapractice.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeRepoTest
{
	@Autowired
	EmployeeRepository empRepo;
	
	Employee e = new Employee(99, "XX", "XX", 999, "XX");
	
	@Test
	void searchEmployee()
	{
		empRepo.save(e);
		
		List<Employee> x = empRepo.searchEmployee("99", "", "", "");
		
		assertThat(e).isEqualToComparingFieldByField(x.get(0));
	}
	
	@AfterEach
	void tearDown()
	{
		empRepo.delete(e);
	}
}