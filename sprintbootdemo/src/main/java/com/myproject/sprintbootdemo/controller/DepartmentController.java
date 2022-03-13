package com.myproject.sprintbootdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.sprintbootdemo.entity.Department;
import com.myproject.sprintbootdemo.error.DepartmentNotFoundException;
import com.myproject.sprintbootdemo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Request to save the new department " + department);
		return departmentService.save(department);
	}

	@GetMapping("/departments")
	public List<Department> getDeparments() {
		return departmentService.getDeparments();
	}

	@GetMapping("/departments/{id}")
	public Department getDeparmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		logger.info("Request to fetch department " + departmentId);
		return departmentService.getDeparmentById(departmentId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}

	@GetMapping("/departments/name/{name}")
	public Department getDeparmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDeparments(departmentName);
	}
}
