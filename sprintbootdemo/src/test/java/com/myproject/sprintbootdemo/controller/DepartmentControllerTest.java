package com.myproject.sprintbootdemo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myproject.sprintbootdemo.entity.Department;
import com.myproject.sprintbootdemo.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder().departmentID(1L).departmentName("Casino").departmentCode("C-101")
				.departmentAddress("HYD").build();
	}

	@Test
	void saveDepartment() throws Exception {
		Department InputDepartment = Department.builder().departmentName("Casino").departmentCode("C-101")
				.departmentAddress("HYD").build();

		Mockito.when(departmentService.save(InputDepartment)).thenReturn(department);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
						.content("{\r\n" + "	\"departmentName\":\"Casino\",\r\n"
								+ "	\"departmentAddress\":\"HYD\",\r\n" + "	\"departmentCode\":\"C-101\"\r\n" + "}"))
				.andExpect(status().isOk());

	}

	/**
	 * @throws Exception
	 * here we are mocking DepartmentService as we are testing only Controller 
	 *  
	 */
	@Test
	void fetchDepartmentById() throws Exception {
		Mockito.when(departmentService.getDeparmentById(1L)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
