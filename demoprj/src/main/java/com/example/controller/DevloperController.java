package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.service.StudentServiceImpl;
import com.example.model.Student;

@RestController
public class DevloperController {

	@Autowired

	private StudentServiceImpl studentService;

	@PostMapping("/getstudent")
	public Student student(@RequestBody Student student) {
		Student saved = studentService.insert(student);
		return saved;

	}

}
