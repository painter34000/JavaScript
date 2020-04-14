package com.yedam.config.JavaTest1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JavaTest3 {

	class Employees {
		int salary;
		String firstName;

		public Employees(int salary, String firstName) {
			super();
			this.salary = salary;
			this.firstName = firstName;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	}// end of Employees

	public static class PropertiesEmployees {
		public static void main(String[] args) throws FileNotFoundException, IOException {
			Properties properties = new Properties();
			String path = PropertiesEmployees.class.getResource("database.properties").getPath();
			System.out.println(path);

			path = URLDecoder.decode(path, "UTF-8");
			properties.load(new FileReader(path));

			String firstName = (String) properties.setProperty("firstName", firstName);
			String salary = (String) properties.setProperty("salary", salary);

			System.out.println("firstName : " + firstName + ", salary : " + salary);
			Connection conn = null;
			
			
			List<> list = new ArrayList<>();
		}
	}
}
