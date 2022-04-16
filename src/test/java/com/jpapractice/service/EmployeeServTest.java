package com.jpapractice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpapractice.entity.Employee;
import com.jpapractice.models.EmployeeModel;
import com.jpapractice.repository.EmployeeRepository;

//@ExtendWith(MockitoExtension.class)
public class EmployeeServTest
{
	@Mock
	EmployeeRepository empRepo;
	
	EmployeeService empServ;
	
	EmployeeModel emp = new EmployeeModel();
	
	AutoCloseable autoCloseable;
	
	@BeforeEach
	void setUp()
	{
		autoCloseable= MockitoAnnotations.openMocks(this);
		
		this.empServ = new EmployeeService(empRepo);
		emp.setId("122");
	}
	
	@AfterEach
	void tearDown()
	{
		try {
			autoCloseable.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void searchEmployees()
	{
		List<Employee> res = new ArrayList<>();
		res.add(new Employee(1,"sunny","abc",55000,"lko"));
		
		List<EmployeeModel> test = new ArrayList<>();
		test.add(new EmployeeModel("1","sunny","abc",55000,"lko"));
		
		when(empRepo.searchEmployee("1", "", "", "")).thenReturn(res);
		
		EmployeeModel t = new EmployeeModel();
		t.setId("1");
		
		List<String> x = test.stream().map(Object::toString).collect(Collectors.toList());
		List<String> y = empServ.searchEmployees(t).stream().map(Object::toString).collect(Collectors.toList());
		
		assertEquals(x, y);
	}
}