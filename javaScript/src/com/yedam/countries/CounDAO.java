package com.yedam.countries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CounDAO {

	Connection conn = null;
	
	public CounDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Countries> getCountryList() {
		String sql = "select*from countries";
		List<Countries> list = new ArrayList<>();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Countries coun = new Countries(rs.getString("country_ID"), rs.getString("country_name"),rs.getInt("region_id"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

				return list;
//		private String name;
//		private String id;
//		private int region;
		
//		country_id
//		country_name
//		region_id
	}
}
