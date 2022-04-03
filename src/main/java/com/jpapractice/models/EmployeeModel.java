package com.jpapractice.models;

public class EmployeeModel
{
	private String id="";
	private String name="";
	private String address="";
	private double salary;
	private String city="";
	private DepartmentModel department;
	
	public EmployeeModel(String id, String name, String address, double salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.city = city;
	}
	public EmployeeModel(String id, String name, String address, double salary, String city,
			DepartmentModel department) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.city = city;
		this.department = department;
	}
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	public EmployeeModel() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return "EmployeeModel [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", city="
				+ city + ", department=" + department + "]";
	}
}
