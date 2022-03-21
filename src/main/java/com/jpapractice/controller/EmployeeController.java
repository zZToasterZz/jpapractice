package com.jpapractice.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpapractice.entity.Employee;
import com.jpapractice.models.EmployeeModel;
import com.jpapractice.models.ResponseMessage;
import com.jpapractice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
	@Autowired
	EmployeeService empServ;
	
	@PostMapping("/search")
	public List<EmployeeModel> searchEmployees(@RequestBody EmployeeModel x)
	{
		//List<EmployeeModel> e = empServ.searchEmployees(x);
		List<EmployeeModel> e = empServ.queryTest(x);
		return e;
	}
	
	@GetMapping("/fetch")
	public List<EmployeeModel> getAllEmployees()
	{
		return empServ.getAllEmployees();
	}
	
	@GetMapping("/fetch/{id}")
	public EmployeeModel getEmployee(@PathVariable long id)
	{
		return empServ.getEmployeeById(id);
	}
	
	@PostMapping("/create")
	public String addEmployee(@RequestBody EmployeeModel e)
	{
		empServ.addEmployee(e);
		return "success";
	}
	
	@PostMapping("/createall")
	public String addEmployees(@RequestBody List<EmployeeModel> e)
	{
		empServ.addEmployee(e);
		return "success";
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody EmployeeModel e)
	{
		empServ.updateEmployee(e);
		return "success";
	}
	
	@PutMapping("/updateall")
	public ResponseMessage<String, List<Employee>> updateEmployee(@RequestBody List<EmployeeModel> e)
	{
		return empServ.updateEmployee(e);
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody EmployeeModel e)
	{
		return empServ.deleteEmployee(e);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		return empServ.deleteEmployee(id);
	}
	
	@DeleteMapping("/deleteall")
	public String deleteEmployees(@RequestBody List<EmployeeModel> e)
	{
		return empServ.deleteEmployee(e);
	}
}