package com.myproject.sprintbootdemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.myproject.sprintbootdemo.entity.Department;

/*
 * Using this to add the data need while testing , which will be deleted from db
 * after execution completes
 */
@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("Compliance").departmentAddress("HYD")
				.departmentCode("C-101").build();

		testEntityManager.persist(department);
	}

	@Test
	void whenFindById_thenReturnDepartment() {
		Department department = departmentRepo.findById(1L).get();
		assertEquals("Compliance", department.getDepartmentName());
	}

}
