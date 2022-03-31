package com.jpapractice.service;

import static org.mockito.Mockito.verify;

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
		empServ.searchEmployees(emp);
		verify(empRepo).searchEmployee(emp.getId(), emp.getName(), emp.getAddress(), emp.getCity());
	}
}