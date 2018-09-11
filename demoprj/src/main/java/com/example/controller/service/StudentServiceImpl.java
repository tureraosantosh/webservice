package com.example.controller.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.repo.StudentRepo;
import com.example.model.Student;

@Service
@Transactional
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepo studentRepo;

	public Student insert(Student student)
	{
		
		Student savedObject = studentRepo.save(student);
		return savedObject;
		
	}
	
	
}
