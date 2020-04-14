package com.yedam.config.JavaTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaTest1 {
	public static void main(String[] args) {

		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("접속실패");
		} catch (SQLException e) {
			System.out.println("접속실패");
		}

		List<JavaTestStream> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT first_name, salary FROM Employees");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new JavaTestStream(rs.getString("first_name"), rs.getInt("salary")));
			}
		} catch (SQLException e) {
			System.out.println("SQL 확인요망.");
		}
		Stream<JavaTestStream> stream = list.stream();
		stream.forEach((s) -> System.out.println(s.getFirstName() + ", " + s.getSalary()));
	}
}