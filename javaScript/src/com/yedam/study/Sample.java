package com.yedam.study;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static int sum(int a, int b) {
		return a + b;
	}
	
	
	public static int minus(int a, int b) {
		return a -b;
	}
	
	
	public static void main(String[] args) {
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.getStudList();
		for (Student s : list) {
			System.out.println(s.toString());
		}
	
	}
	public static void main(String[] args) {
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.getStudList();
		for (Student s : list) {
			System.out.println(s.toString());
		}
	
	}
	
//	public static void main(String[] args) {
//		EmpDAO dao = new EmpDAO();
//		List<Student> list = dao.getEmpList();
//		for (Student s : list) {
//			System.out.println(s.toString());
//		}
		
//		int result = sum(3, 9);
//		Sample s = new Sample();
//		int result1 = minus(6, 2);
		
		
//		Person p1 = new Person();
//		p1.setName("Hong");
//		p1.setAge(10);
//		Person p2 =new Person("Hwang", 21);
//		
//		
//		Student s1 = new Student();
//		s1.setName("Park");
//		s1.setAge(20);
//		s1.setSchool("yedam");
//		Student s2 = new Student("Kim", 22, "yedam");
//		System.out.println(s1, toString());
		
		
//		List<Person> list = new ArrayList<>();
//		list.add(p1);
//		list.add(p2);
//		list.add(s1);
//		list.add(s2);
//		
//		if(list.remove(p2)) {
//			System.out.println("삭제되었습니다");
//		}
//		for(Person p:list) {
//			System.out.println(p.toString());
//		}
		
		
//		String n = p1.getName();
//		int a = p1.getAge();
//		Person p2 = new Person("Hwang", 20);
//		System.out.println(p2.getName()+","+p2.getAge());
//		
//		Person[] persons = new Person[5];
//		persons[0] =p1;
//		persons[1] =s1;
//		persons[2] =new Student();
//		persons[3] =new Person("Lee", 25);
//		persons[4] =new Person();
//		
//		String searchName = "Park";
//		for (Person p : persons) {
//			if(p.getName() != null && p.getName().equals(searchName))
//			System.out.println("찾을이름:" +searchName+"  결과:"+p.toString());
//		}
		
	}

