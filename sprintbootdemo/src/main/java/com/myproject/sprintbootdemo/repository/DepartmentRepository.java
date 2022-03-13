package com.myproject.sprintbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.sprintbootdemo.entity.Department;

/*
 * JPA Query Documentation : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 * 1) Use method names 
 * 2) JPQL queries @Query (if we can't use 1st option)
 * 3) Native Queries we can use the @Query with nativeQuery = true (if we can't use 1st and 2nd options )
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department getDepartmentByDepartmentName(String departmentName);
	
	public Department getDepartmentByDepartmentNameIgnoreCase(String departmentName);
}
