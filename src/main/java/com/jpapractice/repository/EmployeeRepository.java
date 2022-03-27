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
	@Query(value = "select a from Employee a where a.id like CONCAT('%',:id,'%') and a.name like CONCAT('%',:name,'%') and a.address like CONCAT('%',:address,'%') and a.city like CONCAT('%',:city,'%')")
	public List<Employee> searchEmployee(@Param("id")String id,@Param("name")String name,@Param("address")String address,@Param("city")String city/*, @Param("salary")double salary*/);
}