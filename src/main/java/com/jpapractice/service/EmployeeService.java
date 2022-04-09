package com.jpapractice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpapractice.entity.Department;
import com.jpapractice.entity.Employee;
import com.jpapractice.models.EmployeeModel;
import com.jpapractice.models.ResponseMessage;
import com.jpapractice.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository empRepo;
	
	EmployeeService(EmployeeRepository e)
	{
		empRepo = e;
	}
	
	EmployeeService(){}
	
	public List<EmployeeModel> searchEmployees(EmployeeModel x)
	{
		List<EmployeeModel> r = empRepo.searchEmployee(x.getId(),x.getName(),x.getAddress(),x.getCity()/*,x.getSalary()*/).stream()
				.map(e -> {
					return new EmployeeModel(""+e.getId(), e.getName(), e.getAddress(), e.getSalary(), e.getCity());
				}).collect(Collectors.toList());
		
		return r;
	}
	
	public List<EmployeeModel> getAllEmployees()
	{
		List<Employee> e = empRepo.findAll();
		List<EmployeeModel> x = e.stream().map(i -> {
			return new EmployeeModel(""+i.getId(),i.getName(),i.getAddress(),i.getSalary(),i.getCity());
		}).collect(Collectors.toList());
		
		return x;
	}
	
	public EmployeeModel getEmployeeById(long id)
	{
		Optional<Employee> e = empRepo.findById(id);
		Employee em = e.get();
		EmployeeModel x = new EmployeeModel(""+em.getId(),em.getName(),em.getAddress(),em.getSalary(),em.getCity());
		
		return x;
	}
	
	public String addEmployee(EmployeeModel e)
	{
		Department department=new Department(0L,e.getDepartment().getName(),e.getDepartment().getDescription());
		Employee x = new Employee(0,e.getName(),e.getAddress(),e.getSalary(),e.getCity(),department);
		empRepo.save(x);
		return "success";
	}
	
	public String addEmployee(List<EmployeeModel> list)
	{
		List<Employee> x = list.stream().map(e -> {
			Department department=new Department(0L,e.getDepartment().getName(),e.getDepartment().getDescription());
			return new Employee(0L,e.getName(),e.getAddress(),e.getSalary(),e.getCity(),department);
		}).collect(Collectors.toList());
		
		empRepo.saveAll(x);
		return "success";
	}
	
	public String updateEmployee(EmployeeModel e)
	{
		if(Integer.parseInt(e.getId()) < 1)
		{
			return "failure";
		}
		
		Employee x = new Employee(Integer.parseInt(e.getId()),e.getName(),e.getAddress(),e.getSalary(),e.getCity());
		empRepo.save(x);
		return "success";
	}
	
	public ResponseMessage<String, List<Employee>> updateEmployee(List<EmployeeModel> list)
	{
		List<Employee> e = list.stream().filter(i -> Integer.parseInt(i.getId()) > 0).map(i -> {
			return new Employee(Integer.parseInt(i.getId()),i.getName(),i.getAddress(),i.getSalary(),i.getCity());
		}).collect(Collectors.toList());
		
		empRepo.saveAll(e);
		
		List<Employee> x = list.stream().filter(i -> Integer.parseInt(i.getId()) < 1).map(i -> {
			return new Employee(Integer.parseInt(i.getId()),i.getName(),i.getAddress(),i.getSalary(),i.getCity());
		}).collect(Collectors.toList());
		
		HashMap<String, List<Employee>> hm = new HashMap<>();
		hm.put("success", e);
		hm.put("failure", x);
		
		ResponseMessage<String, List<Employee>> res = new ResponseMessage<>();
		res.setMessage(hm);
		
		return res;
	}
	
	public String deleteEmployee(long id)
	{
		empRepo.deleteById(id);
		return "success";
	}
	
	public String deleteEmployee(EmployeeModel e)
	{
		Employee x = new Employee(Integer.parseInt(e.getId()),e.getName(),e.getAddress(),e.getSalary(),e.getCity());
		empRepo.delete(x);
		return "success";
	}
	
	public String deleteEmployee(List<EmployeeModel> list)
	{
		List<Employee> e = list.stream().map(i -> {
			return new Employee(Integer.parseInt(i.getId()),i.getName(),i.getAddress(),i.getSalary(),i.getCity());
		}).collect(Collectors.toList());
		
		empRepo.deleteAll(e);
		
		return "success";
	}
	
	public String deleteEmployee(long[] ids)
	{
		for(long id:ids)
		{
			deleteEmployee(id);
		}
		return "success";
	}
}