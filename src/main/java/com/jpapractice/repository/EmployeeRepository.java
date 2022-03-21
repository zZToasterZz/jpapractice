package com.jpapractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpapractice.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	@Query(value = "select a from Employee a where a.name like CONCAT('%',:name,'%') and a.id like CONCAT('%',:id,'%') and a.address like CONCAT('%',:address,'%') and a.city like CONCAT('%',:city,'%') and salary like CONCAT('%',:salary,'%')")
	public List<Employee> searchEmployee(@Param("name")String name,@Param("address")String address,@Param("city")String city,@Param("salary")double salary,@Param("id")long id);
	
	@Query(value = "select a from Employee a where a.id like CONCAT('%',:id,'%') ")
	public List<Employee> queryTest(@Param("id")long id);
}