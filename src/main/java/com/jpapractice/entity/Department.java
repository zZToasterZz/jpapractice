package com.jpapractice.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Department
{
	@Id
	@GeneratedValue
	long department_id;
	String name;
	String description;
	
	@OneToMany(mappedBy = "department")
	List<Employee> employees;

	public Department() {
		super();
	}
	public Department(long id, String name, String description) {
		super();
		this.department_id = id;
		this.name = name;
		this.description = description;
	}
	
	public Department(long id, String name, String description, List<Employee> employees) {
		super();
		this.department_id = id;
		this.name = name;
		this.description = description;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + department_id + ", name=" + name + ", description=" + description + ", employees=" + employees
				+ "]";
	}

	public long getId() {
		return department_id;
	}

	public void setId(long id) {
		this.department_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public int hashCode() {
		return Objects.hash(department_id, description, employees, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		return department_id == other.department_id && Objects.equals(description, other.description)
				&& Objects.equals(employees, other.employees) && Objects.equals(name, other.name);
	}
}