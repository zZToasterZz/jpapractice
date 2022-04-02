package com.jpapractice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@NamedQueries(
		@NamedQuery(name = "Employee.countEmployeesByDepartment", query = "select count(a) from Employee a group by a.department")
)
public class Employee
{
	@Id
	long id;
	String name;
	String address;
	double salary;
	String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Department department;
	
	public Employee(long id, String name, String address, double salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.city = city;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", city=" + city
				+ "]";
	}
}