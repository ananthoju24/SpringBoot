package com.myproject.sprintbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentID;
	@NotBlank(message = "Please add department name")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
