package com.myproject.sprintbootdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.sprintbootdemo.entity.Department;
import com.myproject.sprintbootdemo.error.DepartmentNotFoundException;

@Service
public interface DepartmentService {

	Department save(Department department);

	List<Department> getDeparments();

	Department getDeparmentById(Long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long departmentId);

	Department updateDepartmentById(Long departmentId, Department department);

	Department getDeparments(String departmentName);

}
