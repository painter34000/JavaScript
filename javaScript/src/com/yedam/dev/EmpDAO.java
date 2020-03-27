package com.yedam.dev;

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
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEmp(Employee emp) {
		String sql = "insert into board \r\n" + 
				"values( (select nvl(max(board_no),0)+1 from board)\r\n" + 
				"         , 'BoardNo' -- 글번호\r\n" + 
				"         , 'Content'  -- 글내용\r\n" + 
				"         , 'Writer'  -- 작성자\r\n" + 
				"         , 'CreateDate'  -- 작성일\r\n" + 
				"         , sysdate);";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getBoardNo());
			pstmt.setString(2, emp.getContent());
			pstmt.setString(3, emp.getWriter());
			pstmt.setString(3, emp.getCreateDate());

			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getEmpList() {
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
//				emp.setEmployeeId(rs.getInt("employee_id"));
//				emp.setFirstName(rs.getString("first_Name"));
//				emp.setLastName(rs.getString("last_Name"));
//				emp.setEmail(rs.getString("email"));
//				emp.setPhoneNumber(rs.getString("phone_Number"));
//				emp.setHireDate(rs.getString("hire_Date"));
//				emp.setJobId(rs.getString("job_Id"));
//				emp.setSalary(rs.getInt("salary"));
//				emp.setCommissionPct(rs.getDouble("commission_Pct"));
//				emp.setManagerId(rs.getInt("manager_Id"));
//				emp.setDepartmentId(rs.getInt("department_Id"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}