package com.myproject.sprintbootdemo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.sprintbootdemo.entity.Department;
import com.myproject.sprintbootdemo.error.DepartmentNotFoundException;
import com.myproject.sprintbootdemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDeparments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDeparmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department not available");
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {

		Optional<Department> dbObject = departmentRepository.findById(departmentId);

		if (dbObject.isPresent()) {
			Department dbDepartment = dbObject.get();

			if (!Objects.isNull(dbDepartment.getDepartmentName()) && !"".equals(dbDepartment.getDepartmentName())) {
				dbDepartment.setDepartmentName(department.getDepartmentName());
			}
			if (!Objects.isNull(dbDepartment.getDepartmentAddress())
					&& !"".equals(dbDepartment.getDepartmentAddress())) {
				dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
			}
			if (!Objects.isNull(dbDepartment.getDepartmentCode()) && !"".equals(dbDepartment.getDepartmentCode())) {
				dbDepartment.setDepartmentCode(department.getDepartmentCode());
			}
			return departmentRepository.save(dbDepartment);
		}

		return null;
	}

	@Override
	public Department getDeparments(String departmentName) {
		return departmentRepository.getDepartmentByDepartmentNameIgnoreCase(departmentName);
	}

}
