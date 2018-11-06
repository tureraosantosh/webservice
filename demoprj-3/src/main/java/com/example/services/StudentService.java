package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	public Student save(@RequestBody Student student)
	{
		
		Student savedStudent = studentDao.save(student);
		
		return savedStudent;
		
		
	}

}
