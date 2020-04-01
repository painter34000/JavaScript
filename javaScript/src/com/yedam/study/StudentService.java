package com.yedam.study;

import java.util.List;

public interface StudentService {
	public List<Student> getStudList();
	
	
	public Student getStudent(int id);
	
//	public static void  main(String[] args) {
//		StudentService service = new StudentServiceImpl();
//		service.getStudList();		
//		service.getStudent(10);
//	}
	
}
