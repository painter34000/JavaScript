package com.yedam.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Address {
	String name;
	String age;
	String phone;

	public Address(String name, String age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
}

public class CellPhone {

	static String fileName = "src/com/yedam/io/phoneList.txt";
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String menu = "";
		System.out.println("친구 연락처 관리");
		System.out.println("이름 입력");
		String name = scn.nextLine();
		System.out.println("나이 입력");
		String age = scn.nextLine();
		System.out.println("전화 번호 입력");
		String phone = scn.nextLine();

		Address addr = new Address(name, age, phone);
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write("\n" + addr.name + "," + addr.age + "," + addr.phone + "\n");
			fw.flush();
			fw.close();

		} catch (IOException e) {

		}
		
//		Address addre = new Address(name, age, phone)
//				try {
//					FileWriter fr = new FileWriter(fileName, true);
//					fr.write("\n"+ addre.name+","+addre.age+","+addre.phone+"\n");
//					fr.flush();
//					fr.close();
//				}catch (IOExeption) {
//					
//				}
		System.out.println("end of program");
	}
}
