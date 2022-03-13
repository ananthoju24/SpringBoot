package com.myproject.sprintbootdemo.service  ;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myproject.sprintbootdemo.entity.Department;
import com.myproject.sprintbootdemo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@MockBean
	private DepartmentRepository departmentRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
				.departmentID(1L)
				.departmentName("Compliance")
				.departmentAddress("HYD")
				.build();
		Optional<Department> dep = Optional.of(department);
		System.out.println(departmentRepo);
		Mockito.when(departmentRepo.findById(1L)).thenReturn(dep);
	}

	@Test
	@DisplayName("Get Data when valid department id passed ")
	void whenValidDepartmentId_thenDepartmentShouldFound() {
		Optional<Department> deparment = departmentRepo.findById(1L);
		assertEquals("Compliance", deparment.get().getDepartmentName());
	}
	
	@Test
	@Disabled
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetDeparments() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetDeparmentsString() {
		fail("Not yet implemented");
	}

}
