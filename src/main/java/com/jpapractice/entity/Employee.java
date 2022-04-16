package com.jpapractice.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@GeneratedValue
	long employee_id;
	String name;
	String address;
	double salary;
	String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = true, updatable = true)
	Department department;
	
	public Employee(long id, String name, String address, double salary, String city) {
		super();
		this.employee_id = id;
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
		return employee_id;
	}
	public void setId(long id) {
		this.employee_id = id;
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
		return "Employee [id=" + employee_id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", city=" + city
				+ "]";
	}
	public Employee(long id, String name, String address, double salary, String city, Department department) {
		super();
		this.employee_id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.city = city;
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, department, employee_id, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(department, other.department) && employee_id == other.employee_id
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
}