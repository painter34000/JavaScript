package com.yedam.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn = null;
	public EmpDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url, user, passwd);
				System.out.println("정상 연결되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("정상연결되지 않았습니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public List<Student> getEmpList(){
		// firstNmae =>name, salary => age, email =>school
		String sql = "select first_name, salary, email from emp";
		List<Student> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Student s1 = new Student(rs.getString("first_name"),
						rs.getInt("salary"), rs.getString("email"));
				list.add(s1);				
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
