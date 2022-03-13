package com.myproject.sprintbootdemo.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

	private HttpStatus errorCode;
	private String errorMessage;
}
