package com.jpapractice.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Department
{
	@Id
	long id;
	String name;
	String description;
	
	@OneToMany
	@JoinColumn(name = "id")
	List<Employee> employees;

	public Department() {
		super();
	}

	public Department(long id, String name, String description, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + ", employees=" + employees
				+ "]";
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
}